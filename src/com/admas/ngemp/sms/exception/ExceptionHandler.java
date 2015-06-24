/*Copyright Currencies Direct Ltd 2015-2016. All rights reserved
worldwide. Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.*/
package com.admas.ngemp.sms.exception;

public class ExceptionHandler extends Exception {

	/**
	 * @author Sonal M.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommServiceErrors errorName;

	private String description;

	/**
	 * @return the errorName
	 */
	public CommServiceErrors getErrorName() {
		return errorName;
	}

	/**
	 * @param errorName
	 *            the errorName to set
	 */
	public void setErrorName(CommServiceErrors errorName) {
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
	public ExceptionHandler(CommServiceErrors errorName) {
		super(errorName.getErrorCode(), new Throwable(
				errorName.getErrorDescription()));
		this.errorName = errorName;
		this.description = errorName.getErrorDescription();
	}

	public ExceptionHandler(CommServiceErrors errorName, String description) {
		super(errorName.getErrorCode(), new Throwable(description));
		this.errorName = errorName;
		this.description = description;
	}

}
