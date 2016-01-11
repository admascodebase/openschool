package com.admas.property.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.admas.property.constant.WebAppConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class FlowData.
 * This clss used to manage all session data. We can access alll the sessions using this data.
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
	
	private Map<String, Object> sessionDataObject = new HashMap<String, Object>();

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
	 * @return the sessionDataObject
	 */

	public Object getSessionDataObject(String id) {
		return sessionDataObject.get(id);
	}

	public void setSessionDataObject(String id, Object value) {
		sessionDataObject.put(id, value);
	}

	/**
	 * Checks if is logged in.
	 * 
	 * @return true, if is logged in
	 */
	public boolean isLoggedIn() {
		boolean loggedIn = false;
		if (getSessionData(WebAppConstants.ISLOGEDIN) != null) {
			loggedIn = Boolean.parseBoolean(getSessionData(WebAppConstants.ISLOGEDIN));
		}
		return loggedIn;
	}
	
}
