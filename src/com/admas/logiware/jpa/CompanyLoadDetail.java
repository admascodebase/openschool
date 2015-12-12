package com.admas.logiware.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.admas.logiware.dto.CompanyLoadDetailDto;

@Entity
@Table(name = "company_load_detail")
public class CompanyLoadDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6352420865143575106L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "COMP_ID", nullable = false)
	private Integer compId;

	@Column(name = "CONTRACT_COMP_ID", nullable = false)
	private Integer contractCompId;

//	@ManyToOne
//	@JoinColumn(name = "CONTRACT_COMP_ROUTE_ID", nullable = false)
	@Column(name = "CONTRACT_COMP_ROUTE_ID", nullable = false)
	private Integer contractCompRouteId;

//	@ManyToOne
//	@JoinColumn(name = "TRANSPORT_TYPE_DTL_ID", nullable = false)
	@Column(name = "TRANSPORT_TYPE_DTL_ID", nullable = false)
	private Integer transportTypeDtlId;

	@Column(name = "LOADING_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date loadingDate;

	@Column(name = "UNLOADING_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date unloadingDate;

	@Column(name = "AMOUNT", nullable = false)
	private Double amount;

	@Column(name = "ADVANCE", nullable = false)
	private Double advance;

	@Column(name = "BALANCE", nullable = false)
	private Double balance;

	@Column(name = "CREATED_BY", nullable = false)
	private Integer createdBy;

	@Column(name = "UPDATED_BY")
	private Integer updatedBy;

	@Column(name = "CREATED_ON", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "DEL_FLG")
	private Character delFlag;
	
	@Column(name = "STATUS")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getContractCompId() {
		return contractCompId;
	}

	public void setContractCompId(Integer contractCompId) {
		this.contractCompId = contractCompId;
	}

	public Date getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(Date loadingDate) {
		this.loadingDate = loadingDate;
	}

	public Date getUnloadingDate() {
		return unloadingDate;
	}

	/**
	 * @return the contractCompRouteId
	 */
	public Integer getContractCompRouteId() {
		return contractCompRouteId;
	}

	/**
	 * @param contractCompRouteId the contractCompRouteId to set
	 */
	public void setContractCompRouteId(Integer contractCompRouteId) {
		this.contractCompRouteId = contractCompRouteId;
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

	public void setUnloadingDate(Date unloadingDate) {
		this.unloadingDate = unloadingDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAdvance() {
		return advance;
	}

	public void setAdvance(Double advance) {
		this.advance = advance;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Character getDelFlag() {
		return delFlag;
	}

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

	public CompanyLoadDetailDto _toDto() {
		CompanyLoadDetailDto companyLoadDetailDto = new CompanyLoadDetailDto();
		companyLoadDetailDto.setCompId(this.compId);
		companyLoadDetailDto.setContractCompId(this.contractCompId);
		companyLoadDetailDto.setAdvance(this.advance);
		companyLoadDetailDto.setAmount(this.amount);
		companyLoadDetailDto.setBalance(this.balance);
//		 companyLoadDetailDto.setCompanyRouteDto(this.contractCompRouteId._toDto());
		companyLoadDetailDto.setCompRouteId(this.contractCompRouteId);
		companyLoadDetailDto.setCreatedBy(this.createdBy);
		companyLoadDetailDto.setCreatedOn(this.createdOn);
		companyLoadDetailDto.setDelFlag(this.delFlag);
		companyLoadDetailDto.setId(this.id);
		companyLoadDetailDto.setLoadingDate(this.loadingDate);
//		companyLoadDetailDto.setTransportTypeDtlDto(this.transportTypeDtlId._toDto());
		companyLoadDetailDto.setTransportTypeDtlId(this.transportTypeDtlId);
		companyLoadDetailDto.setUnloadingDate(this.unloadingDate);
		companyLoadDetailDto.setUpdatedBy(this.updatedBy);
		companyLoadDetailDto.setUpdatedOn(this.updatedOn);
		companyLoadDetailDto.setStatus(this.status);
		return companyLoadDetailDto;
	}

}
