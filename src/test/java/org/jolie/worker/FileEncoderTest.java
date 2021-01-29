/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jolie.worker;

import org.jolie.worker.file.FileEncoder;
import java.io.File;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zingaro
 */
public class FileEncoderTest {

	public FileEncoderTest() {
	}

	@Test
	public void testFileEncoder() {
		File file = new File( "/Users/zingaro/Code/java/jolie-file-worker/test/toSplit/test.m4p" );
		FileEncoder enc = new FileEncoder( file );
		System.out.println( "enc.decode(): " + enc.decode() );
	}

}
