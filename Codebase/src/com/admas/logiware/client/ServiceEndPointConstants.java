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
		
		login("login"),
		getAllCustomer("getAllCustomer"),
		getAllCity("getAllCity"),
		getAllCompany("getAllCompany"),
		getAllEmployee("getAllEmployee"),
		saveCompany("saveCompany"),
		saveEmployee("saveEmployee"),
		saveEditEmployee("saveEditEmployee"),
		getEmployeeById("getEmployeeById"),
		getCompanyById("getCompanyById"),
		deleteEmployee("deleteEmployee"),
		deleteCompany("deleteCompany"),
		getAllTransportTypes("getAllTransportTypes"),
		saveTransportType("saveTransportType"),
		getTransportTypeById("getTransportTypeById"),
		deleteTransportType("deleteTransportType"),
		getAllTransportTypeDetails("getAllTransportTypeDetails"),
		getTransportTypeDtlById("getTransportTypeDtlById"),
		editTransportTypeDtl("editTransportTypeDtl"),
		deleteTransportTypeDtl("deleteTransportTypeDtl"),
		saveTransportTypeDetails("saveTransportTypeDetails"),
		saveContractCompany("saveContractCompany"),
		getAllContractCompany("getAllContractCompany"),
		getContractCompanyById("getContractCompanyById"),
		deleteContractCompany("deleteContractCompany"),
		saveEditContractCompany("saveEditContractCompany");

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

}
