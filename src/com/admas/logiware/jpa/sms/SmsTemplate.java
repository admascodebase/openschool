package com.admas.logiware.jpa.sms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.admas.logiware.dto.sms.SmsTemplateDto;

@Entity
@Table(name = "sms_template")
public class SmsTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -836012267023243925L;
	
	private Integer id;
	private String message;
	
	@Column(name="COMP_ID" ,nullable = false )
	private Integer compId;
	
	@Column(name="TEMPLATE_TYPE")
	private String templateType;
	
	/**
	 * @return the templateType
	 */
	public String getTemplateType() {
		return templateType;
	}
	/**
	 * @param templateType the templateType to set
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
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
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
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
	 * @return the message
	 */
	@Column(name="MESSAGE", nullable = false)
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	public SmsTemplateDto _toDto() {
		SmsTemplateDto smsTemplateDto = new SmsTemplateDto();
		smsTemplateDto.setCompId(this.compId);
		smsTemplateDto.setId(this.id);
		smsTemplateDto.setMessage(this.message);
		smsTemplateDto.setTemplateType(this.templateType);
		return smsTemplateDto;
	}
	

}
