package com.sandy.sbat.operation.loadcompletepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class LoadCompletePageSBATCommand implements SBATCommand {

    public SBATResponse execute(SBATRequest request) {
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        String s = null;
        while(true){
            if(webDriver.getPageSource().equals(s))break;
            s=webDriver.getPageSource();
            js.executeScript("window.scrollBy(0,1000)", "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return new LoadCompletePageSBATResponse();
    }

}
