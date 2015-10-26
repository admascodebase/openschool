package com.admas.logiware.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author abc
 *
 */
@Entity
@Table(name="cust_comp_employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -820241511542881571L;

	
	public Employee() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(name="COMP_ID" ,nullable = false )
	private Integer compId;
	
	@Column(name="BRANCH_ID")
	private Integer branchId;
	
	@Column(name="NAME" ,nullable = false)
	private String name;
	
	@Column(name="ADDRESS" ,nullable = false)
	private String address;
	
	@Column(name="CONTACT_NO",nullable = false)
	private String contactNo;
	
	@Column(name="GENDER",nullable = false)
	private Character gender;
	
	@Column(name="IS_SYS_ACC",nullable = false)
	private Character isSysAcc;
	
	@Column(name="SALARAY_TYPE")
	private String salaryType;
	
	@Column(name="SALARAY")
	private Float salary;
	
/*	@Column(name="EMAIL")
	private String email;
*/	
	@Column(name="PAN")
	private String pan;
	
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
	
	@Column(name="ROLE_ID")
	private Integer roleId;

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
	 * @return the delFlag
	 */
	public Character getDelFlag() {
		return delFlag;
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

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Character delFlag) {
		this.delFlag = delFlag;
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
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
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
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @return the gender
	 */
	public Character getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Character gender) {
		this.gender = gender;
	}

	/**
	 * @return the isSysAcc
	 */
	public Character getIsSysAcc() {
		return isSysAcc;
	}

	/**
	 * @param isSysAcc the isSysAcc to set
	 */
	public void setIsSysAcc(Character isSysAcc) {
		this.isSysAcc = isSysAcc;
	}

	/**
	 * @return the salaryType
	 */
	public String getSalaryType() {
		return salaryType;
	}

	/**
	 * @param salaryType the salaryType to set
	 */
	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	/**
	 * @return the salary
	 */
	public Float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}

	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
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
	 * @return the delFlg
	 */
	public Character getDelFlg() {
		return delFlag;
	}

	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(Character delFlg) {
		this.delFlag = delFlg;
	}
	
	/**
	 * @return the email
	 */
/*	public String getEmail() {
		return email;
	}
*/
	/**
	 * @param email the email to set
	 */
/*	public void setEmail(String email) {
		this.email = email;
	}
*/
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustCompanyEmployee [id=" + id + ", compId=" + compId
				+ ", branchId=" + branchId + ", name=" + name + ", address="
				+ address + ", contactNo=" + contactNo + ", gender=" + gender
				+ ", isSysAcc=" + isSysAcc + ", salaryType=" + salaryType
				+ ", salary=" + salary + ", pan=" + pan + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", delFlg=" + delFlag
				/*+", email=" + email*/ 
				+ "]";
	}
	
	
	
	
	
	
}
