package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.PathParam;

public class City implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public City() {
	}

	private String cityName;
	
	private Integer id;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + "]";
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

	
}
