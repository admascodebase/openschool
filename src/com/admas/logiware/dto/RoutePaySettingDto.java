package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

import com.admas.logiware.jpa.RoutePaySetting;

public class RoutePaySettingDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer transportTypeId;
	private Integer transportTypeDtlId;
	private Integer routeId;
	private Double amount;
	private Double advance;
	private Double balance;
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
	 * @return the transportTypeId
	 */
	public Integer getTransportTypeId() {
		return transportTypeId;
	}

	/**
	 * @return the routeId
	 */
	public Integer getRouteId() {
		return routeId;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @return the advance
	 */
	public Double getAdvance() {
		return advance;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @return the delFlag
	 */
	public Character getDelFlag() {
		return delFlag;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param transportTypeId
	 *            the transportTypeId to set
	 */
	public void setTransportTypeId(Integer transportTypeId) {
		this.transportTypeId = transportTypeId;
	}

	/**
	 * @param routeId
	 *            the routeId to set
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @param advance
	 *            the advance to set
	 */
	public void setAdvance(Double advance) {
		this.advance = advance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @param delFlag
	 *            the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}

	public RoutePaySetting _toJpa() {
		RoutePaySetting routePaySetting = new RoutePaySetting();
		routePaySetting.setAdvance(this.advance);
		routePaySetting.setAmount(this.amount);
		routePaySetting.setBalance(this.balance);
		routePaySetting.setCreatedBy(this.createdBy);
		routePaySetting.setCreatedOn(this.createdOn);
		routePaySetting.setDelFlag(this.delFlag);
		routePaySetting.setId(this.id);
		routePaySetting.setRouteId(this.routeId);
		routePaySetting.setTransportTypeId(this.transportTypeId);
		routePaySetting.setUpdatedBy(this.updatedBy);
		routePaySetting.setUpdatedOn(this.updatedOn);
		routePaySetting.setTransportTypeDtlId(this.transportTypeDtlId);
		return routePaySetting;
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

}
