package com.admas.logiware.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.admas.logiware.dto.TransportDetailsDto;

@Entity
@Table(name="owner_transport_details")
public class TransportDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1682700674077636105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(name="LOWERY_OWNER_ID" ,nullable = false )
	private Integer ownId;
	
	@Column(name="LOWERY_NO" ,nullable = false )
	private Integer loweryNo;
	
	@Column(name="TRANSPORT_TYPE_DTL_ID" ,nullable = false )
	private Integer tranTypeDtlId;
	
	
	@Column(name="CREATED_BY")
	private Integer createdBy;
	
	@Column(name="UPDATED_BY")
	private Integer updatedBy;
	
	@Column(name="CREATED_ON",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@Column(name="DEL_FLAG" ,nullable = false) 
	private Character delFlag;

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
	 * @return the ownId
	 */
	public Integer getOwnId() {
		return ownId;
	}

	/**
	 * @param ownId the ownId to set
	 */
	public void setOwnId(Integer ownId) {
		this.ownId = ownId;
	}

	/**
	 * @return the loweryNo
	 */
	public Integer getLoweryNo() {
		return loweryNo;
	}

	/**
	 * @param loweryNo the loweryNo to set
	 */
	public void setLoweryNo(Integer loweryNo) {
		this.loweryNo = loweryNo;
	}

	/**
	 * @return the tranTypeDtlId
	 */
	public Integer getTranTypeDtlId() {
		return tranTypeDtlId;
	}

	/**
	 * @param tranTypeDtlId the tranTypeDtlId to set
	 */
	public void setTranTypeDtlId(Integer tranTypeDtlId) {
		this.tranTypeDtlId = tranTypeDtlId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransportDetails [id=" + id + ", ownId=" + ownId
				+ ", loweryNo=" + loweryNo + ", tranTypeDtlId=" + tranTypeDtlId
				+ ", updatedBy=" + updatedBy + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", delFlag=" + delFlag + "]";
	}
	
	public TransportDetailsDto _toDto(){
		TransportDetailsDto transportDetailsDto =  new TransportDetailsDto();
		transportDetailsDto.setCreatedOn(this.createdOn);
		transportDetailsDto.setDelFlag(this.delFlag);
		transportDetailsDto.setId(this.id);
		transportDetailsDto.setLoweryNo(this.loweryNo);
		transportDetailsDto.setTranTypeDtlId(this.tranTypeDtlId);
		transportDetailsDto.setUpdatedBy(this.updatedBy);
		transportDetailsDto.setUpdatedOn(this.updatedOn);
		transportDetailsDto.setOwnId(this.ownId);
		return transportDetailsDto;
	}
}
