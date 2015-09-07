package com.admas.logiware.dto.sms;

import java.io.Serializable;

public class SmsTemplateDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2689368663531111079L;
	
	private Integer id;
	private String message;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
