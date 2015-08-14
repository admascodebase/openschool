/**
 * 
 */
package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

/**
 * @author Ajinkya
 *
 */
public class UserDetails implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4963126775886597257L;
	
	@FormParam("userName")
	private String userName;

	@FormParam("password")
	private String password;
	
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
	
	
}
