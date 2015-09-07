package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.admas.logiware.dto.StateDto;

@Entity
@Table(name="state")
public class State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3845864977750457578L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="COUNTRY_ID" ,nullable = false )
	private Integer countryId;
	
	@Column(name="NAME" ,nullable = false)
	private String name;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public StateDto _toDto(){
		StateDto stateDto = new StateDto();
		stateDto.setCountryId(this.countryId);
		stateDto.setId(this.id);
		stateDto.setName(this.name);
		return stateDto;
	}
	
}
