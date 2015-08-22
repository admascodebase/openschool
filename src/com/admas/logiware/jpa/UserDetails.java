package com.admas.logiware.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_login")
public class UserDetails implements Serializable{
	
	private static final long serialVersionUID = 5812348653094857561L;
	
	public UserDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="USER_NAME" ,nullable = false )
	private String userName;
	
	@Column(name="PASSWORD" ,nullable = false )
	private String pasword;
	
	@Column(name="EMP_ID" ,nullable = false )
	private Integer empId;
	
	@Column(name="FAILED_ATTEMPT" ,nullable = false )
	private Integer failedAttempt;
	
	@Column(name="LAST_LOGIN" ,nullable = false )
	private Date lastLoginTime;

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
	 * @return the pasword
	 */
	public String getPasword() {
		return pasword;
	}

	/**
	 * @param pasword the pasword to set
	 */
	public void setPasword(String pasword) {
		this.pasword = pasword;
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
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName
				+ ", pasword=" + pasword + ", empId=" + empId
				+ ", failedAttempt=" + failedAttempt + ", lastLoginTime="
				+ lastLoginTime + "]";
	}
	
	
	

}
