package com.sandy.sbat.operation.textboxinput;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class TextBoxInputSBATRequest implements SBATRequest {

	private String text;
	private String targetElementXPath;
	
	public SBATCommand getCommand() {
		return new TextBoxInputSBATCommand();
	}

	public void initialize(String requestString) {
		String[] params = requestString.trim().split(" ",2);
		targetElementXPath = params[0];
		text = params[1];
	}
	
	public String getText() {
		return text;
	}
	
	public String getTargetElementXPath() {
		return targetElementXPath;
	}

}
