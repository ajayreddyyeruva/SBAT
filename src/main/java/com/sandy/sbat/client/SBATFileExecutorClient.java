package com.sandy.sbat.client;

import java.io.InputStream;

import com.sandy.sbat.SBATExecutor;

public class SBATFileExecutorClient {
    
	public static void main(String[] args) {
		SBATExecutor sbatExecutor = new SBATExecutor();
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		InputStream in = loader.getResourceAsStream("buy_flow.txt");
		sbatExecutor.execute(in);
	}
	
}