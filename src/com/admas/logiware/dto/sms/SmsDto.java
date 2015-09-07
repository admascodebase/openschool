package com.admas.logiware.dto.sms;

import java.io.Serializable;
import java.util.List;


public class SmsDto implements Serializable{
	
	private static final long serialVersionUID = 3896441132582237804L;
	
	private String orgCode;
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
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	
	
}

	
	
