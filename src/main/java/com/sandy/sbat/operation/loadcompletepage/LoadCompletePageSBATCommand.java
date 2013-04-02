package com.sandy.sbat.operation.loadcompletepage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
