package com.sandy.sbat.operation.verifyelementtext;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class VerifyElementTextSBATCommand implements SBATCommand {

    public SBATResponse execute(SBATRequest request) {
        VerifyElementTextSBATRequest verifyelementTextSBATRequest = (VerifyElementTextSBATRequest)request;
        System.out.println("Verifying Element's text '" +  verifyelementTextSBATRequest.getTextToVerify()+ "'");
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        WebElement webElement = webDriver.findElement(By.xpath(verifyelementTextSBATRequest.getTargetElementXPath()));
        boolean textCorrectnessFlag = webElement.getText().equals(verifyelementTextSBATRequest.getTextToVerify());
        System.out.println("Element Text Correct :: " + textCorrectnessFlag);
        return new VerifyElementTextSBATResponse();
    }

}
