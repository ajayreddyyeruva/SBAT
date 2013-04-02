package com.sandy.sbat.operation.assertelmenttext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class AssertElementTextSBATCommand implements SBATCommand {

    private static boolean textCorrectnessFlag;
    
    public SBATResponse execute(SBATRequest request) {
        AssertElementTextSBATRequest assertElementTextSBATRequest = (AssertElementTextSBATRequest)request;
        System.out.println("asserting element's text '" +  assertElementTextSBATRequest.getTextToVerify()+ "'");
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        WebElement webElement = webDriver.findElement(By.xpath(assertElementTextSBATRequest.getTargetElementXPath()));
        textCorrectnessFlag = webElement.getText().equals(assertElementTextSBATRequest.getTextToVerify());
        System.out.println("Element Text Correct :: " + textCorrectnessFlag);
        return new AssertElementTextSBATResponse();
    }

    public boolean getTextCorrectnessFlag() {
        return textCorrectnessFlag;
    }
}
