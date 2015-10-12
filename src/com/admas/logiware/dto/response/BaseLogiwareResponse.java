package com.admas.logiware.dto.response;

import java.io.Serializable;

public class BaseLogiwareResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String code;
	private String description;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
