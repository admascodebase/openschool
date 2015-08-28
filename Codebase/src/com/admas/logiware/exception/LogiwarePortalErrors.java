/**
 * CDTemplate
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 */
package com.admas.logiware.exception;

/**
 * @author Yogesh B
 * 
 */
public enum LogiwarePortalErrors {

	/**
	 * SUCCESS Rest Response
	 */
	SUCCESS("0000", "Success"),

	INVALID_REQUEST("9000", "Invalid request"),
	
	GENERIC_EXCEPTION("9999", "Generik exception");

				
	
	

	/**
	 * variable for error code
	 */
	private String errorCode;
	/**
	 * variable for error code
	 */
	private String errorDescription;

	/**
	 * @param errorCode
	 * @param errorDescription
	 */
	private LogiwarePortalErrors(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	/**
	 * @return error description
	 */
	public String getErrorDescription() {
		return this.errorDescription;
	}

	/**
	 * @return error code
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return this.errorCode + ":" + this.errorDescription;
	}
}
