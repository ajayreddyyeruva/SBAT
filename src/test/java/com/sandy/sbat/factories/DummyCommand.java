package com.sandy.sbat.factories;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;

public class DummyCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
		return null;
	}

}
