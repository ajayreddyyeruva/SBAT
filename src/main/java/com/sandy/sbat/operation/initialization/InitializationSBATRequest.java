package com.sandy.sbat.operation.initialization;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class InitializationSBATRequest implements SBATRequest {
	
	private String browser = null;
	private String platform = null;


	public SBATCommand getCommand() {
		return new InitializationSBATCommand();
	}

	public void initialize(String requestString) {
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
