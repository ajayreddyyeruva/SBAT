package com.sandy.sbat.client;

import java.io.File;

import com.sandy.sbat.SBATExecutor;

public class SBATFileExecutorClient {
    
	public static void main(String[] args) {
		SBATExecutor sbatExecutor = new SBATExecutor();
		sbatExecutor.execute(new File("src/test/resources/sample.txt"));
	}
	
}