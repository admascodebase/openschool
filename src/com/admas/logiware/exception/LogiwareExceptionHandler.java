/*Copyright Currencies Direct Ltd 2015-2016. All rights reserved
worldwide. Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.*/
package com.admas.logiware.exception;

public class LogiwareExceptionHandler extends Exception {

	/**
	 * @author Sonal M.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	
	private LogiwareServiceErrors errorName;

	private String description;

	/**
	 * @return the errorName
	 */
	public LogiwareServiceErrors getErrorName() {
		return errorName;
	}

	/**
	 * @param errorName
	 *            the errorName to set
	 */
	public void setErrorName(LogiwareServiceErrors errorName) {
		this.errorName = errorName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Instantiates a new NGOP base exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param flowName
	 *            the flow name
	 * @param cause
	 *            the cause
	 */
	public LogiwareExceptionHandler(LogiwareServiceErrors errorName) {
		super(errorName.getErrorCode(), new Throwable(
				errorName.getErrorDescription()));
		this.errorCode = errorName.getErrorCode();
		this.errorName = errorName;
		this.description = errorName.getErrorDescription();
	}

	public LogiwareExceptionHandler(LogiwareServiceErrors errorName, String description) {
		super(errorName.getErrorCode(), new Throwable(description));
		this.errorName = errorName;
		this.description = description;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
