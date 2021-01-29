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

/**
 *
 * @author zingaro
 */
public class FileEncoder {

	private File f;

	public FileEncoder( File f ) {
		if ( f == null ) {
			throw new IllegalArgumentException( "File must be not null!" );
		}
		this.f = f;
	}

	public boolean encode() {
		try {
			File temp = new File( f.getPath() + ".tmp" );
			FileOutputStream fos;
			try (  FileInputStream fis = new FileInputStream( f ) ) {
				fos = new FileOutputStream( temp );
				byte[] buff = new byte[ 1024 ];
				int read = 0;
				while ( ( read = fis.read( buff ) ) > 0 ) {
					buff = FileEncoder.invertBuffer( buff, 0, read );
					fos.write( buff, 0, read );
				}
			}
			fos.flush();
			fos.close();

			f.delete();
			temp.renameTo( f );
			f = temp;
			return true;
		} catch ( IOException ex ) {
			return false;
		}
	}

	public static byte[] invertBuffer( byte[] buff, int offset, int length ) {
		if ( buff == null || buff.length == 0 ) {
			return null;
		}
		if ( offset < 0 || length < 0 ) {
			return null;
		}

		byte[] inverted = new byte[ length ];
		int ind = length - 1;
		for ( int i = offset; i < length; i++ ) {
			inverted[ ind ] = buff[ i ];
			ind--;
		}
		return inverted;
	}

	public boolean decode() {
		return this.encode();
	}

}
