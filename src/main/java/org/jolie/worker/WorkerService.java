/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jolie.worker;

import java.io.File;
import java.util.List;
import jolie.runtime.JavaService;
import jolie.runtime.Value;
import org.jolie.worker.file.FileSplitter;

/**
 *
 * @author zingaro
 */
public class WorkerService extends JavaService {

	public Value split( Value request ) {

		Value response = Value.create();

		String filePath = request.strValue();
		int parts = request.getFirstChild( "parts" ).intValue();

		FileSplitter splitter = new FileSplitter( new File( filePath ) );
		List<String> split = splitter.split( parts );

		split.forEach( ( s ) -> {
			response.getNewChild( "splits" ).setValue( s );
		} );

		return response;
	}

	public Value unsplit( Value request ) {

		Value response = Value.create();

		String filePath = request.strValue();

		FileSplitter splitter = new FileSplitter( new File( filePath ) );
		String unsplit = splitter.unsplit();

		response.setValue( unsplit );

		return response;
	}

}
