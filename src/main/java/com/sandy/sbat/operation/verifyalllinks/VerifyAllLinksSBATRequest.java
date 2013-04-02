package com.sandy.sbat.operation.verifyalllinks;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class VerifyAllLinksSBATRequest implements SBATRequest {

    public SBATCommand getCommand() {
        return new VerifyAllLinksSBATCommand();
    }

    public void initialize(String requestString) {

    }

}
