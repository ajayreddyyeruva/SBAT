package com.sandy.sbat.operation.wait;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class WaitSBATRequest implements SBATRequest{
	
    private long waitingTime;
    
	public SBATCommand getCommand() {
		return new WaitBATCommand();
	}

	public void initialize(String requestString) {
	    waitingTime = Long.parseLong(requestString);
	}
	
	public long getWaitingTime() {
        return waitingTime;
    }
}
