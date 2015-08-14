/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.client.ServiceInvoker;


/**
 * The Class ResourceHandler.
 */
public class ResourceHandler {

	/** The logger. */
	// private static WebLogger logger = new WebLogger(
	// ResourceHandler.class);

	Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);

	/** The service end points. */
	Properties serviceEndPoints = new Properties();

//	/** The q name. */
//	Properties qName = new Properties();
//
//	/** The roles. */
//	Properties roles = new Properties();
//
//	/** The quartz. */
//	Properties quartz = new Properties();

	/** The resource handler. */
	private static ResourceHandler resourceHandler = new ResourceHandler();

	/**
	 * Instantiates a new resource handler.
	 */
	ResourceHandler() {
		try {

			serviceEndPoints.load(this.getClass().getResourceAsStream(
					"serviceEndPoints.properties"));
//			qName.load(this.getClass().getResourceAsStream("QName.properties"));
//			// used in catch error
//			roles.load(this.getClass().getResourceAsStream("role.properties"));
//			quartz.load(this.getClass()
//					.getResourceAsStream("quartz.properties"));

			/*
			 * resouceMappings.load(this.getClass().getResourceAsStream(
			 * "resouceMappings.properties"));
			 */
			// prop.load(new FileInputStream("resource.properties"));
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

	/**
	 * Gets the q name.
	 * 
	 * @param key
	 *            the key
	 * @return the q name
	 */
//	public String getQName(String key) {
//		return ((String) qName.get(key));
//	}

	/**
	 * Gets the roles.
	 * 
	 * @param key
	 *            the key
	 * @return the roles
	 */
//	public String getRoles(String key) {
//		return ((String) roles.get(key));
//	}

	/**
	 * Gets the quartz.
	 * 
	 * @param key
	 *            the key
	 * @return the quartz
	 */
//	public String getQuartz(String key) {
//		return ((String) quartz.get(key));
//	}

}
