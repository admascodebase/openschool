package com.admas.logiware.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "CONTRACT_COMP_ROUTE_ID", nullable = false)
	private CompanyRoute contractCompRouteId;

	@ManyToOne
	@JoinColumn(name = "TRANSPORT_TYPE_DTL_ID", nullable = false)
	private TransportTypeDtl transportTypeDtlId;

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

	public CompanyRoute getContractCompRouteId() {
		return contractCompRouteId;
	}

	public void setContractCompRouteId(CompanyRoute contractCompRouteId) {
		this.contractCompRouteId = contractCompRouteId;
	}

	public TransportTypeDtl getTransportTypeDtlId() {
		return transportTypeDtlId;
	}

	public void setTransportTypeDtlId(TransportTypeDtl transportTypeDtlId) {
		this.transportTypeDtlId = transportTypeDtlId;
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
		companyLoadDetailDto.setAdvance(this.advance);
		companyLoadDetailDto.setAmount(this.amount);
		companyLoadDetailDto.setBalance(this.balance);
		 companyLoadDetailDto.setCompanyRouteDto(this.contractCompRouteId._toDto());
		companyLoadDetailDto.setCreatedBy(this.createdBy);
		companyLoadDetailDto.setCreatedOn(this.createdOn);
		companyLoadDetailDto.setDelFlag(this.delFlag);
		companyLoadDetailDto.setId(this.compId);
		companyLoadDetailDto.setLoadingDate(this.loadingDate);
		companyLoadDetailDto.setTransportTypeDtlDto(this.transportTypeDtlId._toDto());
		companyLoadDetailDto.setUnloadingDate(this.unloadingDate);
		companyLoadDetailDto.setUpdatedBy(this.updatedBy);
		companyLoadDetailDto.setUpdatedOn(this.updatedOn);
		companyLoadDetailDto.setStatus(this.status);
		return companyLoadDetailDto;
	}

}
