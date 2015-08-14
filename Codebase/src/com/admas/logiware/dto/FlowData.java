/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class FlowData.
 */
public class FlowData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * To store values who's lifetime is controlled by the Users Session
	 * Lifetime.
	 */
	private Map<String, String> sessionData = new HashMap<String, String>();

	/**
	 * 
	 */
	public void clearAllSessionData() {
		sessionData.clear();

	}

	public void clearData(String id) {
		sessionData.remove(id);
	}

	/**
	 * @return
	 */
	public Map<String, String> getSessionData() {
		return sessionData;
	}

	/**
	 * Gets the session data.
	 * 
	 * @param id
	 *            the id
	 * @return the session data
	 */
	public String getSessionData(String id) {
		return sessionData.get(id);
	}

	public void setSessionData(String id, String value) {
		sessionData.put(id, value);
	}

	/**
	 * Checks if is logged in.
	 * 
	 * @return true, if is logged in
	 */
	public boolean isLoggedIn() {
		boolean loggedIn = false;
		if (getSessionData("ISLOGEDIN") != null) {
			loggedIn = Boolean.parseBoolean(getSessionData("ISLOGEDIN"));
		}
		return loggedIn;
	}
	
}
