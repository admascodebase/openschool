/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class WebAppRuntimeException.
 */
public class WebAppRuntimeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2497485780260884133L;

	/** The error code. */
	protected String errorCode;

	/** The error msg. */
	protected String errorMsg;

	/**
	 * Gets the error msg.
	 * 
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Sets the error msg.
	 * 
	 * @param errorMsg
	 *            the new error msg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Instantiates a new web app runtime exception.
	 */
	public WebAppRuntimeException() {
		super();
	}

	/**
	 * Instantiates a new web app runtime exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public WebAppRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new web app runtime exception.
	 * 
	 * @param errorCode
	 *            the error code
	 */
	public WebAppRuntimeException(String errorCode) {
		super();
	}

	/**
	 * Instantiates a new web app runtime exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param message
	 *            the message
	 */
	public WebAppRuntimeException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.errorMsg = message;
	}

	/**
	 * Instantiates a new web app runtime exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public WebAppRuntimeException(String errorCode, String message,
			Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new web app runtime exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public WebAppRuntimeException(Throwable cause) {
		super(cause);
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode
	 *            the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
