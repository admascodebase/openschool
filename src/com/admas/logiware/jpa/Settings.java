package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.admas.logiware.dto.SettingsDto;

@Entity
@Table(name="settings")
public class Settings implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1426523171112772228L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="COMP_ID" ,nullable = false )
	private Integer compId;
	
	@Column(name="TYPE" ,nullable = false)
	private String type;
	
	@Column(name="VALUE" ,nullable = false)
	private String value;
	
	@Column(name="DISPLAY_TYPE" ,nullable = false)
	private String displayType;
	
	@Column(name="DESCRIPTION")
	private String description;

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the displayType
	 */
	public String getDisplayType() {
		return displayType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @param displayType the displayType to set
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public SettingsDto _toDto(){
		SettingsDto settingsDto = new SettingsDto();
		settingsDto.setCompId(this.compId);
		settingsDto.setDescription(this.description);
		settingsDto.setDisplayType(this.displayType);
		settingsDto.setId(this.id);
		settingsDto.setType(this.type);
		settingsDto.setValue(this.value);
		return settingsDto;
	}
	

}
