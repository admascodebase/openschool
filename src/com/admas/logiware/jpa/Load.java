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

import com.admas.logiware.dto.LoadDto;

@Entity
@Table(name = "load")
public class Load implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6352420865143575106L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "COMP_ID", nullable = false)
	private Integer compId;

	@ManyToOne
	@JoinColumn(name = "ROUTE_ID", nullable = false)
	private CompanyRoute routeId;

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

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param compId
	 *            the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @return the routeId
	 */
	public CompanyRoute getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId
	 *            the routeId to set
	 */
	public void setRouteId(CompanyRoute routeId) {
		this.routeId = routeId;
	}

	/**
	 * @return the transportTypeDtlId
	 */
	public TransportTypeDtl getTransportTypeDtlId() {
		return transportTypeDtlId;
	}

	/**
	 * @param transportTypeDtlId
	 *            the transportTypeDtlId to set
	 */
	public void setTransportTypeDtlId(TransportTypeDtl transportTypeDtlId) {
		this.transportTypeDtlId = transportTypeDtlId;
	}

	/**
	 * @return the loadingDate
	 */
	public Date getLoadingDate() {
		return loadingDate;
	}

	/**
	 * @param loadingDate
	 *            the loadingDate to set
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
	 * @param unloadingDate
	 *            the unloadingDate to set
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
	 * @param amount
	 *            the amount to set
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
	 * @param advance
	 *            the advance to set
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
	 * @param balance
	 *            the balance to set
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
	 * @param createdBy
	 *            the createdBy to set
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
	 * @param updatedBy
	 *            the updatedBy to set
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
	 * @param createdOn
	 *            the createdOn to set
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
	 * @param updatedOn
	 *            the updatedOn to set
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
	 * @param delFlag
	 *            the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Load [id=" + id + ", compId=" + compId + ", routeId=" + routeId + ", transportTypeDtlId="
				+ transportTypeDtlId + ", loadingDate=" + loadingDate + ", unloadingDate=" + unloadingDate + ", amount="
				+ amount + ", advance=" + advance + ", balance=" + balance + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", delFlag=" + delFlag + "]";
	}

	public LoadDto _toDto() {
		LoadDto loadDto = new LoadDto();
		loadDto.setCompId(this.compId);
		loadDto.setAdvance(this.advance);
		loadDto.setAmount(this.amount);
		loadDto.setBalance(this.balance);
		loadDto.setCompanyRouteDto(this.routeId._toDto());
		loadDto.setCreatedBy(this.createdBy);
		loadDto.setCreatedOn(this.createdOn);
		loadDto.setDelFlag(this.delFlag);
		loadDto.setId(this.compId);
		loadDto.setLoadingDate(this.loadingDate);
		loadDto.setTransportTypeDtlDto(this.transportTypeDtlId._toDto());
		loadDto.setUnloadingDate(this.unloadingDate);
		loadDto.setUpdatedBy(this.updatedBy);
		loadDto.setUpdatedOn(this.updatedOn);
		return loadDto;
	}

}
