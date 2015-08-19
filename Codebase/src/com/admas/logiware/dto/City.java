package com.admas.logiware.dto;

import java.io.Serializable;

public class City implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public City() {
	}

	private String cityName;
	
	private Integer id;
	
	private int stateId;

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

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	
	
}
