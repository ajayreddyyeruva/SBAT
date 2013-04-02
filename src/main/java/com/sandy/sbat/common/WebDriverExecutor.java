package com.sandy.sbat.common;

import org.openqa.selenium.WebDriver;

public enum WebDriverExecutor{

	SINGLETON;
	
	WebDriver driver;
	private WebDriverExecutor(){
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
	}
	
	
	/**
	 * Need to fix it we should use some sort of wrapper
	 * @return
	 */
	public WebDriver getWebDriver(WebDriver driver){
	    this.driver=driver;
	    return driver;
	}
	
	public WebDriver getWebDriver() {
        return driver;
    }
}
