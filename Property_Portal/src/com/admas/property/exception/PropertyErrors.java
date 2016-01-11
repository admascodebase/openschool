package com.admas.property.exception;

/**
 * @author Amol
 * 
 */
public enum PropertyErrors {

	/**
	 * SUCCESS Rest Response
	 */
	SUCCESS("0000", "Success"),

	INVALID_REQUEST("9000", "Invalid request"),
	
	DATABASE_GENERIC_ERROR("DB0001","Error while saving the data"),
	
	GENERIC_EXCEPTION("9999", "Generic exception");

				
	
	

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
	private PropertyErrors(String errorCode, String errorDescription) {
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
