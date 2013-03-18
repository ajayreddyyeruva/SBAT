package com.sandy.sbat.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum WebDriverExecutor{

	SINGLETON;
	
	WebDriver driver;
	private WebDriverExecutor(){
		driver = new FirefoxDriver();
	}
	
	
	/**
	 * Need to fix it we should use some sort of wrapper
	 * @return
	 */
	public WebDriver getWebDriver(){
		return driver;
	}
	
}