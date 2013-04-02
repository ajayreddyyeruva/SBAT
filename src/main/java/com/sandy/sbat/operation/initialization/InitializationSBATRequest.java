package com.sandy.sbat.operation.initialization;

import java.util.List;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class InitializationSBATRequest implements SBATRequest {
	
	private String browser = null;
	private String platform = null;


	@Override
	public SBATCommand getCommand() {
		// TODO Auto-generated method stub
		return new InitializationSBATCommand();
	}

	@Override
	public void initialize(String requestString) {
		// TODO Auto-generated method stub
		
		String[] parameters = requestString.split(" ",2);
		browser = parameters[0];
		System.out.println(browser);
		platform = parameters[1];
	}
	
	public String getBrowser() {
		return browser;
	}
	
	public String getPlatform() {
		return platform;
	}

}
