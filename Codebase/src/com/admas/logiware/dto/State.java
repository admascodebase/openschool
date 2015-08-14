package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public State() {
	}
	@FormParam("stateName")
	private String stateName;
	@FormParam("district")
	private District district;
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the district
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(District district) {
		this.district = district;
	}
	
	

}
