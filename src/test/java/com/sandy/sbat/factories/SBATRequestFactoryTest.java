package com.sandy.sbat.factories;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.sandy.sbat.common.SBATRequest;

public class SBATRequestFactoryTest {

	@Test
	public void testRequestCreation() {
		SBATRequest dummySbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("dummy", "param1 param2");
		assertNotNull(dummySbatRequest);
		assertTrue(dummySbatRequest instanceof DummyRequest);
	}

	@Test
	public void testRequestCreationForInvalidRequest() {
		SBATRequest dummySbatRequest = SBATRequestFactory.SINGLETON.getNewInstance("dummy2", "param1 param2");
		assertNull(dummySbatRequest);
	}

}
