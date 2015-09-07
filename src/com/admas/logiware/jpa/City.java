package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.admas.logiware.dto.CityDto;

@Entity
@Table(name="city")
public class City implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public City() {
		super();
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="COMP_ID" ,nullable = false )
	private Integer compId;
	
	@Column(name="STATE_ID" ,nullable = false )
	private Integer stateId;
	
	@Column(name="NAME" ,nullable = false )
	private String name;
	
	@Column(name="DEL_FLAG")
	private Character delFlag;

	
	
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
	 * @return the stateId
	 */
	public Integer getStateId() {
		return stateId;
	}
	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
	public CityDto _toDto(){
		CityDto cityDto = new CityDto();
		cityDto .setCompId(this.compId);
		cityDto.setDelFlag(this.delFlag);
		cityDto.setId(this.id);
		cityDto.setName(this.name);
		cityDto.setStateId(this.stateId);
		return cityDto;
	}
	
	
}
