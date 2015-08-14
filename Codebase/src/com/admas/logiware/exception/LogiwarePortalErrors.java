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
	 * SUCCESS SOAP Response
	 */
	SUCCESS("0000", "Success"),

	/**
	 * FAILED SOAP Response
	 */
	FAILED("9999", "Service Error"),

	LOG_OUT_PAGE("EL0003", "Logout Error"),

	/**
	 * INVALID_REQUEST
	 */

	INVALID_REQUEST("EL0001", "Invalid Request"),

	/**
	 * ERROR_WHILE_FETCHING_BANK_RECORDS
	 */

	ERROR_WHILE_FETCHING_BANK_RECORDS("FB0001",
			"Error while fetching bank records"),

	/**
	 * ERROR_WHILE_FETCHING_STATEMENT_RECORDS
	 */

	ERROR_WHILE_FETCHING_STATEMENT_RECORDS("FS0001",
			"Error while fetching Statement records"),

	/**
	 * ERROR_WHILE_UPDATING_MSL_RECORDS
	 */

	ERROR_WHILE_UPDATING_MSL_RECORDS("ME0001",
			"Error while updating MSL invalidate column"),

	/**
	 * ERROR_WHILE_RECAL_NETMOV
	 */
	ERROR_WHILE_RECAL_NETMOV("ME0003", "Error while recal netmov"),

	/**
	 * ERROR_WHILE_ORGANISATION_DETAILS
	 */

	ERROR_WHILE_GETTING_ORGANISATION_DETAILS("OD0001",
			"Error while getting ORGANISATION_DETAILS"),

	/**
	 * ERROR_ACCESS_DENIED
	 */

	ERROR_ACCESS_DENIED("401",
			"You are not authorized user to access this resource"),

	/**
	 * INTERNAL_SERVER_ERROR
	 */

	INTERNAL_SERVER_ERROR("500", "Internal Server Error"),

	/**
	 * INVALID user Details
	 */
	INVALID_USER("EL0002", "Invalid Username Or Password"),

	/**
	 * ERROR_WHILE_GETTING_TOTAL_ACCOUNT_COUNT
	 */

	ERROR_WHILE_GETTING_TOTAL_ACCOUNT_COUNT("AC0001",
			"Error while getting total account count"),

	/**
	 * ERROR_WHILE_CANCELING_MSL_ENTRIES
	 */

	ERROR_WHILE_CANCELING_MSL_ENTRIES("ME0002",
			"Error while updating column invalidate entry"),

	/**
	 * NO_RECORDS_FOUND
	 */
	NO_RECORDS_FOUND("NR0001", "No Records Found."),

	/**
	 * ERROR_WHILE_CANCELING_MSL_ENTRIES
	 */
	ERROR_WHILE_GETTING_PREF_COLUMNS("PC0001",
			"Error while getting preferenced columns"),

	/**
	 * ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS
	 */
	ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS("PM0001",
			"Error While Fetching Payment Monitoring Records."),
	/**
	 * ERROR_WHILE_FETCHING_BANKACCOUNTNETMOVEMENTNOTMATCHEDCOUNT_RECORDS
	 */
	ERROR_WHILE_FETCHING_BANKACCOUNTNETMOVEMENTNOTMATCHEDCOUNT_RECORDS(
			"NMNC001",
			"Error While Fetching count of net movement not matched records."),

	/**
	 * ERROR_WHILE_GETTING_FILTER_DATA
	 */
	ERROR_WHILE_GETTING_FILTER_DATA("FD001",
			"Error While Fetching Filter Data."),

	/**
	 * ERROR_WHILE_MERGING_MSL_RECORDS
	 */
	ERROR_WHILE_MERGING_MSL_RECORDS("ME0004",
			"ERROR_WHILE_BALANCE_EXCEPTIONS_RECORDS"),

	/**
	 * ERROR_WHILE_BALANCE_EXCEPTIONS_RECORDS
	 */
	ERROR_WHILE_BALANCE_EXCEPTIONS_RECORDS("BE001",
			"Error While Fetching Balance Exceptions Records."),

	/**
	 * ERROR_WHILE_FETCHING_BANKACCOUNT_DETAILS_RECORDS
	 */
	ERROR_WHILE_FETCHING_BANKACCOUNT_DETAILS_RECORDS("BA001",
			"Error While Fetching Bank Account Records."),

	/**
	 * ERROR_WHILE_SERCHING_BALANCEEXCEPTIONS_RECORDS
	 */
	ERROR_WHILE_SERCHING_BALANCEEXCEPTIONS_RECORDS("BE002",
			"Error While Searching Balance Exception Records."),

	/**
	 * ERROR_WHILE_ACCOUNT_BALANCES_RECORDS
	 */
	ERROR_WHILE_ACCOUNT_BALANCES_RECORDS("AB001",
			"Error While Fetching Account Balance Records."),

	/**
	 * ERROR_WHILE_FETCHING_BALANCE_ENTRIES_RECORDS
	 */
	ERROR_WHILE_FETCHING_BALANCE_ENTRIES_RECORDS("BEN001",
			"Error While Fetching Balance Entries Records."),

	/**
	 * ERROR_WHILE_SAVING_PREFCOLUMNS
	 */
	ERROR_WHILE_SAVING_PREFCOLUMNS("UP002",
			"Error Whlie Saving User Preferences."),

	/**
	 * ERROR_WHILE_FETCHING_QUERY_MANAGEMENT_RECORDS
	 */
	ERROR_WHILE_FETCHING_QUERY_MANAGEMENT_RECORDS("QM0001",
			"Error While Fetching Query Management Records."),

	/**
	 * INACTIVITY_ERROR
	 */
	INACTIVITY_ERROR("BL0004",
			"Due to inactivity, you have been logged out of your account."),

	/**
	 * ERROR_WHILE_RAISING_QUERY_BY_BANK
	 */
	ERROR_WHILE_RAISING_QUERY_BY_BANK("RQ0001",
			"Error While Initating Query By Bank."),

	/**
	 * ERROR_WHILE_RAISING_QUERY_BY_INSTITUTION
	 */
	ERROR_WHILE_RAISING_QUERY_BY_INSTITUTION("RQ0002",
			"Error While Initating Query By Institution."),

	/**
	 * ERROR_WHILE_FETCHING_QUERY_CORRESPONDENCE_RECORDS
	 */
	ERROR_WHILE_FETCHING_QUERY_CORRESPONDENCE_RECORDS("QM0002",
			"Error While Fetching Query Correspondence Records."),

	/**
	 * ERROR_WHILE_RAISING_QUERY_BY_BANK
	*/
	ERROR_WHILE_IMPORT_QUERY("IQ0001",
					"Error While import Query"),
	
	/**
	  * ERROR_WHILE_UPDATING_QUERY_AND_CORRESPONDENCE
	  */
	ERROR_WHILE_UPDATING_QUERY_AND_CORRESPONDENCE("IQ0002",
				"Error While Updating Query And Correspondence."),
				
	/**
	  * ERROR_WHILE_SAVING_QUERY_AND_CORRESPONDENCE
	  */
	ERROR_WHILE_SAVING_QUERY_AND_CORRESPONDENCE("RQ0003",
					"Error While Saving Query And Correspondence."),
	
	/**
	  * ERROR_WHILE_GIVING_RESPONSE_Of_QUERY
	  */
	ERROR_WHILE_GIVING_RESPONSE_Of_QUERY("GR0001",
					"Error While Giving Response Of Query."),
							
	/**
	  * ERROR_WHILE_SAVING_QUERY_RESPONSE
	  */
	ERROR_WHILE_SAVING_QUERY_RESPONSE("GR0002",
									"Error While Saving Reponse Of Query."),
					
	/**
	  * ERROR_WHILE_GENERATING_CHASER
	  */
	ERROR_WHILE_GENERATING_CHASER("RQ0004",
					"Error While Generating Chaser."),

	/**
	 * ERROR_WHILE_RAISING_QUERY_BY_BANK
	*/
	ERROR_WHILE_AUTHORISING_QUERY("RQ0005",
							"Error While Query Authorization."),;					
	
	

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
