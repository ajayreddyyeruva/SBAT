package com.sandy.sbat.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import com.sandy.sbat.common.SBATRequest;

/**
 * I'm a singleton class & I'll create instance of SBAT Requests
 * 
 * @author user
 * 
 */
public enum SBATRequestFactory {

	SINGLETON;

	private Map<String, String> requestsMap = new LinkedHashMap<String, String>();

	private SBATRequestFactory() {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader
				.getResourceAsStream("request_mapping.properties");
		try {
			prop.load(stream);
			for (Iterator entrySetIterator = prop.entrySet().iterator(); entrySetIterator
					.hasNext();) {
				Map.Entry<String, String> propertyEntry = (Map.Entry<String, String>) entrySetIterator
						.next();
				requestsMap.put(propertyEntry.getKey(),
						propertyEntry.getValue());
			}
			String value = prop.getProperty("open");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SBATRequest getNewInstance(String commandString, String parameterString) {
		String sbatRequestFQCN = requestsMap.get(commandString);
		SBATRequest sbatRequest = null;
		if (null != sbatRequestFQCN) {
			try {
				sbatRequest = (SBATRequest) Class.forName(sbatRequestFQCN)
						.newInstance();
				sbatRequest.initialize(parameterString);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sbatRequest;
	}

}
