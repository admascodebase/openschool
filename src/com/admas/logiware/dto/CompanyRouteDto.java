package com.admas.logiware.dto;

import java.io.Serializable;

import com.admas.logiware.jpa.CompanyRoute;

public class CompanyRouteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Integer id;
	private Integer compId;
	private CityDto startCityId;
	private CityDto endCityId;
	private Integer distance;
	private Integer deliveryDays;
	private Integer buferTime;
	/*private Integer transportDetailsId;
	private Integer cost;
	private Integer advanceAmt;*/
	private Character delFlag;
	private String routeName;

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
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}

	
	/**
	 * @return the startCityId
	 */
	public CityDto getStartCityId() {
		return startCityId;
	}

	/**
	 * @param startCityId the startCityId to set
	 */
	public void setStartCityId(CityDto startCityId) {
		this.startCityId = startCityId;
	}

	/**
	 * @return the endCityId
	 */
	public CityDto getEndCityId() {
		return endCityId;
	}

	/**
	 * @param endCityId the endCityId to set
	 */
	public void setEndCityId(CityDto endCityId) {
		this.endCityId = endCityId;
	}

	public CompanyRoute _toJpa(){
		CompanyRoute companyRoute = new CompanyRoute();
		companyRoute.setCompId(this.compId);
		companyRoute.setDelFlag(this.delFlag);
		companyRoute.setEndCityId(this.endCityId._toJpa());
		companyRoute.setId(this.id);
		companyRoute.setStartCityId(this.startCityId._toJpa());
		companyRoute.setDistance(this.distance);
		companyRoute.setDeliveryDays(this.deliveryDays);
		companyRoute.setBuferTime(this.buferTime);
//		companyRoute.setTransportDetailId(this.transportDetailsId);
//		companyRoute.setCost(this.cost);
//		companyRoute.setAdvanceAmt(this.advanceAmt);
		return companyRoute;
	}
/*
	*//**
	 * @return the transportDetailsId
	 *//*
	public Integer getTransportDetailsId() {
		return transportDetailsId;
	}

	*//**
	 * @param transportDetailsId the transportDetailsId to set
	 *//*
	public void setTransportDetailsId(Integer transportDetailsId) {
		this.transportDetailsId = transportDetailsId;
	}

	*//**
	 * @return the cost
	 *//*
	public Integer getCost() {
		return cost;
	}

	*//**
	 * @param cost the cost to set
	 *//*
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	*//**
	 * @return the advanceAmt
	 *//*
	public Integer getAdvanceAmt() {
		return advanceAmt;
	}

	*//**
	 * @param advanceAmt the advanceAmt to set
	 *//*
	public void setAdvanceAmt(Integer advanceAmt) {
		this.advanceAmt = advanceAmt;
	}
*/

	/**
	 * @return the routeName
	 */
	public String getRouteName() {
		return routeName;
	}

	/**
	 * @param routeName the routeName to set
	 */
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	/**
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * @return the deliveryDays
	 */
	public Integer getDeliveryDays() {
		return deliveryDays;
	}

	/**
	 * @param deliveryDays the deliveryDays to set
	 */
	public void setDeliveryDays(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	/**
	 * @return the buferTime
	 */
	public Integer getBuferTime() {
		return buferTime;
	}

	/**
	 * @param buferTime the buferTime to set
	 */
	public void setBuferTime(Integer buferTime) {
		this.buferTime = buferTime;
	}
}
