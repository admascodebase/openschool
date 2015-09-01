/**
 * 
 */
package com.admas.logiware.dto;

import java.io.Serializable;


/**
 * @author amol
 *
 */
public class TransportTypeDtlDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2403867592563755205L;
		
	private Integer id;
	private Integer transId;
	private String truckName;
	private String description;
	private String size;
	private Integer unit;
	private Integer wheelsNo;
	private String width;
	private String maxCapacity;
	private String capacity;

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
	
	}
