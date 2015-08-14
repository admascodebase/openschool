package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class HostelDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*hostel details*/
	
	@FormParam("hostelName")
	private String hostelName;
	@FormParam("hostelAddress")
	private String hostelAddress;
	@FormParam("address")
	private CustomerAddress address;	
	@FormParam("wingDetail")
	private WingDetail wingDetail;
	@FormParam("hostelContact")
	private HostelContact hostelContact;
	
	/*hostel Authority details*/
	@FormParam("hostelAuthority")
	private String hostelAuthority;
	
	@FormParam("hostelAuthorityType")
	private String hostelAuthorityType;

	/**
	 * @return the hostelName
	 */
	public String getHostelName() {
		return hostelName;
	}

	/**
	 * @param hostelName the hostelName to set
	 */
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	/**
	 * @return the hostelAddress
	 */
	public String getHostelAddress() {
		return hostelAddress;
	}

	/**
	 * @param hostelAddress the hostelAddress to set
	 */
	public void setHostelAddress(String hostelAddress) {
		this.hostelAddress = hostelAddress;
	}

	/**
	 * @return the address
	 */
	public CustomerAddress getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(CustomerAddress address) {
		this.address = address;
	}



	/**
	 * @return the wingDetail
	 */
	public WingDetail getWingDetail() {
		return wingDetail;
	}

	/**
	 * @param wingDetail the wingDetail to set
	 */
	public void setWingDetail(WingDetail wingDetail) {
		this.wingDetail = wingDetail;
	}

	/**
	 * @return the hostelAuthority
	 */
	public String getHostelAuthority() {
		return hostelAuthority;
	}

	/**
	 * @param hostelAuthority the hostelAuthority to set
	 */
	public void setHostelAuthority(String hostelAuthority) {
		this.hostelAuthority = hostelAuthority;
	}

	/**
	 * @return the hostelAuthorityType
	 */
	public String getHostelAuthorityType() {
		return hostelAuthorityType;
	}

	/**
	 * @param hostelAuthorityType the hostelAuthorityType to set
	 */
	public void setHostelAuthorityType(String hostelAuthorityType) {
		this.hostelAuthorityType = hostelAuthorityType;
	}

	/**
	 * @return the hostelContact
	 */
	public HostelContact getHostelContact() {
		return hostelContact;
	}

	/**
	 * @param hostelContact the hostelContact to set
	 */
	public void setHostelContact(HostelContact hostelContact) {
		this.hostelContact = hostelContact;
	}

	
	
}
