package com.admas.logiware.dto;

import java.io.Serializable;

import com.admas.logiware.jpa.CompanyRoute;
import com.admas.logiware.jpa.State;

public class CompanyRouteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Integer id;
	private Integer compId;
	private Integer startCityId;
	private Integer endCityId;
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
	 * @return the startCityId
	 */
	public Integer getStartCityId() {
		return startCityId;
	}

	/**
	 * @return the endCityId
	 */
	public Integer getEndCityId() {
		return endCityId;
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
	 * @param startCityId the startCityId to set
	 */
	public void setStartCityId(Integer startCityId) {
		this.startCityId = startCityId;
	}

	/**
	 * @param endCityId the endCityId to set
	 */
	public void setEndCityId(Integer endCityId) {
		this.endCityId = endCityId;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}
	
	public CompanyRoute _toJpa(){
		CompanyRoute companyRoute = new CompanyRoute();
		companyRoute.setCompId(this.compId);
		companyRoute.setDelFlag(this.delFlag);
		companyRoute.setEndCityId(this.endCityId);
		companyRoute.setId(this.compId);
		companyRoute.setStartCityId(this.startCityId);
		return companyRoute;
	}

}
