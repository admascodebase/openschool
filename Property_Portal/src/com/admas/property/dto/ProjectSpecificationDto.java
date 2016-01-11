/**
 * 
 */
package com.admas.property.dto;

/**
 * @author Ajinkya
 *
 */
public class ProjectSpecificationDto {

	/**
	 * 
	 */
	public ProjectSpecificationDto() {
	}

	private Integer id;
	private Integer projectId;
	private Integer specificationTypeId;
	private String specificationValue;
	private String description;
	private Character statusFlag;
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
	/**
	 * @return the projectId
	 */
	public Integer getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the specificationTypeId
	 */
	public Integer getSpecificationTypeId() {
		return specificationTypeId;
	}
	/**
	 * @param specificationTypeId the specificationTypeId to set
	 */
	public void setSpecificationTypeId(Integer specificationTypeId) {
		this.specificationTypeId = specificationTypeId;
	}
	/**
	 * @return the specificationValue
	 */
	public String getSpecificationValue() {
		return specificationValue;
	}
	/**
	 * @param specificationValue the specificationValue to set
	 */
	public void setSpecificationValue(String specificationValue) {
		this.specificationValue = specificationValue;
	}
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
	 * @return the statusFlag
	 */
	public Character getStatusFlag() {
		return statusFlag;
	}
	/**
	 * @param statusFlag the statusFlag to set
	 */
	public void setStatusFlag(Character statusFlag) {
		this.statusFlag = statusFlag;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectSpecificationDto [id=" + id + ", projectId=" + projectId + ", specificationTypeId="
				+ specificationTypeId + ", specificationValue=" + specificationValue + ", description=" + description
				+ ", statusFlag=" + statusFlag + "]";
	}
	
	
	
}
