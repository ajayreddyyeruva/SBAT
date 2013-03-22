package com.sandy.sbat.operation.asserttextpresent;

import com.sandy.sbat.common.AbstractSBATResponse;
import com.sandy.sbat.common.SBATStatus;

public class AssertTextPresentSBATResponse extends AbstractSBATResponse{
    
    private static boolean textPresentFlag;
    
    public AssertTextPresentSBATResponse() {
        AssertTextPresentSBATCommand assertTextPresentSBATCommand = new AssertTextPresentSBATCommand();
        textPresentFlag=assertTextPresentSBATCommand.getTextPresentFlag();
    }
    
    @Override
    public SBATStatus getStatus() {
        SBATStatus result = SBATStatus.SUCCESS;
        if(!textPresentFlag) {
            result = SBATStatus.FAILURE_TERMINATION;
        }
        return result;
    }
}
