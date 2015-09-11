package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

import com.admas.logiware.jpa.LoweryOwner;

public class LoweryOwnerDto implements Serializable{

	private Integer id;
	private Integer compId;
	private Integer branchId;
	private String name;
	private String address;
	private String contactNo;
	private String contactPersion;
	private String emailId;
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
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
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
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return "LoweryOwner [id=" + id + ", compId=" + compId + ", branchId="
				+ branchId + ", name=" + name + ", address=" + address
				+ ", contactNo=" + contactNo + ", contactPersion="
				+ contactPersion + ", emailId=" + emailId + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", delFlag="
				+ delFlag + "]";
	}
	
	public LoweryOwner _toJpa(){
		LoweryOwner loweryOwner = new LoweryOwner();
		loweryOwner.setAddress(this.address);
		loweryOwner.setBranchId(this.branchId);
		loweryOwner.setCompId(this.compId);
		loweryOwner.setContactNo(this.contactNo);
		loweryOwner.setContactPersion(this.contactPersion);
		loweryOwner.setCreatedBy(this.createdBy);
		loweryOwner.setCreatedOn(this.createdOn);
		loweryOwner.setDelFlag(this.delFlag);
		loweryOwner.setEmailId(this.emailId);
		loweryOwner.setId(this.id);
		loweryOwner.setName(this.name);
		loweryOwner.setUpdatedBy(this.updatedBy);
		loweryOwner.setUpdatedOn(this.updatedOn);
		return loweryOwner;
	}
	
}
