package com.sandy.sbat.operation.openurl;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class OpenUrlSBATRequest implements SBATRequest{
	
	private String url;

	public SBATCommand getCommand() {
		return new OpenUrlSBATCommand();
	}

	public void initialize(String requestString) {
		url = requestString;
	}
	
	public String getUrl() {
		return url;
	}

}
