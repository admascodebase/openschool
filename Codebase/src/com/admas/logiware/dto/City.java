package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.PathParam;

public class City implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public City() {
	}
	@PathParam("cityName")
	private String cityName;

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

	
}
