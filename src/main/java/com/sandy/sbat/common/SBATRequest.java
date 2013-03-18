package com.sandy.sbat.common;

/**
 * I'll define a contract for all the requests done to SBAT framework
 * @author user
 *
 */
public interface SBATRequest extends Cloneable{

	SBATCommand getCommand();
	void initialize(String requestString);
}
