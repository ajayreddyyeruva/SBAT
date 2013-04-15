package com.sandy.sbat.operation.takescreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sandy.sbat.common.SBATCommand;
import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.WebDriverExecutor;

public class TakeScreenshotSBATCommand implements SBATCommand {

	public SBATResponse execute(SBATRequest request) {
	    String outputFilePath=((TakeScreenshotSBATRequest)request).getOutputFilePath();
		System.out.println("Capturing Screenshot ");
		WebDriver webDriver = WebDriverExecutor.SINGLETON.getWebDriver();
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		try {
            FileUtils.copyFile(scrFile, new File(outputFilePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return new TakeScreenshotSBATResponse();
	}

}
