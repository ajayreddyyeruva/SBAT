package com.sandy.sbat.operation.elementclick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class ElementClickSBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
		ElementClickSBATRequest elementClickSBATRequest = (ElementClickSBATRequest)request;

		System.out.println("Performing element click for xpath " +  elementClickSBATRequest.getTargetElementXPath());
		WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 300);
		WebElement textBoxElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementClickSBATRequest.getTargetElementXPath())));
		textBoxElement.click();
		return new ElementClickSBATResponse();

	}

}
