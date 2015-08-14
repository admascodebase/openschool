package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class CustomerDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FormParam("firstName")
	private String firstName;
	@FormParam("email")
	private String email;
	@FormParam("mobile")
	private String mobile;
	@FormParam("lastName")
	private String lastName;
	@FormParam("address")
	private CustomerAddress address;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public CustomerAddress getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(CustomerAddress address) {
		this.address = address;
	}
	

	
	
	
	
}
