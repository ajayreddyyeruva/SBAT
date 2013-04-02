package com.sandy.sbat.operation.openurl;

import org.openqa.selenium.WebDriver;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class OpenUrlSBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
		WebDriver webDriver=WebDriverExecutor.SINGLETON.getWebDriver();
		webDriver.get(((OpenUrlSBATRequest)request).getUrl());
	    return new OpenUrlSBATResponse();
	}

}
