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
//	private Integer companyLoadDtlId;
	private TransportDetailsDto transportDetails;
	private Integer transortOwnerId;
	private Integer TransportDtlId;
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
	/**
	 * @return the companyLoadDtlId
	 */
//	public Integer getCompanyLoadDtlId() {
//		return companyLoadDtlId;
//	}
	/**
	 * @param companyLoadDtlId the companyLoadDtlId to set
	 */
//	public void setCompanyLoadDtlId(Integer companyLoadDtlId) {
//		this.companyLoadDtlId = companyLoadDtlId;
//	}
	/**
	 * @return the transportDtlId
	 */
//	public Integer getTransportDtlId() {
//		return TransportDtlId;
//	}
	/**
	 * @param transportDtlId the transportDtlId to set
	 */
//	public void setTransportDtlId(Integer transportDtlId) {
//		TransportDtlId = transportDtlId;
//	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyLoadToTransDto [id=" + id + ", companyLoadDetail=" + companyLoadDetail + /*", companyLoadDtlId="
				+ companyLoadDtlId +*/ ", transportDetails=" + transportDetails + /*", TransportDtlId=" + TransportDtlId
				+*/ ", assignDate=" + assignDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", delFlag=" + delFlag + ", status="
				+ status + "]";
	}
	/**
	 * @return the transportDtlId
	 */
	public Integer getTransportDtlId() {
		return TransportDtlId;
	}
	/**
	 * @param transportDtlId the transportDtlId to set
	 */
	public void setTransportDtlId(Integer transportDtlId) {
		TransportDtlId = transportDtlId;
	}
	/**
	 * @return the transortOwnerId
	 */
	public Integer getTransortOwnerId() {
		return transortOwnerId;
	}
	/**
	 * @param transortOwnerId the transortOwnerId to set
	 */
	public void setTransortOwnerId(Integer transortOwnerId) {
		this.transortOwnerId = transortOwnerId;
	}
	
	
}
