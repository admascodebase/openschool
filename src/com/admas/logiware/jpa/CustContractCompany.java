package com.admas.logiware.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.admas.logiware.dto.ContractCompDto;

@Entity
@Table(name="cust_contract_company")
public class CustContractCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME" ,nullable = false )
	private String name;
	
	@Column(name="COMP_ID" ,nullable = false )
    private Integer compId; 
	
	@Column(name="ADDRESS" ,nullable = true )
	private String address;
	
	@Column(name="TYPE" ,nullable = false )
	private String type;
	
	@Column(name="CONTACT_PERSION" ,nullable = false )
    private String contactPersion;
	
	@Column(name="CONTACT_NO1" ,nullable = false )
	private String contactNo1;
	
	@Column(name="CONTACT_NO2")
	private String contactNo2;
	
	@Column(name="CREATED_BY" ,nullable = false)
	private Integer createdBy;
	
	@Column(name="UPDATED_BY")
	private Integer updatedBy;
	
	@Column(name="CREATED_ON",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@Column(name="DEL_FLG")
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

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the contactPersion
	 */
	public String getContactPersion() {
		return contactPersion;
	}

	/**
	 * @param contactPersion the contactPersion to set
	 */
	public void setContactPersion(String contactPersion) {
		this.contactPersion = contactPersion;
	}

	/**
	 * @return the contactNo1
	 */
	public String getContactNo1() {
		return contactNo1;
	}

	/**
	 * @param contactNo1 the contactNo1 to set
	 */
	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	/**
	 * @return the contactNo2
	 */
	public String getContactNo2() {
		return contactNo2;
	}

	/**
	 * @param contactNo2 the contactNo2 to set
	 */
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustContractCompany [id=" + id + ", name=" + name + ", compId="
				+ compId + ", address=" + address + ", type=" + type
				+ ", contactPersion=" + contactPersion + ", contactNo1="
				+ contactNo1 + ", contactNo2=" + contactNo2 + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", delFlag="
				+ delFlag + "]";
	}
	
	public ContractCompDto _toDto(){
		ContractCompDto contractCompDto = new ContractCompDto();
		contractCompDto.setAddress(this.address);
		contractCompDto.setCompId(this.getCompId());
		contractCompDto.setContactNo1(this.contactNo1);
		contractCompDto.setContactNo2(this.contactNo2);
		contractCompDto.setContactNo2(this.contactNo2);
		contractCompDto.setContactPersion(this.contactPersion);
		contractCompDto.setCreatedBy(this.createdBy);
		contractCompDto.setCreatedOn(this.createdOn);
		contractCompDto.setDelFlag(this.delFlag);
		contractCompDto.setId(this.id);
		contractCompDto.setName(this.name);
		contractCompDto.setType(this.type);
		contractCompDto.setUpdatedBy(this.updatedBy);
		contractCompDto.setUpdatedOn(this.updatedOn);
		return contractCompDto;
	}
	
}
