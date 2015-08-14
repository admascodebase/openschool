/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Constants.
 */
public class Constants {

	/**
	 * The Enum Environment.
	 */
	public enum Environment {

		/** The dev. */
		DEV,
		/** The qa. */
		QA,
		/** The uat. */
		UAT,
		/** The prod. */
		PROD;

		/**
		 * Val.
		 * 
		 * @param env
		 *            the env
		 * @return the environment
		 */
		public static Environment val(String env) {
			try {
				return Environment.valueOf(env);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * The Enum DataType.
	 */
	public enum DataType {

		/** The Application. */
		Application,

		/** The Session. */
		Session,

		/** The Transaction. */
		Transaction,

		/** The Step. */
		Step;

		/**
		 * Val.
		 * 
		 * @param list
		 *            the list
		 * @return the data type
		 */
		public static DataType val(String list) {
			try {
				return DataType.valueOf(list);
			} catch (Exception e) {
				return null;
			}
		}

	}

	/**
	 * The Enum Flags.
	 */
	public enum Flags {

		/** The loggedin. */
		LOGGEDIN
	}

	/**
	 * The Enum Cache.
	 */
	public enum Cache {

		/** The Database cache. */
		DatabaseCache("Database_Cache"),

		/** The Organization cache. */
		OrganizationCache("Organization_Cache");

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new cache.
		 * 
		 * @param value
		 *            the value
		 */
		Cache(String value) {
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

	/**
	 * The Enum ServiceName.
	 */
	public enum ServiceName {

		/** The login. */
		login("login"),

		/** The verify session. */
		verifyEtailerNGOPSession("verifyEtailerNGOPSession"),

		/** The send activation link. */
		sendActivationLink("sendActivationLink"),

		/** The etailer forgot password email. */
		etailerForgotPasswordEmail("etailerForgotPasswordEmail"),

		/** The verify reset password token. */
		verifyResetPasswordToken("verifyResetPasswordToken"),

		/** The verify etailer token. */
		verifyEtailerToken("verifyEtailerToken"),

		/** The get etailer user details. */
		getEtailerUserDetails("getEtailerUserDetails"),

		/** The validate and update etailer password. */
		validateAndUpdateEtailerPassword("validateAndUpdateEtailerPassword"),

		/** The setup pwd and login. */
		setupPwdAndLogin("setupPwdAndLogin"),

		/** The update etailer password. */
		updateEtailerPassword("updateEtailerPassword"),

		/** The logout. */
		logoutEtailer("logoutEtailer"),

		/** The get account info etailer. */
		getAccountInfoEtailer("getAccountInfoEtailer"),

		/** The get etailer account balance. */
		getEtailerAccountBalance("getEtailerAccountBalance"),

		/** The get etailer beneficiaries. */
		getEtailerBeneficiaries("getEtailerBeneficiaries"),

		/** The get statement. */
		getStatement("getStatement"), getFxDealRate("getFxDealRate"), getTransId(
				"getTransId"), getFxDealRateOnBuyingAmount(
				"getFxDealRateOnBuyingAmount"), updatePaymentObject(
				"updatePaymentObject"),

		/** The get exception fee. */
		getExceptionFee("getExceptionFee"), getPaymentObject("getPaymentObject"), sendMoney(
				"sendMoney"), getEtailerFee("getEtailerFee"), getContractNote(
				"getContractNote"), saveTransactionLog("saveTransactionLog");

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

	/**
	 * The Enum Cache.
	 */
	public enum lookupType {

		/** The Title. */
		Title("Title"),

		/** The Occupation. */
		Occupation("Occupation"),

		/** The Purpose_Of_Transaction. */
		Purpose_Of_Transaction("Purpose_Of_Transaction"),

		/** The Source_Of_Fund. */
		Source_Of_Fund("Source_Of_Fund"),

		/** The Value_Of_Transaction. */
		Value_Of_Transaction("Value_Of_Transaction"),

		/** The Security_Question. */
		Security_Question("Security_Question"),

		/** The Source. */
		Source("Source"),

		/** The Sub_Source. */
		Sub_Source("Sub_Source "),

		/** The Password_Pattern. */
		Password_Pattern("Password_Pattern"),

		/** The Card_Type. */
		Card_Type("Card_Type");

		/** The value. */
		private final String value;

		/**
		 * Instantiates a new cache.
		 * 
		 * @param value
		 *            the value
		 */
		lookupType(String value) {
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

	/** The Constant htmlMap. */
	public static final Map<String, String> htmlMap;
	static {
		Map<String, String> aMap = new HashMap<String, String>();
		//aMap.put(WebAppConstants.DOCUMENTEMAIL, "Document email.htm");
		htmlMap = Collections.unmodifiableMap(aMap);
	}

}
