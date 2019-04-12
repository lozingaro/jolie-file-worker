/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jolie.worker;

import org.jolie.worker.file.FileSplitter;
import java.io.File;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zingaro
 */
public class FileSplitterTest {

	int parts;

	public FileSplitterTest() {
		this.parts = 3;
	}

	@Test
	public void testFileSplitter() {

		File file = new File( "/Users/zingaro/Code/java/jolie-file-worker/test/toSplit/test.m4p" );
		FileSplitter splitter = new FileSplitter( file );
		System.out.println( "splitter.split(3): " + splitter.split( this.parts ) );
	}

	@Test
	public void testFileUnsplitter() {

		File file = new File( "/Users/zingaro/Code/java/jolie-file-worker/test/toUnsplit/test.m4p.part.0" );
		FileSplitter splitter = new FileSplitter( file );
		System.out.println( "splitter.unsplit(): " + splitter.unsplit() );
	}

}
