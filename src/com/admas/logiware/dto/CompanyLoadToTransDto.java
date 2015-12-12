package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

import com.admas.logiware.jpa.CompanyLoadToTrans;


public class CompanyLoadToTransDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private CompanyLoadDetailDto companyLoadDetail;
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

	public CompanyLoadToTrans _toJpa(){
		CompanyLoadToTrans companyLoadToTrans = new CompanyLoadToTrans();
		companyLoadToTrans.setAssignDate(this.assignDate);
		companyLoadToTrans.setCompanyLoadDetail(this.companyLoadDetail._toJpa());
		companyLoadToTrans.setCreatedBy(this.createdBy);
		companyLoadToTrans.setCreatedOn(this.createdOn);
		companyLoadToTrans.setDelFlag(this.delFlag);
		companyLoadToTrans.setId(this.id);
		companyLoadToTrans.setTransportDetails(this.transportDetails._toJpa());
		companyLoadToTrans.setUpdatedBy(this.updatedBy);
		companyLoadToTrans.setUpdatedOn(this.updatedOn);
		companyLoadToTrans.setStatus(this.status);
		return companyLoadToTrans;
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
	
	
}
