package com.sandy.sbat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperationTest {

	@Test
	public void testOperationCreation() {
		Operation operation = new Operation("command param");
		assertEquals("command", operation.getCommandString());
		assertEquals("param", operation.getParametersString());
	}

	@Test
	public void testOperationCreationWithMultipleParams() {
		Operation operation = new Operation("command param1 param2");
		assertEquals("command", operation.getCommandString());
		assertEquals("param1 param2", operation.getParametersString());
	}

}
