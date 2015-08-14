/*Copyright Currencies Direct Ltd 2015-2016. All rights reserved
worldwide. Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.*/
package com.admas.logiware.dto;


/**
 * @author Sonal M.
 * 
 *         The Class RestResponse. Copyright Currencies Direct Ltd 2015-2016.
 */
public class RestResponseUser implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The status description. */
	protected String status;

	/** The status code. */
	protected ResponseStatusHeader responseStatusHeader;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the responseStatusHeader
	 */
	public ResponseStatusHeader getResponseStatusHeader() {
		return responseStatusHeader;
	}
	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param responseStatusHeader
	 *            the responseStatusHeader to set
	 */
	public void setResponseStatusHeader(
			ResponseStatusHeader responseStatusHeader) {
		this.responseStatusHeader = responseStatusHeader;
	}
}
