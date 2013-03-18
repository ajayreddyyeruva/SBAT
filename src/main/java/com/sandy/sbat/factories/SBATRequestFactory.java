package com.sandy.sbat.factories;

import com.sandy.sbat.common.SBATRequest;

/**
 * I'm a singleton class & I'll create instance of SBAT Requests
 * @author user
 *
 */
public enum SBATRequestFactory {
	
	SINGLETON;
	
	SBATRequest getNewInstance(String requestString) {
		return null;
	}

}
