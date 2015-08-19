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
	private int id;
	private String stateName;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
