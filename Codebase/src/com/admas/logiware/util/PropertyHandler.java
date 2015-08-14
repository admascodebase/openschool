/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */

package com.admas.logiware.util;

/**
 * The Class PropertyHandler.
 * 
 * @author aniketk
 */
public class PropertyHandler {

	/**
	 * Gets the property.
	 * 
	 * @param propertyName
	 *            the property name
	 * @return the property
	 */
	public static String getProperty(String propertyName) {
		try {
			return System.getProperty(propertyName).trim();
		} catch (Exception e) {
			System.out.println("	Error For [key:" + propertyName + "]	Message:"
					+ e.getMessage());
			return null;
		}
	}
}