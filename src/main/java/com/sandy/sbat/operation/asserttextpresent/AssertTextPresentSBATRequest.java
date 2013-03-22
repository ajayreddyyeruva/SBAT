package com.sandy.sbat.operation.asserttextpresent;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class AssertTextPresentSBATRequest implements SBATRequest {

    private String textToVerify;
    
    public SBATCommand getCommand() {
        return new AssertTextPresentSBATCommand();
    }

    public void initialize(String requestString) {
        textToVerify=requestString.trim();
    }
    
    public String getTextToVerify() {
        return textToVerify;
    }

}
