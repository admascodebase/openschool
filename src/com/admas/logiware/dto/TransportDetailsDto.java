package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

import com.admas.logiware.jpa.TransportDetails;

public class TransportDetailsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private Integer ownId;
	private Integer loweryNo;
	private Integer tranTypeDtlId;
	private Integer updatedBy;
	private Date createdOn;
	private Date updatedOn;	
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
	
	public TransportDetails to_Jpa(){
		TransportDetails transportDetails =  new TransportDetails();
		transportDetails.setCreatedOn(this.createdOn);
		transportDetails.setDelFlag(this.delFlag);
		transportDetails.setId(this.id);
		transportDetails.setLoweryNo(this.loweryNo);
		transportDetails.setTranTypeDtlId(this.tranTypeDtlId);
		transportDetails.setUpdatedBy(this.updatedBy);
		transportDetails.setUpdatedOn(this.updatedOn);
		return transportDetails;
	}

}
