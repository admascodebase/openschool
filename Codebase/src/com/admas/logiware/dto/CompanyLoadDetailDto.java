/**
 * 
 */
package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

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
	private CompanyRouteDto companyRouteDto;
	private Integer compId;
	private Integer transportTypeId;
	private TransportTypeDtlDto transportTypeDtlDto;
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
	public CompanyRouteDto getCompanyRouteDto() {
		return companyRouteDto;
	}
	/**
	 * @param companyRouteDto the companyRouteDto to set
	 */
	public void setCompanyRouteDto(CompanyRouteDto companyRouteDto) {
		this.companyRouteDto = companyRouteDto;
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
	public TransportTypeDtlDto getTransportTypeDtlDto() {
		return transportTypeDtlDto;
	}
	/**
	 * @param transportTypeDtlDto the transportTypeDtlDto to set
	 */
	public void setTransportTypeDtlDto(TransportTypeDtlDto transportTypeDtlDto) {
		this.transportTypeDtlDto = transportTypeDtlDto;
	}
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
		return "LoadDto [id=" + id + ", companyRouteDto=" + companyRouteDto + ", compId=" + compId
				+ ", transportTypeId=" + transportTypeId + ", transportTypeDtlDto=" + transportTypeDtlDto
				+ ", loadingDate=" + loadingDate + ", unloadingDate=" + unloadingDate + ", amount=" + amount
				+ ", advance=" + advance + ", balance=" + balance + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", delFlag=" + delFlag + "]";
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