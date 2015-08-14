package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class District implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public District() {
	}
	@FormParam("districtName")
	private String districtName;
	@FormParam("city")
	private City city;
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	

}
