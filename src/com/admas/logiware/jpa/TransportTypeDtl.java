package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.admas.logiware.dto.TransportTypeDtlDto;

@Entity
@Table(name="cust_transport_type_dtl")
public class TransportTypeDtl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5786493494779625817L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="TRANS_ID" ,nullable = false )
	private Integer transId;
	
	@Column(name="TRUCK_NAME" ,nullable = false )
	private String truckName;
	
	@Column(name="DESCRIPTION" )
	private String description;
	
	@Column(name="SIZE" ,nullable = false )
	private String size;
	  
	@Column(name="UNIT" ,nullable = false )
	private Integer unit;
	
	@Column(name="WHEEL_NOS" ,nullable = false)
	private Integer wheelsNo;
	
	@Column(name="WIDTH" ,nullable = false)
	private String width;
	
	@Column(name="MAX_CAPACITY" ,nullable = false)
	private String maxCapacity;
	
	@Column(name="CAPACITY" ,nullable = false)
	private String capacity;

	@Column(name="DEL_FLAG" ,nullable = true)
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
	 * @return the transId
	 */
	public Integer getTransId() {
		return transId;
	}

	/**
	 * @param transId the transId to set
	 */
	public void setTransId(Integer transId) {
		this.transId = transId;
	}

	/**
	 * @return the truckName
	 */
	public String getTruckName() {
		return truckName;
	}

	/**
	 * @param truckName the truckName to set
	 */
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the unit
	 */
	public Integer getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	/**
	 * @return the wheelsNo
	 */
	public Integer getWheelsNo() {
		return wheelsNo;
	}

	/**
	 * @param wheelsNo the wheelsNo to set
	 */
	public void setWheelsNo(Integer wheelsNo) {
		this.wheelsNo = wheelsNo;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the maxCapacity
	 */
	public String getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * @param maxCapacity the maxCapacity to set
	 */
	public void setMaxCapacity(String maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * @return the capacity
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
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
		return "TransportTypeDtl [id=" + id + ", transId=" + transId
				+ ", truckName=" + truckName + ", description=" + description
				+ ", size=" + size + ", unit=" + unit + ", wheelsNo="
				+ wheelsNo + ", width=" + width + ", maxCapacity="
				+ maxCapacity + ", capacity=" + capacity + "]";
	}
	
	public TransportTypeDtl _toJpa(TransportTypeDtlDto transportTypeDto){
		TransportTypeDtl transportTypeDtl = new TransportTypeDtl();
		transportTypeDtl.setId(transportTypeDto.getId());
		transportTypeDtl.setCapacity(transportTypeDto.getCapacity());
		transportTypeDtl.setDescription(transportTypeDto.getDescription());
		transportTypeDtl.setMaxCapacity(transportTypeDto.getMaxCapacity());
		transportTypeDtl.setSize(transportTypeDto.getSize());
		transportTypeDtl.setTransId(transportTypeDto.getTransId());
		transportTypeDtl.setTruckName(transportTypeDto.getTruckName());
		transportTypeDtl.setUnit(transportTypeDto.getUnit());
		transportTypeDtl.setWheelsNo(transportTypeDto.getWheelsNo());
		transportTypeDtl.setWidth(transportTypeDto.getWidth());
		transportTypeDtl.setDelFlag(transportTypeDto.getDelFlag());
		return transportTypeDtl;
	}
	
	
	public TransportTypeDtlDto _toDto(){
		TransportTypeDtlDto transportTypeDto = new TransportTypeDtlDto();
		transportTypeDto.setId(this.id);
		transportTypeDto.setCapacity(this.capacity);
		transportTypeDto.setDescription(this.description);
		transportTypeDto.setMaxCapacity(this.maxCapacity);
		transportTypeDto.setSize(this.size);
		transportTypeDto.setTransId(this.transId);
		transportTypeDto.setTruckName(this.truckName);
		transportTypeDto.setUnit(this.unit);
		transportTypeDto.setWheelsNo(this.wheelsNo);
		transportTypeDto.setWidth(this.width);
		transportTypeDto.setDelFlag(this.delFlag);
		return transportTypeDto;
	}


}
