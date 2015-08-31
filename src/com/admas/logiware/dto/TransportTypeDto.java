package com.admas.logiware.dto;

import java.io.Serializable;

public class TransportTypeDto implements Serializable{

		private static final long serialVersionUID = -5409589022596975774L;

	public TransportTypeDto() {
		
	}


	private Integer id;
	private Integer compId;
	private String name;
	private String description;
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
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
	
	@Override
	public String toString() {
		return "TransportTypeDto [id=" + id + ", compId=" + compId + ", name="
				+ name + ", description=" + description + "]";
	}

	
}
