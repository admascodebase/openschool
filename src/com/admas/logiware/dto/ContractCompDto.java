package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.admas.logiware.jpa.CustContractCompany;

public class ContractCompDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7123671403769902910L;
	private Integer id;
	private String name;
    private Integer compId; 
	private String address;
	private String type;
    private String contactPersion;
	private String contactNo1;
	private String contactNo2;
	private String product;
	private String tinNo;
	private String email;
	private String website;
	private String ownerDetails;
	private String ownerContact;
	private String loadingStaff;
	private String loadingStaffContact;
	private String unloadingStaff;
	private String unloadingStaffContact;
	private Integer createdBy;
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

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @return the tinNo
	 */
	public String getTinNo() {
		return tinNo;
	}

	/**
	 * @param tinNo the tinNo to set
	 */
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the ownerDetails
	 */
	public String getOwnerDetails() {
		return ownerDetails;
	}

	/**
	 * @param ownerDetails the ownerDetails to set
	 */
	public void setOwnerDetails(String ownerDetails) {
		this.ownerDetails = ownerDetails;
	}

	/**
	 * @return the ownerContact
	 */
	public String getOwnerContact() {
		return ownerContact;
	}

	/**
	 * @param ownerContact the ownerContact to set
	 */
	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}

	/**
	 * @return the loadingStaff
	 */
	public String getLoadingStaff() {
		return loadingStaff;
	}

	/**
	 * @param loadingStaff the loadingStaff to set
	 */
	public void setLoadingStaff(String loadingStaff) {
		this.loadingStaff = loadingStaff;
	}

	/**
	 * @return the loadingStaffContact
	 */
	public String getLoadingStaffContact() {
		return loadingStaffContact;
	}

	/**
	 * @param loadingStaffContact the loadingStaffContact to set
	 */
	public void setLoadingStaffContact(String loadingStaffContact) {
		this.loadingStaffContact = loadingStaffContact;
	}

	/**
	 * @return the unloadingStaff
	 */
	public String getUnloadingStaff() {
		return unloadingStaff;
	}

	/**
	 * @param unloadingStaff the unloadingStaff to set
	 */
	public void setUnloadingStaff(String unloadingStaff) {
		this.unloadingStaff = unloadingStaff;
	}

	/**
	 * @return the unloadingStaffContact
	 */
	public String getUnloadingStaffContact() {
		return unloadingStaffContact;
	}

	/**
	 * @param unloadingStaffContact the unloadingStaffContact to set
	 */
	public void setUnloadingStaffContact(String unloadingStaffContact) {
		this.unloadingStaffContact = unloadingStaffContact;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContractCompDto [id=" + id + ", name=" + name + ", compId=" + compId + ", address=" + address
				+ ", type=" + type + ", contactPersion=" + contactPersion + ", contactNo1=" + contactNo1
				+ ", contactNo2=" + contactNo2 + ", product=" + product + ", tinNo=" + tinNo + ", email=" + email
				+ ", website=" + website + ", ownerDetails=" + ownerDetails + ", ownerContact=" + ownerContact
				+ ", loadingStaff=" + loadingStaff + ", loadingStaffContact=" + loadingStaffContact
				+ ", unloadingStaff=" + unloadingStaff + ", unloadingStaffContact=" + unloadingStaffContact
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", delFlag=" + delFlag + "]";
	}

	public CustContractCompany _toJpa(){
		CustContractCompany custContractCompany = new CustContractCompany();
		custContractCompany.setAddress(this.address);
		custContractCompany.setCompId(this.getCompId());
		custContractCompany.setContactNo1(this.contactNo1);
		custContractCompany.setContactNo2(this.contactNo2);
		custContractCompany.setProduct(this.product);
		custContractCompany.setTin_no(this.tinNo);
		custContractCompany.setEmail(this.email);
		custContractCompany.setWebsite(this.website);
		custContractCompany.setContactPersion(this.contactPersion);
		custContractCompany.setOwnerDetails(this.ownerDetails);
		custContractCompany.setOwnerContact(this.ownerContact);
		custContractCompany.setLoadingStaff(this.loadingStaff);
		custContractCompany.setLoadingStaffContact(this.loadingStaffContact);
		custContractCompany.setUnloadingStaff(this.unloadingStaff);
		custContractCompany.setUnloadingStaffContact(this.unloadingStaffContact);
		custContractCompany.setCreatedBy(this.createdBy);
		custContractCompany.setCreatedOn(new Date());
		custContractCompany.setDelFlag('N');
		custContractCompany.setId(this.id);
		custContractCompany.setName(this.name);
		custContractCompany.setType(this.type);
		custContractCompany.setUpdatedBy(this.updatedBy);
		custContractCompany.setUpdatedOn(new Date());
		return custContractCompany;
	}
	
}
