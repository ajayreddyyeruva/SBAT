package com.sandy.sbat.operation.verifyurl;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class VerifyURLSBATRequest implements SBATRequest {

    private String expectedURL;

	
	public SBATCommand getCommand() {
		return new VerifyURLSBATCommand();
	}

	public void initialize(String requestString) {
	    expectedURL = requestString;
	}
	
	public String getExpectedURL() {
        return expectedURL;
    }

}
