package com.sandy.sbat.factories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.operation.elementclick.ElementClickSBATCommand;
import com.sandy.sbat.operation.elementclick.ElementClickSBATRequest;
import com.sandy.sbat.operation.initialization.InitializationSBATCommand;
import com.sandy.sbat.operation.initialization.InitializationSBATRequest;
import com.sandy.sbat.operation.mousehover.MouseHoverSBATCommand;
import com.sandy.sbat.operation.mousehover.MouseHoverSBATRequest;
import com.sandy.sbat.operation.openurl.OpenUrlSBATCommand;
import com.sandy.sbat.operation.openurl.OpenUrlSBATRequest;
import com.sandy.sbat.operation.textboxinput.TextBoxInputSBATCommand;
import com.sandy.sbat.operation.textboxinput.TextBoxInputSBATRequest;
import com.sandy.sbat.operation.verifyallimages.VerifyAllImagesSBATCommand;
import com.sandy.sbat.operation.verifyallimages.VerifyAllImagesSBATRequest;
import com.sandy.sbat.operation.verifytextpresent.VerifyTextPresentSBATCommand;
import com.sandy.sbat.operation.verifytextpresent.VerifyTextPresentSBATRequest;

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
    public void testMouseHoverRequestCreation() throws Exception {
        SBATRequest mousehoverSBATRequest = SBATRequestFactory.SINGLETON.getNewInstance("mouseHover", "xpath");
        assertNotNull(mousehoverSBATRequest);
        assertTrue(mousehoverSBATRequest instanceof MouseHoverSBATRequest);
        assertEquals("xpath", ((MouseHoverSBATRequest)mousehoverSBATRequest).getTargetElementXPath());
        assertNotNull(mousehoverSBATRequest.getCommand());
        assertTrue(mousehoverSBATRequest.getCommand() instanceof MouseHoverSBATCommand);
    }
	
	@Test
	public void testRequestCreationForInvalidRequest() {
		SBATRequest dummySbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("dummy2", "param1 param2");
		assertNull(dummySbatRequest);
	}
	
	@Test
    public void testVerifyTextPresentRequestCreation() throws Exception {
        SBATRequest verifytextpresentSBATRequest = SBATRequestFactory.SINGLETON.getNewInstance("verifyTextPresent", "text");
        assertNotNull(verifytextpresentSBATRequest);
        assertTrue(verifytextpresentSBATRequest instanceof VerifyTextPresentSBATRequest);
        assertEquals("text", ((VerifyTextPresentSBATRequest)verifytextpresentSBATRequest).getTextToVerify());
        assertNotNull(verifytextpresentSBATRequest.getCommand());
        assertTrue(verifytextpresentSBATRequest.getCommand() instanceof VerifyTextPresentSBATCommand);
    }
	
	@Test
    public void testVerifyAllImagesRequestCreation() throws Exception {
        SBATRequest verifyallimagesSBATRequest = SBATRequestFactory.SINGLETON.getNewInstance("verifyAllImages", null);
        assertNotNull(verifyallimagesSBATRequest);
        assertTrue(verifyallimagesSBATRequest instanceof VerifyAllImagesSBATRequest);
        assertNotNull(verifyallimagesSBATRequest.getCommand());
        assertTrue(verifyallimagesSBATRequest.getCommand() instanceof VerifyAllImagesSBATCommand);
    }

	@Test
    public void testInitializationRequestCreation() throws Exception {
        SBATRequest intializationSbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("initialization", "firefox web");
        assertNotNull(intializationSbatRequest);
        assertTrue(intializationSbatRequest instanceof InitializationSBATRequest);
        assertNotNull(intializationSbatRequest.getCommand());
        assertTrue(intializationSbatRequest.getCommand() instanceof InitializationSBATCommand);
    }

}
