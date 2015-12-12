package com.admas.logiware.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.admas.logiware.dto.CompanyLoadToTransDto;

@Entity
@Table(name = "company_load_to_trans")
public class CompanyLoadToTrans implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "COMP_LOAD_DTL_ID", nullable = false)
	private CompanyLoadDetail companyLoadDetail;
	
	@ManyToOne
	@JoinColumn(name = "OWNER_TRANS_DTL_ID", nullable = false)
	private TransportDetails transportDetails;
	
	@Column(name = "ASSIGN_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date assignDate;
	
	@Column(name = "CREATED_BY", nullable = false)
	private Integer createdBy;

	@Column(name = "UPDATED_BY")
	private Integer updatedBy;

	@Column(name = "CREATED_ON", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "DEL_FLG")
	private Character delFlag;
	
	@Column(name = "STATUS")
	private String status;

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
	 * @return the companyLoadDetail
	 */
	public CompanyLoadDetail getCompanyLoadDetail() {
		return companyLoadDetail;
	}

	/**
	 * @param companyLoadDetail the companyLoadDetail to set
	 */
	public void setCompanyLoadDetail(CompanyLoadDetail companyLoadDetail) {
		this.companyLoadDetail = companyLoadDetail;
	}

	/**
	 * @return the transportDetails
	 */
	public TransportDetails getTransportDetails() {
		return transportDetails;
	}

	/**
	 * @param transportDetails the transportDetails to set
	 */
	public void setTransportDetails(TransportDetails transportDetails) {
		this.transportDetails = transportDetails;
	}

	/**
	 * @return the assignDate
	 */
	public Date getAssignDate() {
		return assignDate;
	}

	/**
	 * @param assignDate the assignDate to set
	 */
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public CompanyLoadToTransDto _toDto(){
		CompanyLoadToTransDto companyLoadToTransDto = new CompanyLoadToTransDto();
		companyLoadToTransDto.setAssignDate(this.assignDate);
		companyLoadToTransDto.setCompanyLoadDetail(this.companyLoadDetail._toDto());
		companyLoadToTransDto.setCreatedBy(this.createdBy);
		companyLoadToTransDto.setCreatedOn(this.createdOn);
		companyLoadToTransDto.setDelFlag(this.delFlag);
		companyLoadToTransDto.setId(this.id);
		companyLoadToTransDto.setTransportDetails(this.transportDetails._toDto());
		companyLoadToTransDto.setUpdatedBy(this.updatedBy);
		companyLoadToTransDto.setUpdatedOn(this.updatedOn);
		companyLoadToTransDto.setStatus(this.status);
		return companyLoadToTransDto;
	}
	
	
}
