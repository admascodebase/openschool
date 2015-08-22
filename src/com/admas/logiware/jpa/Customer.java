/**
 * 
 */
package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAJ
 *
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",unique=true,nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="NAME",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="CONTACT_NO",nullable=false)
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	@Column(name="EMAIL_ID",nullable=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="WEBSITE",nullable=true)
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Column(name="PRICE_PLAN_ID",nullable=true)
	public int getPricePlanId() {
		return pricePlanId;
	}
	public void setPricePlanId(int pricePlanId) {
		this.pricePlanId = pricePlanId;
	}
	@Column(name="ADDRESS",nullable=true)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="EMP_ID",nullable=true)
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact_no=" + contact_no + ", email=" + email
				+ ", website=" + website + ", pricePlanId=" + pricePlanId + ", address=" + address + ", employeeId="
				+ employeeId + "]";
	}

}
