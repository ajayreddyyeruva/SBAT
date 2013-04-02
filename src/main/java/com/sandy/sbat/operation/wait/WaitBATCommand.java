package com.sandy.sbat.operation.wait;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;

public class WaitBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
		WaitSBATRequest waitSBATRequest = (WaitSBATRequest)request;
		try {
            Thread.sleep(waitSBATRequest.getWaitingTime()* 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    return new WaitSBATResponse();
	}

}
