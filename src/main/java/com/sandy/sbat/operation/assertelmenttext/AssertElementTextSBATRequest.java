package com.sandy.sbat.operation.assertelmenttext;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class AssertElementTextSBATRequest implements SBATRequest {

    private String textToVerify;
    private String targetElementXPath;
    
    public SBATCommand getCommand() {
        return new AssertElementTextSBATCommand();
    }

    public void initialize(String requestString) {
        String params[] =requestString.trim().split(" ", 2);
        targetElementXPath=params[0];
        textToVerify=params[1];
    }
    
    public String getTextToVerify() {
        return textToVerify;
    }
    
    public String getTargetElementXPath() {
        return targetElementXPath;
    }

}
