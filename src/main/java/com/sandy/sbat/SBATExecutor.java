package com.sandy.sbat;

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
			SBATRequest sbatRequest = SBATRequestFactory.SINGLETON.getNewInstance(operation.getCommandString(), operation.getParametersString());
			sbatRequest.getCommand().execute(sbatRequest);
		}
//		WebDriverExecutor.SINGLETON.getWebDriver().
	}

}
