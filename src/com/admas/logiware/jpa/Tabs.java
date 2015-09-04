package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabs")
public class Tabs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5087361627180457087L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME" ,nullable = false )
	private String name;
	
	@Column(name="MODULE_ID" ,nullable = false )
	private Integer moduleId;
	
	@Column(name="INDEX_NO" ,nullable = false )
	private Integer indexNo;
	
	@Column(name="PARENT_ID")
	private Integer parentId;
	
	@Column(name="DESCRIPTION")
	private String description;

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
	 * @return the moduleId
	 */
	public Integer getModuleId() {
		return moduleId;
	}

	/**
	 * @return the indexNo
	 */
	public Integer getIndexNo() {
		return indexNo;
	}

	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @param indexNo the indexNo to set
	 */
	public void setIndexNo(Integer indexNo) {
		this.indexNo = indexNo;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tabs [id=" + id + ", name=" + name + ", moduleId=" + moduleId
				+ ", indexNo=" + indexNo + ", parentId=" + parentId
				+ ", description=" + description + "]";
	}
	
	
}
