package com.sandy.sbat.operation.verifyelementtext;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class VerifyElementTextSBATRequest implements SBATRequest {

    private String textToVerify;
    private String targetElementXPath;
    
    public SBATCommand getCommand() {
        return new VerifyElementTextSBATCommand();
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
