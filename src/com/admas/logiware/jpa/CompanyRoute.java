package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.admas.logiware.dto.CompanyRouteDto;

@Entity
@Table(name="cust_contract_route")
public class CompanyRoute implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CONTRACT_COMP_ID" ,nullable = false )
	private Integer compId;
	
	@ManyToOne
	@JoinColumn(name="START_ROUTE", nullable=false)
//	@Column(name="START_ROUTE" ,nullable = false )
	private City startCityId;
	
	@ManyToOne
	@JoinColumn(name="END_ROUTE", nullable=false)
//	@Column(name="END_ROUTE" ,nullable = false )
	private City endCityId;
	
	@Column(name="DISTANCE" ,nullable = false)
	private Integer distance;
	
	@Column(name="DELIVERY_DAYS" ,nullable = false)
	private Integer deliveryDays;
	
	@Column(name="BUFER_TIME" ,nullable = false)
	private Integer buferTime;
	
	/*@Column(name="TRANSPORT_DTL_ID" ,nullable = false )
	private Integer transportDetailId;
	
	@Column(name="COST" ,nullable = false )
	private Integer cost;
	
	@Column(name="ADVANCE_AMT" ,nullable = false )
	private Integer advanceAmt;
*/	
	@Column(name="DEL_FLAG" ,nullable = false)
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
	public City getStartCityId() {
		return startCityId;
	}

	/**
	 * @param startCityId the startCityId to set
	 */
	public void setStartCityId(City startCityId) {
		this.startCityId = startCityId;
	}

	/**
	 * @return the endCityId
	 */
	public City getEndCityId() {
		return endCityId;
	}

	/**
	 * @param endCityId the endCityId to set
	 */
	public void setEndCityId(City endCityId) {
		this.endCityId = endCityId;
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

	/*	
	*//**
	 * @return the transportDetailId
	 *//*
	public Integer getTransportDetailId() {
		return transportDetailId;
	}

	*//**
	 * @param transportDetailId the transportDetailId to set
	 *//*
	public void setTransportDetailId(Integer transportDetailId) {
		this.transportDetailId = transportDetailId;
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
	
	
	public CompanyRouteDto _toDto(){
		CompanyRouteDto companyRouteDto = new CompanyRouteDto();
		companyRouteDto.setCompId(this.compId);
		companyRouteDto.setDelFlag(this.delFlag);
		companyRouteDto.setEndCityId(this.endCityId._toDto());
		companyRouteDto.setId(this.id);
		companyRouteDto.setStartCityId(this.startCityId._toDto());
		companyRouteDto.setDistance(this.distance);
		companyRouteDto.setDeliveryDays(this.deliveryDays);
		companyRouteDto.setBuferTime(this.buferTime);
//		companyRouteDto.setTransportDetailsId(this.transportDetailId);
//		companyRouteDto.setCost(this.cost);
//		companyRouteDto.setAdvanceAmt(this.advanceAmt);
		return companyRouteDto;
	}

}
