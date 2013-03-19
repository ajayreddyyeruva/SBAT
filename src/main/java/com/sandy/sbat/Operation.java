package com.sandy.sbat;

public class Operation {

	private String commandString;
	private String parametersString;

	public Operation(String operationString) {
		int firstWordEndIndex = operationString.indexOf(" ");
		commandString = operationString.substring(0, firstWordEndIndex).trim();
		parametersString = operationString.substring(firstWordEndIndex).trim();
	}

	public String getCommandString() {
		return commandString;
	}

	public String getParametersString() {
		return parametersString;
	}

	@Override
	public String toString() {
		return "Operation [commandString=" + commandString
				+ ", parametersString=" + parametersString + "]";
	}
	
	

}
