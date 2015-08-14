package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class Customer implements Serializable{

private static final long serialVersionUID = 1L;
	
	private String id;
	@FormParam("companyName")
	private String companyName;
	@FormParam("address")
	private String address;
	@FormParam("companyAddress")
	private String companyAddress;
	@FormParam("contactNo1")
	private String contactNo1;
	@FormParam("emailId")
	private String emailId;
	@FormParam("website")
	private String website;
	@FormParam("contactPerson")
	private String contactperson;
	@FormParam("contactPersonNo")
	private String contactPersonNo;
	@FormParam("pricePlan")
	private String pricePlan;
	@FormParam("smsGateway")
	private String smsGateway;
	
	public Customer() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getContactPersonNo() {
		return contactPersonNo;
	}

	public void setContactPersonNo(String contactPersonNo) {
		this.contactPersonNo = contactPersonNo;
	}

	public String getPricePlan() {
		return pricePlan;
	}

	public void setPricePlan(String pricePlan) {
		this.pricePlan = pricePlan;
	}

	public String getSmsGateway() {
		return smsGateway;
	}

	public void setSmsGateway(String smsGateway) {
		this.smsGateway = smsGateway;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", companyName=" + companyName
				+ ", address=" + address + ", companyAddress=" + companyAddress
				+ ", contactNo1=" + contactNo1 + ", emailId=" + emailId
				+ ", website=" + website + ", contactperson=" + contactperson
				+ ", contactPersonNo=" + contactPersonNo + ", pricePlan="
				+ pricePlan + ", smsGateway=" + smsGateway + "]";
	}
	
	
	
	
}
