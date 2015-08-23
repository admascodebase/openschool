/**
 * 
 */
package com.admas.logiware.dto;

/**
 * @author Raj
 *
 */
public class Customer {

	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String name;
	private String contact_no;
	private String email;
	private String website;
	private int pricePlanId;
	private String address;
	private int employeeId;
	private String del_flag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getPricePlanId() {
		return pricePlanId;
	}
	public void setPricePlanId(int pricePlanId) {
		this.pricePlanId = pricePlanId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact_no=" + contact_no + ", email=" + email
				+ ", website=" + website + ", pricePlanId=" + pricePlanId + ", address=" + address + ", employeeId="
				+ employeeId + ", del_flag=" + del_flag + "]";
	}

	
}
