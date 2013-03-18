package com.sandy.sbat.operation.openurl;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class OpenUrlSBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
		WebDriverExecutor.SINGLETON.getWebDriver().get(((OpenUrlSBATRequest)request).getUrl());
		return new OpenUrlSBATResponse();
	}

}
