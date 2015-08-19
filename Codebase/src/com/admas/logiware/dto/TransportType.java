package com.admas.logiware.dto;

import java.io.Serializable;

public class TransportType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4248163557981291001L;
	
	
	private int id;
	private int companyId;
	private String name;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TransportType [id=" + id + ", companyId=" + companyId
				+ ", Name=" + name + ", description=" + description + "]";
	}

	
	
}
