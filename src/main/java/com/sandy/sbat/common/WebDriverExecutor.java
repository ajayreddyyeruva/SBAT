package com.sandy.sbat.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public enum WebDriverExecutor{

	SINGLETON;
	
	WebDriver driver;
	private WebDriverExecutor(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	
	/**
	 * Need to fix it we should use some sort of wrapper
	 * @return
	 */
	public WebDriver getWebDriver(){
		return driver;
	}
	
}
