package com.admas.property.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Constants.
 */
public class Constants {
	
	/**
	 * The Enum Flags.
	 */
	public enum Flags {

		/** The loggedin. */
		LOGGEDIN
	}
	/**
	 * The Enum ServiceName.
	 */
	public enum ServiceName {

		/** The login. */
		login("login");

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

	/** The Constant htmlMap. */
	public static final Map<String, String> htmlMap;
	static {
		Map<String, String> aMap = new HashMap<String, String>();
		//aMap.put(WebAppConstants.DOCUMENTEMAIL, "Document email.htm");
		htmlMap = Collections.unmodifiableMap(aMap);
	}

}
