package com.sandy.sbat.operation.assertelmenttext;

import com.sandy.sbat.common.AbstractSBATResponse;
import com.sandy.sbat.common.SBATStatus;

public class AssertElementTextSBATResponse extends AbstractSBATResponse{
    
    private static boolean textCorrectnessFlag;
    
    public AssertElementTextSBATResponse() {
        AssertElementTextSBATCommand assertElementTextSBATCommand = new AssertElementTextSBATCommand();
        textCorrectnessFlag=assertElementTextSBATCommand.getTextCorrectnessFlag();
    }
    
    @Override
    public SBATStatus getStatus() {
        SBATStatus result = SBATStatus.SUCCESS;
        if(!textCorrectnessFlag) {
            result = SBATStatus.FAILURE_TERMINATION;
        }
        return result;
    }
}
