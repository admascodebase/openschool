package com.admas.logiware.exception;

/**
 * @author sharad
 *
 */
public class LogiwareBaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SUCCESSMESSAGE = "successMsg";

	/** The error code. */
	private LogiwarePortalErrors enterprisePortalErrors;

	/** The error description. */
	private String description;
	
	private String errorCode;

	
	/**
	 * @return the enterprisePortalErrors
	 */
	public LogiwarePortalErrors getBankEntriesData() {
		return enterprisePortalErrors;
	}

	/**
	 * @param enterprisePortalErrors the enterprisePortalErrors to set
	 */
	public void setEnterprisePortalErrors(
			LogiwarePortalErrors enterprisePortalErrors) {
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

	public LogiwareBaseException(String errorCode , String errorDescription){
		super(errorCode,new Throwable(errorDescription));
		this.errorCode = errorCode;
		this.description = errorDescription;
	}
	public LogiwareBaseException(LogiwarePortalErrors enterprisePortalErrors){
		super(enterprisePortalErrors.getErrorCode(),new Throwable(enterprisePortalErrors.getErrorDescription()));
		this.enterprisePortalErrors=enterprisePortalErrors;
		this.description=enterprisePortalErrors.getErrorDescription();
	}
	
	public LogiwareBaseException(LogiwarePortalErrors enterprisePortalErrors,String description){
		super(enterprisePortalErrors.getErrorCode(),new Throwable(description));
		this.enterprisePortalErrors=enterprisePortalErrors;
		this.description=description;
	}

	/**
	 * @return the enterprisePortalErrors
	 */
	public LogiwarePortalErrors getEnterprisePortalErrors() {
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
