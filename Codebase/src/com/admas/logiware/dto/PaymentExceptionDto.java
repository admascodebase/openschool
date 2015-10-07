package com.admas.logiware.dto;

import java.io.Serializable;

public class PaymentExceptionDto implements Serializable{

	private static final long serialVersionUID = 1L;	
	
	private Integer id;
	private Integer compId;
	private Integer contractCompId;
	private Integer settingId;
	private String valueType;
	private Double value;
	private Character delFlag;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @return the settingId
	 */
	public Integer getSettingId() {
		return settingId;
	}

	/**
	 * @return the valueType
	 */
	public String getValueType() {
		return valueType;
	}

	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @return the delFlag
	 */
	public Character getDelFlag() {
		return delFlag;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @param settingId the settingId to set
	 */
	public void setSettingId(Integer settingId) {
		this.settingId = settingId;
	}

	/**
	 * @param valueType the valueType to set
	 */
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
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
	
}
