package com.sandy.sbat.operation.verifyallimages;

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

public class VerifyAllImagesSBATCommand implements SBATCommand {

    public SBATResponse execute(SBATRequest request) {
        WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
        System.out.println("Verifying all images on current page");
        List<WebElement> images = webDriver.findElements(By.tagName("img"));      
        List<String> imageSources = new ArrayList<String> ();
        String source;
        
        for(int i=0;i<images.size();i++){
            source=images.get(i).getAttribute("src");
            if(null!=source){
                if(source.startsWith("http://")){
                    imageSources.add(source);    
                }
            }
        }
        
        URL url = null;
        HttpURLConnection conn = null;
        int responseCode = 0;
        
        for(int i=0;i<imageSources.size();i++){
            
            try {
                url = new URL(imageSources.get(i));
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
                System.out.println("Image not accessible :: " + imageSources.get(i));
            }
            
            conn.disconnect();
            
        }
        
        return new VerifyAllImagesSBATResponse();
    }

}
