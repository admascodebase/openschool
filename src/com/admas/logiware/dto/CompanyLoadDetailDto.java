/**
 * 
 */
package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

import com.admas.logiware.jpa.CompanyLoadDetail;

/**
 * @author Ajinkya
 *
 */
public class CompanyLoadDetailDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6012543161484572120L;

	private Integer id;
//	private CompanyRouteDto companyRouteDto;
	private Integer compRouteId;
	private Integer compId;
	private Integer contractCompId;
	private Integer transportTypeId;
//	private TransportTypeDtlDto transportTypeDtlDto;
	private Integer transportTypeDtlId;
	private Date loadingDate;
	private Date unloadingDate;
	private Double amount;
	private Double advance;
	private Double balance;
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
	 * @return the companyRouteDto
	 */
//	public CompanyRouteDto getCompanyRouteDto() {
//		return companyRouteDto;
//	}
	/**
	 * @param companyRouteDto the companyRouteDto to set
	 */
//	public void setCompanyRouteDto(CompanyRouteDto companyRouteDto) {
//		this.companyRouteDto = companyRouteDto;
//	}
	
	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}
	/**
	 * @return the compRouteId
	 */
	public Integer getCompRouteId() {
		return compRouteId;
	}
	/**
	 * @param compRouteId the compRouteId to set
	 */
	public void setCompRouteId(Integer compRouteId) {
		this.compRouteId = compRouteId;
	}
	/**
	 * @return the transportTypeDtlId
	 */
	public Integer getTransportTypeDtlId() {
		return transportTypeDtlId;
	}
	/**
	 * @param transportTypeDtlId the transportTypeDtlId to set
	 */
	public void setTransportTypeDtlId(Integer transportTypeDtlId) {
		this.transportTypeDtlId = transportTypeDtlId;
	}
	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	/**
	 * @return the contractCompId
	 */
	public Integer getContractCompId() {
		return contractCompId;
	}
	/**
	 * @param contractCompId the contractCompId to set
	 */
	public void setContractCompId(Integer contractCompId) {
		this.contractCompId = contractCompId;
	}
	/**
	 * @return the transportTypeId
	 */
	public Integer getTransportTypeId() {
		return transportTypeId;
	}
	/**
	 * @param transportTypeId the transportTypeId to set
	 */
	public void setTransportTypeId(Integer transportTypeId) {
		this.transportTypeId = transportTypeId;
	}
	/**
	 * @return the transportTypeDtlDto
	 */
//	public TransportTypeDtlDto getTransportTypeDtlDto() {
//		return transportTypeDtlDto;
//	}
	/**
	 * @param transportTypeDtlDto the transportTypeDtlDto to set
	 */
//	public void setTransportTypeDtlDto(TransportTypeDtlDto transportTypeDtlDto) {
//		this.transportTypeDtlDto = transportTypeDtlDto;
//	}
	/**
	 * @return the loadingDate
	 */
	public Date getLoadingDate() {
		return loadingDate;
	}
	/**
	 * @param loadingDate the loadingDate to set
	 */
	public void setLoadingDate(Date loadingDate) {
		this.loadingDate = loadingDate;
	}
	/**
	 * @return the unloadingDate
	 */
	public Date getUnloadingDate() {
		return unloadingDate;
	}
	/**
	 * @param unloadingDate the unloadingDate to set
	 */
	public void setUnloadingDate(Date unloadingDate) {
		this.unloadingDate = unloadingDate;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return the advance
	 */
	public Double getAdvance() {
		return advance;
	}
	/**
	 * @param advance the advance to set
	 */
	public void setAdvance(Double advance) {
		this.advance = advance;
	}
	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
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
		return "LoadDto [id=" + id + ", compRouteId=" + compRouteId + ", compId=" + compId + ", contractCompanyId=" + contractCompId
				+ ", transportTypeId=" + transportTypeId + ", transportTypeDtlId=" + transportTypeDtlId
				+ ", loadingDate=" + loadingDate + ", unloadingDate=" + unloadingDate + ", amount=" + amount
				+ ", advance=" + advance + ", balance=" + balance + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", delFlag=" + delFlag + "]";
	}

	public CompanyLoadDetail _toJpa(){
		CompanyLoadDetail companyLoadDetail = new CompanyLoadDetail();
		companyLoadDetail.setAdvance(this.advance);		
		companyLoadDetail.setCompId(this.compId);
		companyLoadDetail.setContractCompId(this.contractCompId);
		companyLoadDetail.setAdvance(this.advance);
		companyLoadDetail.setAmount(this.amount);
		companyLoadDetail.setBalance(this.balance);
		companyLoadDetail.setContractCompRouteId(this.compRouteId);
		companyLoadDetail.setCreatedBy(this.createdBy);
		companyLoadDetail.setCreatedOn(this.createdOn);
		companyLoadDetail.setDelFlag(this.delFlag);
		companyLoadDetail.setId(this.id);
		companyLoadDetail.setLoadingDate(this.loadingDate);
		companyLoadDetail.setTransportTypeDtlId(this.transportTypeDtlId);
		companyLoadDetail.setUnloadingDate(this.unloadingDate);
		companyLoadDetail.setUpdatedBy(this.updatedBy);
		companyLoadDetail.setUpdatedOn(this.updatedOn);
		companyLoadDetail.setStatus(this.status);
		
		return companyLoadDetail;
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