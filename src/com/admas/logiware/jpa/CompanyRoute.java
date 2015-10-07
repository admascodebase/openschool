package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="START_ROUTE" ,nullable = false )
	private Integer startCityId;
	
	@Column(name="END_ROUTE" ,nullable = false )
	private Integer endCityId;
	
	@Column(name="TRANSPORT_DTL_ID" ,nullable = false )
	private Integer transportDetailId;
	
	@Column(name="COST" ,nullable = false )
	private Integer cost;
	
	@Column(name="ADVANCE_AMT" ,nullable = false )
	private Integer advanceAmt;
	
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
	
	
	/**
	 * @return the transportDetailId
	 */
	public Integer getTransportDetailId() {
		return transportDetailId;
	}

	/**
	 * @param transportDetailId the transportDetailId to set
	 */
	public void setTransportDetailId(Integer transportDetailId) {
		this.transportDetailId = transportDetailId;
	}

	/**
	 * @return the cost
	 */
	public Integer getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	/**
	 * @return the advanceAmt
	 */
	public Integer getAdvanceAmt() {
		return advanceAmt;
	}

	/**
	 * @param advanceAmt the advanceAmt to set
	 */
	public void setAdvanceAmt(Integer advanceAmt) {
		this.advanceAmt = advanceAmt;
	}

	public CompanyRouteDto _toDto(){
		CompanyRouteDto companyRouteDto = new CompanyRouteDto();
		companyRouteDto.setCompId(this.compId);
		companyRouteDto.setDelFlag(this.delFlag);
		companyRouteDto.setEndCityId(this.endCityId);
		companyRouteDto.setId(this.compId);
		companyRouteDto.setStartCityId(this.startCityId);
		companyRouteDto.setTransportDetailsId(this.transportDetailId);
		companyRouteDto.setCost(this.cost);
		companyRouteDto.setAdvanceAmt(this.advanceAmt);
		return companyRouteDto;
	}

}
