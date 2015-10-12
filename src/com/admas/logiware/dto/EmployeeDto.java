package com.admas.logiware.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable{


	private static final long serialVersionUID = -5453415813139099505L;

	private Integer id;
	 
	private Integer compId;
	
	private Integer branchId;
	
	private String name;
	
	private String address;
	
	private String contactNo;
	
	private Character gender;
	
	private Character isSysAcc;
	
	private String salaryType;
	
	private Float salary;
	
	private String pan;

	private Character delFlag;

	private Integer roleId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Character getIsSysAcc() {
		return isSysAcc;
	}

	public void setIsSysAcc(Character isSysAcc) {
		this.isSysAcc = isSysAcc;
	}

	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "CustCompEmployee [id=" + id + ", compId=" + compId
				+ ", branchId=" + branchId + ", name=" + name + ", address="
				+ address + ", contactNo=" + contactNo + ", gender=" + gender
				+ ", isSysAcc=" + isSysAcc + ", salaryType=" + salaryType
				+ ", salary=" + salary + ", pan=" + pan + "]";
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
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
