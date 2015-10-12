package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDetails implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8397074284724590559L;
	
	
	private String userName;
	
	private String password;
	
	private Date lastLogin;

	private Integer empId;
	
	private EmployeeDto custCompEmployee;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the custCompEmployee
	 */
	public EmployeeDto getCustCompEmployee() {
		return custCompEmployee;
	}

	/**
	 * @param custCompEmployee the custCompEmployee to set
	 */
	public void setCustCompEmployee(EmployeeDto custCompEmployee) {
		this.custCompEmployee = custCompEmployee;
	}

	/**
	 * @return the empId
	 */
	public Integer getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	/*public com.admas.logiware.jpa.UserDetails _toJpa(){
		com.admas.logiware.jpa.UserDetails userDetails = new com.admas.logiware.jpa.UserDetails();
		userDetails.setUserName(userName);
	}*/
	
	
	
}
