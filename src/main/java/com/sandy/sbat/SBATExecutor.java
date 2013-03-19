package com.sandy.sbat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.factories.SBATRequestFactory;


/**
 * I'll execute a list of operations provided to me
 * @author user
 *
 */
public class SBATExecutor {
	
	public void execute(List<Operation> operations) {
		
		for (Operation operation : operations) {
			executeOperation(operation);
		}
//		WebDriverExecutor.SINGLETON.getWebDriver().
	}

	private void executeOperation(Operation operation) {
		SBATRequest sbatRequest = SBATRequestFactory.SINGLETON.getNewInstance(operation.getCommandString(), operation.getParametersString());
		sbatRequest.getCommand().execute(sbatRequest);
	}
	
	public void execute(File operationsFile) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(operationsFile));
			String operationString;
			try {
				while ((operationString = br.readLine()) != null) {
					Operation operation = new Operation(operationString);
					executeOperation(operation);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
