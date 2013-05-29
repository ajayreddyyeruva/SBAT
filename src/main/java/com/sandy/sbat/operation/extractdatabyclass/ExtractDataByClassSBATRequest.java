package com.sandy.sbat.operation.extractdatabyclass;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class ExtractDataByClassSBATRequest implements SBATRequest {

	private String className;

	
	public SBATCommand getCommand() {
		return new ExtractDataByClassSBATCommand();
	}

	public void initialize(String requestString) {
		className = requestString.trim();
	}
	
	public String getclassName() {
		return className;
	}

}
