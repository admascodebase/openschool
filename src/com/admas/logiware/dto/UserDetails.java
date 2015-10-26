package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDetails implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8397074284724590559L;
	
	private Integer id;
	
	private Integer failedAttempt;
	
	private String userName;
	
	private String password;

	private String newPassword;
	
	private String reTypeNewPassword;
	
	private Date lastLogin;
	
	private Integer empId;
	
	private EmployeeDto custCompEmployee;
	
	private Integer userId;
	
	private Integer compId;

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

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the reTypeNewPassword
	 */
	public String getReTypeNewPassword() {
		return reTypeNewPassword;
	}

	/**
	 * @param reTypeNewPassword the reTypeNewPassword to set
	 */
	public void setReTypeNewPassword(String reTypeNewPassword) {
		this.reTypeNewPassword = reTypeNewPassword;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the failedAttempt
	 */
	public Integer getFailedAttempt() {
		return failedAttempt;
	}

	/**
	 * @param failedAttempt the failedAttempt to set
	 */
	public void setFailedAttempt(Integer failedAttempt) {
		this.failedAttempt = failedAttempt;
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
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", failedAttempt=" + failedAttempt + ", userName=" + userName + ", password="
				+ password + ", newPassword=" + newPassword + ", reTypeNewPassword=" + reTypeNewPassword
				+ ", lastLogin=" + lastLogin + ", empId=" + empId + ", custCompEmployee=" + custCompEmployee
				+ ", userId=" + userId + ", compId" + compId+ "]";
	}

	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	
	
	
	
}
