package com.sandy.sbat.factories;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.operation.elementclick.ElementClickSBATCommand;
import com.sandy.sbat.operation.elementclick.ElementClickSBATRequest;
import com.sandy.sbat.operation.openurl.OpenUrlSBATCommand;
import com.sandy.sbat.operation.openurl.OpenUrlSBATRequest;
import com.sandy.sbat.operation.textboxinput.TextBoxInputSBATCommand;
import com.sandy.sbat.operation.textboxinput.TextBoxInputSBATRequest;

public class SBATRequestFactoryTest {

	@Test
	public void testRequestCreation() {
		SBATRequest dummySbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("dummy", "param1 param2");
		assertNotNull(dummySbatRequest);
		assertTrue(dummySbatRequest instanceof DummyRequest);
	}

	@Test
	public void testOpenUrlRequestCreation() throws Exception {
		SBATRequest openUrlSBATRequest = SBATRequestFactory.SINGLETON.getNewInstance("openUrl", "http://yahoo.com");
		assertNotNull(openUrlSBATRequest);
		assertTrue(openUrlSBATRequest instanceof OpenUrlSBATRequest);
		assertEquals("http://yahoo.com", ((OpenUrlSBATRequest)openUrlSBATRequest).getUrl());
		assertNotNull(openUrlSBATRequest.getCommand());
		assertTrue(openUrlSBATRequest.getCommand() instanceof OpenUrlSBATCommand);
	}

	@Test
	public void testTextBoxInputRequestCreation() throws Exception {
		SBATRequest textBoxInputSBATRequest = SBATRequestFactory.SINGLETON.getNewInstance("textBoxInput", "xpath value");
		assertNotNull(textBoxInputSBATRequest);
		assertTrue(textBoxInputSBATRequest instanceof TextBoxInputSBATRequest);
		assertEquals("xpath", ((TextBoxInputSBATRequest)textBoxInputSBATRequest).getTargetElementXPath());
		assertEquals("value", ((TextBoxInputSBATRequest)textBoxInputSBATRequest).getText());
		assertNotNull(textBoxInputSBATRequest.getCommand());
		assertTrue(textBoxInputSBATRequest.getCommand() instanceof TextBoxInputSBATCommand);
	}

	@Test
	public void testElementClickRequestCreation() throws Exception {
		SBATRequest elementClickSBATRequest = SBATRequestFactory.SINGLETON.getNewInstance("clickElement", "xpath");
		assertNotNull(elementClickSBATRequest);
		assertTrue(elementClickSBATRequest instanceof ElementClickSBATRequest);
		assertEquals("xpath", ((ElementClickSBATRequest)elementClickSBATRequest).getTargetElementXPath());
		assertNotNull(elementClickSBATRequest.getCommand());
		assertTrue(elementClickSBATRequest.getCommand() instanceof ElementClickSBATCommand);
	}
	
	@Test
	public void testRequestCreationForInvalidRequest() {
		SBATRequest dummySbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("dummy2", "param1 param2");
		assertNull(dummySbatRequest);
	}

}
