package com.admas.logiware.dto;

public class HostelSignUpDetails {

	private String emailId;
	private String name;
	private String userName;
	private Long password;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	
	public HostelSignUpDetails() {
		super();
	}
	
	public HostelSignUpDetails(String emailId, String name, String userName,
			Long password) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
}
