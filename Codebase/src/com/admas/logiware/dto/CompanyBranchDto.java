package com.admas.logiware.dto;
import java.io.Serializable;
public class CompanyBranchDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4190526634246757540L;
	
	private Integer id;
	
	private Integer compId;
	
	private String name;
	
	private String address;
	
	private String contactNo;
	
	private String emailId;
	
	private Character delFlag;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompBranch [id=" + id + ", compId=" + compId + ", name=" + name
				+ ", address=" + address + ", contactNo=" + contactNo
				+ ", emailId=" + emailId + "]";
	}

	public Character getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
	}

}
