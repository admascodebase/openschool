package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class SmsSettings implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	@FormParam("orgId")
	private String orgId;
	@FormParam("url")
	private String url;
	@FormParam("userId")
	private String userId;
	@FormParam("password")
	private String password;
	
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SmsSettings [id=" + id + ", orgId=" + orgId + ", url=" + url
				+ ", userId=" + userId + ", password=" + password + "]";
	}
	
	
	
	
}
