/**
 * 
 */
package com.admas.logiware.dto;

import java.io.Serializable;

/**
 * @author Admas
 * 
 */
public class CompanyDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7420799756045340233L;

	/**
	 * 
	 */
	public CompanyDto() {

	}

	private Integer id;
	private String name;
	private Integer custId;
	private String contactNo1;
	private String contactNo2;
	private String address;
	private String emailId1;
	private String emailId2;
	private String panNo;
	private String tanNo;
	private String logo;
	private String tagLine;
	private Character delFlag;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the custId
	 */
	public Integer getCustId() {
		return custId;
	}

	/**
	 * @param custId
	 *            the custId to set
	 */
	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	/**
	 * @return the contactNo1
	 */
	public String getContactNo1() {
		return contactNo1;
	}

	/**
	 * @param contactNo1
	 *            the contactNo1 to set
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
	 * @param contactNo2
	 *            the contactNo2 to set
	 */
	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the emailId1
	 */
	public String getEmailId1() {
		return emailId1;
	}

	/**
	 * @param emailId1
	 *            the emailId1 to set
	 */
	public void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}

	/**
	 * @return the emailId2
	 */
	public String getEmailId2() {
		return emailId2;
	}

	/**
	 * @param emailId2
	 *            the emailId2 to set
	 */
	public void setEmailId2(String emailId2) {
		this.emailId2 = emailId2;
	}

	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * @param panNo
	 *            the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * @return the tanNo
	 */
	public String getTanNo() {
		return tanNo;
	}

	/**
	 * @param tanNo
	 *            the tanNo to set
	 */
	public void setTanNo(String tanNo) {
		this.tanNo = tanNo;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo
	 *            the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the tagLine
	 */
	public String getTagLine() {
		return tagLine;
	}

	/**
	 * @param tagLine
	 *            the tagLine to set
	 */
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + ", custId=" + custId
				+ ", contactNo1=" + contactNo1 + ", contactNo2=" + contactNo2
				+ ", address=" + address + ", emailId1=" + emailId1
				+ ", emailId2=" + emailId2 + ", panNo=" + panNo + ", tanNo="
				+ tanNo + ", logo=" + logo + ", tagLine=" + tagLine + ", delFlag=" + delFlag + "]";
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

}
