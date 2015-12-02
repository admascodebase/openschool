package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;



public class CompanyLoadToTransDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private CompanyLoadDetailDto companyLoadDetail;
	private TransportDetailsDto transportDetails;
	private Date assignDate;
	private Integer createdBy;
	private Integer updatedBy;
	private Date createdOn;
	private Date updatedOn;
	private Character delFlag;
	private String status;
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
	 * @return the companyLoadDetail
	 */
	public CompanyLoadDetailDto getCompanyLoadDetail() {
		return companyLoadDetail;
	}
	/**
	 * @param companyLoadDetail the companyLoadDetail to set
	 */
	public void setCompanyLoadDetail(CompanyLoadDetailDto companyLoadDetail) {
		this.companyLoadDetail = companyLoadDetail;
	}
	/**
	 * @return the transportDetails
	 */
	public TransportDetailsDto getTransportDetails() {
		return transportDetails;
	}
	/**
	 * @param transportDetails the transportDetails to set
	 */
	public void setTransportDetails(TransportDetailsDto transportDetails) {
		this.transportDetails = transportDetails;
	}
	/**
	 * @return the assignDate
	 */
	public Date getAssignDate() {
		return assignDate;
	}
	/**
	 * @param assignDate the assignDate to set
	 */
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
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
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
