package com.sandy.sbat.common;

/**
 * I'm the prime component of SBAT framework & define the contracts for all the commands that our system
 * will support
 * @author user
 *
 */
public interface SBATCommand {

	SBATResponse execute(SBATRequest request);
}
