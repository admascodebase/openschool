package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

public class ContractCompDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7123671403769902910L;
	private Integer id;
	private String name;
    private Integer compId; 
	private String address;
	private String type;
    private String contactPersion;
	private String contactNo1;
	private String contactNo2;
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
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the contactPersion
	 */
	public String getContactPersion() {
		return contactPersion;
	}

	/**
	 * @param contactPersion the contactPersion to set
	 */
	public void setContactPersion(String contactPersion) {
		this.contactPersion = contactPersion;
	}

	/**
	 * @return the contactNo1
	 */
	public String getContactNo1() {
		return contactNo1;
	}

	/**
	 * @param contactNo1 the contactNo1 to set
	 */
	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	/**
	 * @return the contactNo2
	 */
	public String getContactNo2() {
		return contactNo2;
	}

	/**
	 * @param contactNo2 the contactNo2 to set
	 */
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the delFlag
	 */
	public Character getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustContractCompany [id=" + id + ", name=" + name + ", compId="
				+ compId + ", address=" + address + ", type=" + type
				+ ", contactPersion=" + contactPersion + ", contactNo1="
				+ contactNo1 + ", contactNo2=" + contactNo2 + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", delFlag="
				+ delFlag + "]";
	}
	
}
