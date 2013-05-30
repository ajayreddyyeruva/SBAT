package com.sandy.sbat.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.sandy.sbat.SBATExecutor;

public class SBATFileExecutorClient {
    
	public static void main(String[] args) {
		SBATExecutor sbatExecutor = new SBATExecutor();
		String filePath=System.getProperty("user.dir")+"/../TestScripts/buy_flow.txt";
		File file = new File(filePath);
		InputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		sbatExecutor.execute(in);
	}
	
}