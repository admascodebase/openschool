package com.admas.property.exception;

/**
 * @author Amol
 *
 */
public class PropertyBaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SUCCESSMESSAGE = "successMsg";

	/** The error code. */
	private PropertyErrors enterprisePortalErrors;

	/** The error description. */
	private String description;
	
	private String errorCode;

	
	/**
	 * @return the enterprisePortalErrors
	 */
	public PropertyErrors getBankEntriesData() {
		return enterprisePortalErrors;
	}

	/**
	 * @param enterprisePortalErrors the enterprisePortalErrors to set
	 */
	public void setEnterprisePortalErrors(
			PropertyErrors enterprisePortalErrors) {
		this.enterprisePortalErrors = enterprisePortalErrors;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public PropertyBaseException(String errorCode , String errorDescription){
		super(errorCode,new Throwable(errorDescription));
		this.errorCode = errorCode;
		this.description = errorDescription;
	}
	public PropertyBaseException(PropertyErrors enterprisePortalErrors){
		super(enterprisePortalErrors.getErrorCode(),new Throwable(enterprisePortalErrors.getErrorDescription()));
		this.enterprisePortalErrors=enterprisePortalErrors;
		this.description=enterprisePortalErrors.getErrorDescription();
	}
	
	public PropertyBaseException(PropertyErrors enterprisePortalErrors,String description){
		super(enterprisePortalErrors.getErrorCode(),new Throwable(description));
		this.enterprisePortalErrors=enterprisePortalErrors;
		this.description=description;
	}

	/**
	 * @return the enterprisePortalErrors
	 */
	public PropertyErrors getEnterprisePortalErrors() {
		return enterprisePortalErrors;
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
