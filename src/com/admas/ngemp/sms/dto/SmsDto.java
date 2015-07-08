package com.admas.ngemp.sms.dto;

import java.io.Serializable;
import java.util.List;


public class SmsDto implements Serializable{
	
	private static final long serialVersionUID = 3896441132582237804L;
	
	private String org_code;
	private String message;
	private Integer route;
	private List<String> contactNos;
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the route
	 */
	public Integer getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Integer route) {
		this.route = route;
	}

	/**
	 * @return the contactNos
	 */
	public List<String> getContactNos() {
		return contactNos;
	}

	/**
	 * @param contactNos the contactNos to set
	 */
	public void setContactNos(List<String> contactNos) {
		this.contactNos = contactNos;
	}

	/**
	 * @return the org_code
	 */
	public String getOrg_code() {
		return org_code;
	}

	/**
	 * @param org_code the org_code to set
	 */
	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}
	
}

	
	
