/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.client;

/**
 * @author hitesh Constant file for Service EndPoints.
 *
 */
public class ServiceEndPointConstants {

	/**
	 * The Enum ServiceName.
	 */
	public enum ServiceName {
		
		login("login"),
		getAllCustomer("getAllCustomer"),
		getAllCity("getAllCity");

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new service name.
		 * 
		 * @param value
		 *            the value
		 */
		ServiceName(String value) {
			this.value = value;
		}

		/**
		 * Value.
		 * 
		 * @return the string
		 */
		public String value() {
			return value;
		}

	}

}
