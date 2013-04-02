package com.sandy.sbat.operation.verifyalllinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class VerifyAllLinksSBATCommand implements SBATCommand {

    public SBATResponse execute(SBATRequest request) {
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        List<WebElement> links = webDriver.findElements(By.tagName("a"));
        List<String> linkSources = new ArrayList<String> ();
        
        String source;
        
        for(int i=0;i<links.size();i++){
            source=links.get(i).getAttribute("href");
            if(null!=source){
                if(source.startsWith("http://")){
                    linkSources.add(source);    
                }
            }
        }
        
        System.out.println("Total Hyperlinks : "+linkSources.size());
        
        URL url = null;
        HttpURLConnection conn = null;
        int responseCode = 0;
        
        for(int i=0;i<linkSources.size();i++){
            
            try {
                url = new URL(linkSources.get(i));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            
            try {
                conn = (HttpURLConnection)url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            try {
                responseCode = conn.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if(responseCode==404){
                System.out.println("Link not accessible :: " + linkSources.get(i));
            }
            
            conn.disconnect();
        
        }
        
        return new VerifyAllLinksSBATResponse();
    }

}