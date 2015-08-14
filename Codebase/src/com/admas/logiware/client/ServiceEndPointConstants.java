/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.client;

/**
 * @author hitesh Constant file for Service EndPoints.
 *
 */
public class ServiceEndPointConstants {

	/**
	 * The Enum ServiceName.
	 */
	public enum ServiceName {

		/** The login. */
		showAccountBalances("showAccountBalances"),
		// new
		showBalanceEntriesData("showBalanceEntriesData"),

		login("login"),

		MasterStatementEntries("MasterStatementEntries"),

		BankAccountNetMovementNotMatchedCount(
				"BankAccountNetMovementNotMatchedCount"),

		mergeRecord("mergingRecords"),

		totalAccounts("TotalAccounts"),

		CancleRecord("CancleRecord"),

		getOrganizationdetails("getOrganizationdetails"),

		getFilterData("FiterDataForSearch"),

		getBalanceExceptions("getBalanceExceptions"),

		getBankAccountDetails("getBankAccountDetails"),

		searchBalanceExceptions("searchBalanceExceptions"),

		getPrefColumns("getPrefColumns"),

		showBalanceExceptions("showBalanceExceptions"),

		getBankAccounts("getBankAccounts"),

		savePrefColumns("savePrefColumns"),

		showPaymentMonitoringData("showPaymentMonitoringData"),

		showQueryEntries("showQueryEntries"),

		raiseBankingQuery("raiseBankingQuery"),

		showQueryCorrespondence("showQueryCorrespondence"),

		raiseInstitutionQuery("raiseInstitutionQuery"),

		importQuery("importQuery"),

		saveQueryAndCorrespondence("saveQueryAndCorrespondence"),

		updateQueryAndCorrespondence("updateQueryAndCorrespondence"),		
			
		authorisedQuery("authorisedQuery"),
		
		queryResponse("queryResponse"),
		
		saveQueryResponse("saveQueryResponse"),
				
		generateChaser("generateChaser"),
		
		showPendingAuthorise("showPendingAuthorise");

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new service name.
		 * 
		 * @param value
		 *            the value
		 */
		ServiceName(String value) {
			this.value = value;
		}

		/**
		 * Value.
		 * 
		 * @return the string
		 */
		public String value() {
			return value;
		}

	}

	public enum ServiceAndRoleFunctionName {

		/** The login. */
		showAccountBalances("Bank_Account_Balances"),

		login("All"),

		MasterStatementEntries("Bank_Account_Entries"),

		BankAccountNetMovementNotMatchedCount("All"),

		mergeRecord("Bank_Account_Entries"),

		cancelRecord("Bank_Account_Entries"),

		balanceExceptions("Balance_Exceptions"),

		getBankAccountDetails("Bank_Accounts"),

		totalAccounts("All"),

		getOrganizationdetails("All"),

		getFilterData("All"),

		showBalanceEntriesData("Bank_Account_Entries"),

		searchBalanceException("Balance_Exceptions"),

		getPrefColumns("All"),

		getBankAccounts("Bank_Accounts"),

		showPaymentMonitoringData("Payment_Entries"),

		showQueryEntries("Bank_Queries"),

		showQueryCorrespondence("Query_Correspondence"),

		showPendingAuthorise("Pending_Authorise");

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new service name.
		 * 
		 * @param value
		 *            the value
		 */
		ServiceAndRoleFunctionName(String value) {
			this.value = value;
		}

		/**
		 * Value.
		 * 
		 * @return the string
		 */
		public String value() {
			return value;
		}

	}

}
