package com.admas.logiware.dao;

import java.util.Date;

public class UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8397074284724590559L;
	
	
	private String userName;
	
	private String password;
	
	private Date lastLogin;
	
	private CustCompEmployee custCompEmployee;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Override
	public String toString() {
		return "UserDetails [userName=" + userName + ", password=" + password
				+ ", lastLogin=" + lastLogin + "]";
	}
	/**
	 * @return the custCompEmployee
	 */
	public CustCompEmployee getCustCompEmployee() {
		return custCompEmployee;
	}
	/**
	 * @param custCompEmployee the custCompEmployee to set
	 */
	public void setCustCompEmployee(CustCompEmployee custCompEmployee) {
		this.custCompEmployee = custCompEmployee;
	}
	
}
