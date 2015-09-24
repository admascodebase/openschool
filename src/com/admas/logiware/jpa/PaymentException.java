package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.admas.logiware.dto.PaymentExceptionDto;

@Entity
@Table(name="payment_exceptions")
public class PaymentException implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="COMP_ID" ,nullable = false )
	private Integer compId;
	
	@Column(name="SETTING_ID" ,nullable = false )
	private Integer settingId;
	
	@Column(name="TYPE" ,nullable = false)
	private String valueType;
	
	@Column(name="VALUE" ,nullable = false)
	private Double value;
	
	@Column(name="DEL_FLG")
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
	
	public PaymentExceptionDto _toDto(){
		PaymentExceptionDto paymentExceptionDto = new PaymentExceptionDto();
		paymentExceptionDto.setCompId(this.compId);
		paymentExceptionDto.setDelFlag(this.delFlag);
		paymentExceptionDto.setId(this.id);
		paymentExceptionDto.setSettingId(this.settingId);
		paymentExceptionDto.setValue(this.value);
		paymentExceptionDto.setValueType(this.valueType);
		return paymentExceptionDto;
	}
	
}
