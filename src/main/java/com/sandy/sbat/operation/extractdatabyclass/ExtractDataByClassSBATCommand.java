package com.sandy.sbat.operation.extractdatabyclass;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class ExtractDataByClassSBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
		ExtractDataByClassSBATRequest extractDataByClassSBATRequest = (ExtractDataByClassSBATRequest)request;
		System.out.println("Extracting Data from div class " +  extractDataByClassSBATRequest.getclassName());
		WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
		List<WebElement> searchResults=webDriver.findElements(By.xpath(extractDataByClassSBATRequest.getclassName()));
		int size=searchResults.size();
		System.out.println(size);
		for(int i=0;i<size;i++){
		    System.out.println(searchResults.get(i));
		}
		return new ExtractDataByClassSBATResponse();
	}

}
