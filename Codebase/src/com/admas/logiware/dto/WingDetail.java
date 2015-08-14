package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class WingDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@FormParam("wingName")
	private String wingName;
	
	@FormParam("floors")
	private Integer floors;

	public WingDetail() {
	}

	/**
	 * @return the wingName
	 */
	public String getWingName() {
		return wingName;
	}

	/**
	 * @param wingName the wingName to set
	 */
	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	/**
	 * @return the floors
	 */
	public Integer getFloors() {
		return floors;
	}

	/**
	 * @param floors the floors to set
	 */
	public void setFloors(Integer floors) {
		this.floors = floors;
	}
	
	

}
