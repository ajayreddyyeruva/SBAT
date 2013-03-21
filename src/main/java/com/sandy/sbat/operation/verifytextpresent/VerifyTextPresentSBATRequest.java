package com.sandy.sbat.operation.verifytextpresent;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class VerifyTextPresentSBATRequest implements SBATRequest {

    private String textToVerify;
    
    public SBATCommand getCommand() {
        return new VerifyTextPresentSBATCommand();
    }

    public void initialize(String requestString) {
        textToVerify=requestString.trim();
    }
    
    public String getTextToVerify() {
        return textToVerify;
    }

}
