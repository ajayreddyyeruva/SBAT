package com.sandy.sbat.operation.verifyallimages;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class VerifyAllImagesSBATRequest implements SBATRequest {

    public SBATCommand getCommand() {
        return new VerifyAllImagesSBATCommand();
    }

    public void initialize(String requestString) {

    }

}
