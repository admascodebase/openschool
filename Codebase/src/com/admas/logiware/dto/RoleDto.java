package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

public class RoleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	private Integer compId;
	private Integer createdBy;
	private Integer updatedBy;
	private Date createdOn;
	private Date updatedOn;
	private Character delFlag;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @return the delFlag
	 */
	public Character getDelFlag() {
		return delFlag;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}
	

}
