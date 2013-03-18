package com.sandy.sbat.factories;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.sandy.sbat.common.SBATRequest;
import com.sandy.sbat.operation.openurl.OpenUrlSBATCommand;
import com.sandy.sbat.operation.openurl.OpenUrlSBATRequest;

public class SBATRequestFactoryTest {

	@Test
	public void testRequestCreation() {
		SBATRequest dummySbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("dummy", "param1 param2");
		assertNotNull(dummySbatRequest);
		assertTrue(dummySbatRequest instanceof DummyRequest);
	}

	@Test
	public void testOpenUrlRequestCreation() throws Exception {
		SBATRequest openUrlSbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("openUrl", "http://yahoo.com");
		assertNotNull(openUrlSbatRequest);
		assertTrue(openUrlSbatRequest instanceof OpenUrlSBATRequest);
		assertEquals("http://yahoo.com", ((OpenUrlSBATRequest)openUrlSbatRequest).getUrl());
		assertNotNull(openUrlSbatRequest.getCommand());
		assertTrue(openUrlSbatRequest.getCommand() instanceof OpenUrlSBATCommand);
	}
	
	@Test
	public void testRequestCreationForInvalidRequest() {
		SBATRequest dummySbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("dummy2", "param1 param2");
		assertNull(dummySbatRequest);
	}

}
