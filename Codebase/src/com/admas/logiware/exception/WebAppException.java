/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class WebAppException.
 */
public class WebAppException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3670635856159034539L;

	public static final String SUCCESSMESSAGE = "successMsg";

	/** The error code. */
	private String errorCode;

	/** The error msg. */
	private String errorMsg;

	/**
	 * Instantiates a new web app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public WebAppException(String message) {
		super(message);
		errorMsg = message;
	}

	/**
	 * Instantiates a new web app exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param message
	 *            the message
	 */
	public WebAppException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new web app exception.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public WebAppException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
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
}
