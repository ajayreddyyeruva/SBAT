package com.sandy.sbat.operation.verifytextpresent;

import org.openqa.selenium.WebDriver;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class VerifyTextPresentSBATCommand implements SBATCommand {

    public SBATResponse execute(SBATRequest request) {
        VerifyTextPresentSBATRequest verifyTextPresentSBATRequest = (VerifyTextPresentSBATRequest)request;
        System.out.println("Verifying text present '" +  verifyTextPresentSBATRequest.getTextToVerify()+ "'");
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        boolean textPresentFlag = webDriver.getPageSource().contains(verifyTextPresentSBATRequest.getTextToVerify());
        System.out.println("Text Present :: " + textPresentFlag);
        return new VerifyTextPresentSBATResponse();
    }

}
