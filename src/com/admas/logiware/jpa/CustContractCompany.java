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
	
	@Column(name="PRODUCT" ,nullable = false)
	private String product;
	
	@Column(name="TIN_NO" ,nullable = false)
	private String tinNo;
	
	@Column(name="EMAIL" ,nullable = false)
	private String email;
	
	@Column(name="WEBSITE" ,nullable = false)
	private String website;
	
	@Column(name="OWNER_DETAILS" ,nullable = false)
	private String ownerDetails;
	
	@Column(name="OWNER_CONTACT" ,nullable = false)
	private String ownerContact;
	
	@Column(name="LOADING_STAFF" ,nullable = false)
	private String loadingStaff;
	
	@Column(name="LOADING_STAFF_CONTACT" ,nullable = false)
	private String loadingStaffContact;
	
	@Column(name="UNLOADING_STAFF" ,nullable = false)
	private String unloadingStaff;
	
	@Column(name="UNLOADING_STAFF_CONTACT" ,nullable = false)
	private String unloadingStaffContact;
	
	@Column(name="IS_REGULAR" ,nullable = false)
	private Character isregular;
	
	
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
	 * @return the tin_no
	 */
	public String getTin_no() {
		return tinNo;
	}

	/**
	 * @param tin_no the tin_no to set
	 */
	public void setTin_no(String tinNo) {
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
	 * @return the isregular
	 */
	public Character getIsregular() {
		return isregular;
	}

	/**
	 * @param isregular the isregular to set
	 */
	public void setIsregular(Character isregular) {
		this.isregular = isregular;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustContractCompany [id=" + id + ", name=" + name + ", compId=" + compId + ", address=" + address
				+ ", type=" + type + ", contactPersion=" + contactPersion + ", contactNo1=" + contactNo1
				+ ", contactNo2=" + contactNo2 + ", product=" + product + ", tinNo=" + tinNo + ", email=" + email
				+ ", website=" + website + ", ownerDetails=" + ownerDetails + ", ownerContact=" + ownerContact
				+ ", loadingStaff=" + loadingStaff + ", loadingStaffContact=" + loadingStaffContact
				+ ", unloadingStaff=" + unloadingStaff + ", unloadingStaffContact=" + unloadingStaffContact
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", isRegular=" + isregular + ", delFlag=" + delFlag + "]";
	}

	public ContractCompDto _toDto(){
		ContractCompDto contractCompDto = new ContractCompDto();
		contractCompDto.setAddress(this.address);
		contractCompDto.setCompId(this.getCompId());
		contractCompDto.setContactNo1(this.contactNo1);
		contractCompDto.setContactNo2(this.contactNo2);
		contractCompDto.setProduct(this.product);
		contractCompDto.setTinNo(this.tinNo);
		contractCompDto.setEmail(this.email);
		contractCompDto.setWebsite(this.website);
		contractCompDto.setContactPersion(this.contactPersion);
		contractCompDto.setOwnerDetails(this.ownerDetails);
		contractCompDto.setOwnerContact(this.ownerContact);
		contractCompDto.setLoadingStaff(this.loadingStaff);
		contractCompDto.setLoadingStaffContact(this.loadingStaffContact);
		contractCompDto.setUnloadingStaff(this.unloadingStaff);
		contractCompDto.setUnloadingStaffContact(this.unloadingStaffContact);
		contractCompDto.setCreatedBy(this.createdBy);
		contractCompDto.setCreatedOn(this.createdOn);
		contractCompDto.setDelFlag(this.delFlag);
		contractCompDto.setId(this.id);
		contractCompDto.setName(this.name);
		contractCompDto.setType(this.type);
		contractCompDto.setUpdatedBy(this.updatedBy);
		contractCompDto.setUpdatedOn(this.updatedOn);
		contractCompDto.setIsRegular(this.isregular);
		return contractCompDto;
	}
	
}
