package com.sandy.sbat.factories;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;

public class DummyRequest implements SBATRequest {

	public SBATCommand getCommand() {
		return new DummyCommand();
	}

	public void initialize(String requestString) {
		
	}

}
