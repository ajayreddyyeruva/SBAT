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
 * @author user
 *
 */
public enum SBATRequestFactory {
	
	
	SINGLETON;
	
	private Map<String, SBATRequest> requestsMap = new LinkedHashMap<String, SBATRequest>();
	
	private SBATRequestFactory() {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();           
		InputStream stream = loader.getResourceAsStream("request_mapping.properties");
		try {
			prop.load(stream);
			for (Iterator entrySetIterator = prop.entrySet().iterator(); entrySetIterator.hasNext();) {
				Map.Entry<String, String> propertyEntry = (Map.Entry<String, String>) entrySetIterator.next();
				SBATRequest sbatRequest = (SBATRequest) Class.forName(propertyEntry.getValue()).newInstance();
				requestsMap.put(propertyEntry.getKey(), sbatRequest);
				
			}
			String value = prop.getProperty("open");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	SBATRequest getNewInstance(String requestString) {
		return requestsMap.get(requestString);
	}

}
