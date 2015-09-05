package com.admas.logiware.dto;

import java.io.Serializable;

public class LogiwareRespnse implements Serializable{
	
	private static final long serialVersionUID = 1844938595735409209L;
	private String code;
	private String description;
	private Object data;
	private EmployeeDto employeeDto;
	private ContractCompDto contractCompDto;
	private UserDetails uerDetailsDto;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the employeeDto
	 */
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
	/**
	 * @param employeeDto the employeeDto to set
	 */
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	public ContractCompDto getContractCompDto() {
		return contractCompDto;
	}
	public void setContractCompDto(ContractCompDto contractCompDto) {
		this.contractCompDto = contractCompDto;
	}

	/**
	 * @return the uerDetailsDto
	 */
	public UserDetails getUerDetailsDto() {
		return uerDetailsDto;
	}
	/**
	 * @param uerDetailsDto the uerDetailsDto to set
	 */
	public void setUerDetailsDto(UserDetails uerDetailsDto) {
		this.uerDetailsDto = uerDetailsDto;
	}
}
