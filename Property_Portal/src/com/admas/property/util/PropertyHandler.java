package com.admas.property.util;

/**
 * The Class PropertyHandler.
 * 
 * @author Amol S
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