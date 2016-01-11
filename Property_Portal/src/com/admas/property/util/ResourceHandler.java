package com.admas.property.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ResourceHandler.
 */
public class ResourceHandler {

	Logger logger = LoggerFactory.getLogger(ResourceHandler.class);

	/** The service end points. */
	Properties serviceEndPoints = new Properties();

	/** The resource handler. */
	private static ResourceHandler resourceHandler = new ResourceHandler();

	/**
	 * Instantiates a new resource handler.
	 */
	ResourceHandler() {
		try {

			serviceEndPoints.load(this.getClass().getResourceAsStream(
					"serviceEndPoints.properties"));
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
	}

	/**
	 * Instance.
	 * 
	 * @return the resource handler
	 */
	public static synchronized ResourceHandler instance() {
		if (resourceHandler == null)
			resourceHandler = new ResourceHandler();
		return resourceHandler;
	}

	/**
	 * Gets the service end points.
	 * 
	 * @param key
	 *            the key
	 * @return the service end points
	 */
	public String getServiceEndPoints(String key) {
		return ((String) serviceEndPoints.get(key));
	}
}
