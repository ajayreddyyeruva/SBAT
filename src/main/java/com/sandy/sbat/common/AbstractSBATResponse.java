package com.sandy.sbat.common;

public abstract class AbstractSBATResponse implements SBATResponse{

    public SBATStatus getStatus() {
        return SBATStatus.SUCCESS;
    }
}
