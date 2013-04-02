package com.sandy.sbat.operation.loadcompletepage;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class LoadCompletePageSBATRequest implements SBATRequest {

    public SBATCommand getCommand() {
        return new LoadCompletePageSBATCommand();
    }

    public void initialize(String requestString) {

    }

}
