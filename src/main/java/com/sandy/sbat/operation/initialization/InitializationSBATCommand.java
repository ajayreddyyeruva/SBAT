package com.sandy.sbat.operation.initialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sandy.sbat.common.Constants;
import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;

public class InitializationSBATCommand implements SBATCommand {
	WebDriver webDriver;
	private static String browser;
	private static String platform;
	
	@Override
	public SBATResponse execute(SBATRequest request) {
		// TODO Auto-generated method stub
		try 
		{
			InitializationSBATRequest initializationSBATRequest = (InitializationSBATRequest)request;
			browser = initializationSBATRequest.getBrowser();
			platform = initializationSBATRequest.getPlatform();
			System.out.println("Browser:"+browser);
			System.out.println("Platform:"+platform);
			
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName(browser);
			
				if (browser.equalsIgnoreCase(Constants.FIREFOX_BROWSER))
				{
					FirefoxProfile profile = new FirefoxProfile();
					if (platform.equalsIgnoreCase(Constants.iphone)) 
					{
						profile = new FirefoxProfile();
						profile.setPreference("general.useragent.override", Constants.iphone_UA);
					}
					if (platform.equalsIgnoreCase(Constants.android)) 
					{
						System.out.println("Test");
						profile = new FirefoxProfile();
						profile.setPreference("general.useragent.override", Constants.android_UA);
						System.out.println("Set done");
					}
					webDriver = new FirefoxDriver(profile);
				}
				else if (browser.equalsIgnoreCase(Constants.IE_BROWSER)){
					webDriver = new InternetExplorerDriver();	
				}

				else if (browser.equalsIgnoreCase("*chrome"))
					webDriver = new ChromeDriver();
				webDriver.get("http://www.snapdeal.com");
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return new InitializationSBATResponse();
	}

}
