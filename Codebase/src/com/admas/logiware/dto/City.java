package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public City() {
	}
//	@FormParam("cityName")
	private String cityName;

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
