package com.sandy.sbat.operation.takescreenshot;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class TakeScreenshotSBATRequest implements SBATRequest{
	
    private String outputFilePath;
	public SBATCommand getCommand() {
		return new TakeScreenshotSBATCommand();
	}

	public void initialize(String requestString) {
	    outputFilePath=requestString;
	}
	
	public String getOutputFilePath() {
        return outputFilePath;
    }
}
