package com.sandy.sbat.operation.elementclick;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class ElementClickSBATRequest implements SBATRequest {

	private String targetElementXPath;

	
	public SBATCommand getCommand() {
		return new ElementClickSBATCommand();
	}

	public void initialize(String requestString) {
		targetElementXPath = requestString.trim();
	}
	
	public String getTargetElementXPath() {
		return targetElementXPath;
	}

}
