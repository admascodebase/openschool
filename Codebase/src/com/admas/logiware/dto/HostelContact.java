package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class HostelContact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HostelContact() {
	}
	@FormParam("mobile")
	private String mobile;
	@FormParam("landline")
	private String landline;
	@FormParam("webSite")
	private String webSite;

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the landline
	 */
	public String getLandline() {
		return landline;
	}
	/**
	 * @param landline the landline to set
	 */
	public void setLandline(String landline) {
		this.landline = landline;
	}
	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}
	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	
	
}
