package com.sandy.sbat.operation.textboxinput;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class TextBoxInputSBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
		TextBoxInputSBATRequest textBoxInputSBATRequest = (TextBoxInputSBATRequest)request;
		System.out.println("Input '"+textBoxInputSBATRequest.getText()+"' in an element with xpath " +  textBoxInputSBATRequest.getTargetElementXPath());
		WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
		WebElement textBoxElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textBoxInputSBATRequest.getTargetElementXPath())));
		textBoxElement.sendKeys(textBoxInputSBATRequest.getText());
		return new TextBoxInputSBATResponse();
	}

}
