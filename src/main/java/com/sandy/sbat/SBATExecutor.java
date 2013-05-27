package com.sandy.sbat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.common.SBATResponse;
import com.sandy.sbat.common.SBATStatus;
import com.sandy.sbat.common.WebDriverExecutor;
import com.sandy.sbat.factories.SBATRequestFactory;


/**
 * I'll execute a list of operations provided to me
 * @author user
 *
 */
public class SBATExecutor {
	
	public void execute(List<Operation> operations) {
		
		for (Operation operation : operations) {
			SBATResponse executeResponse = executeOperation(operation);
			if(executeResponse.getStatus().equals(SBATStatus.FAILURE_TERMINATION)) {
			    break;
			}
		}
		System.out.println("executing quit driver");
		WebDriverExecutor.SINGLETON.getWebDriver().quit();
	}

	private SBATResponse executeOperation(Operation operation) {
		System.out.println("Performing operation " + operation);
		SBATRequest sbatRequest = SBATRequestFactory.SINGLETON.getNewInstance(operation.getCommandString(), operation.getParametersString());
		SBATResponse sbatResponse=sbatRequest.getCommand().execute(sbatRequest);
		return sbatResponse;
	}
	
	public void execute(InputStream operationsFile) {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(operationsFile));
			String operationString;
			try {
				while ((operationString = br.readLine()) != null) {
					Operation operation = new Operation(operationString);
					SBATResponse executeResponse = executeOperation(operation);
		            if(executeResponse.getStatus().equals(SBATStatus.FAILURE_TERMINATION)) {
		                break;
		            }
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Executing Quit WebDriver");
		WebDriverExecutor.SINGLETON.getWebDriver().quit();
	}

}
