/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jolie.worker.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author zingaro
 */
public class FileSplitter {

	private File f;

	public FileSplitter( File f ) {
		if ( f == null ) {
			throw new IllegalArgumentException( "File must be not null!" );
		}
		this.f = f;
//		System.out.println( "File Length (KB): " + f.length() / 1024.0 );
	}

	public List<String> split( long size ) {

		List<String> list = new LinkedList<>();

		if ( size <= 0 ) {
			return list;
		}

		try {
			int parts = ( ( int ) ( f.length() / size ) );
			long flength = 0;
			if ( f.length() % size > 0 ) {
				parts++;
			}

			File[] fparts = new File[ parts ];

			try (  FileInputStream fis = new FileInputStream( f ) ) {
				FileOutputStream fos = null;

				for ( int i = 0; i < fparts.length; i++ ) {
					fparts[ i ] = new File( f.getPath() + ".part." + i );
					fos = new FileOutputStream( fparts[ i ] );

					int read = 0;
					long total = 0;
					byte[] buff = new byte[ 1024 ];
					int origbuff = buff.length;
					while ( total < size ) {
						read = fis.read( buff );
						if ( read != -1 ) {
							buff = FileEncoder.invertBuffer( buff, 0, read );
							total += read;
							flength += read;
							fos.write( buff, 0, read );
						}
						if ( i == fparts.length - 1 && read < origbuff ) {
							break;
						}
					}

					fos.flush();
					fos.close();
					fos = null;
				}
			}
			// f.delete();
			f = fparts[ 0 ];

//			System.out.println( "Length Readed (KB): " + flength / 1024.0 );
			for ( File fpart : fparts ) {
				list.add( fpart.getAbsolutePath() );
			}
		} catch ( IOException ex ) {
//			System.out.println( ex );
//			System.out.println( ex.getLocalizedMessage() );
//			System.out.println( ex.getStackTrace()[ 0 ].getLineNumber() );
			return list;
		}
		return list;
	}

	public List<String> split( int parts ) {

		List<String> list = new LinkedList<>();

		if ( parts <= 0 ) {
			return list;
		}

		return this.split( f.length() / parts );
	}

	public String unsplit() {
		try {
			LinkedList<File> list = new LinkedList<>();
			boolean exists = true;
			File temp = null;
			File dest = new File( f.getPath().substring( 0,
				f.getPath().lastIndexOf( ".part" ) ) );
			FileInputStream fis = null;
			long flength;
			try (  FileOutputStream fos = new FileOutputStream( dest ) ) {
				int part = 0;
				flength = 0;
				String name = null;
				while ( exists ) {
					name = f.getPath();
					name = name.substring( 0, name.lastIndexOf( "." ) + 1 ) + part;
					temp = new File( name );

					exists = temp.exists();
					if ( !exists ) {
						break;
					}

					fis = new FileInputStream( temp );
					byte[] buff = new byte[ 1024 ];

					int read = 0;
					while ( ( read = fis.read( buff ) ) > 0 ) {
						buff = FileEncoder.invertBuffer( buff, 0, read );
						fos.write( buff, 0, read );
						if ( read > 0 ) {
							flength += read;
						}
					}
					fis.close();
					fis = null;
					temp.delete();
					part++;
				}
				fos.flush();
			}
			f = dest;
//			System.out.println( "Length Writed: " + flength / 1024.0 );
			return f.getPath();
		} catch ( IOException ex ) {
			return "";
		}
	}
}
