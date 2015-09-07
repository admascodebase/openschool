package com.admas.logiware.dto;

import java.io.Serializable;

import com.admas.logiware.jpa.State;

public class StateDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3104653023242858428L;

	private Integer id;
	private Integer countryId;
	private String name;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public State _toJpa(){
		State state = new State();
		state.setCountryId(this.countryId);
		state.setId(this.id);
		state.setName(this.name);
		return state;
	}
	
}
