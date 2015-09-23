package com.admas.logiware.dto;

import java.io.Serializable;
import java.util.List;

public class LogiwareRespnse implements Serializable{
	
	private static final long serialVersionUID = 1844938595735409209L;
	private String code;
	private String description;
	private Object data;
	private EmployeeDto employeeDto;
	private ContractCompDto contractCompDto;
	private UserDetails uerDetailsDto;
	private TransportTypeDto transportTypeDto;
	private CompanyDto companyDto;
	private CompanyBranchDto companyBranchDto;
	private SettingsDto settingDto;
	private CityDto cityDto;
	private LoweryOwnerDto loweryOwnerDto;
	private List<StateDto> lStateDto;
	private TransportDetailsDto transportDetailsDto;
	private CompanyRouteDto companyRouteDto;
	
	
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
	/**
	 * @return the transportTypeDto
	 */
	public TransportTypeDto getTransportTypeDto() {
		return transportTypeDto;
	}
	/**
	 * @param transportTypeDto the transportTypeDto to set
	 */
	public void setTransportTypeDto(TransportTypeDto transportTypeDto) {
		this.transportTypeDto = transportTypeDto;
	}
	public CompanyDto getCompanyDto() {
		return companyDto;
	}
	public void setCompanyDto(CompanyDto companyDto) {
		this.companyDto = companyDto;
	}
	public CompanyBranchDto getCompanyBranchDto() {
		return companyBranchDto;
	}
	public void setCompanyBranchDto(CompanyBranchDto companyBranchDto) {
		this.companyBranchDto = companyBranchDto;
	}
	
	
	/**
	 * @return the settingDto
	 */
	public SettingsDto getSettingDto() {
		return settingDto;
	}
	/**
	 * @param settingDto the settingDto to set
	 */
	public void setSettingDto(SettingsDto settingDto) {
		this.settingDto = settingDto;
	}
	/**
	 * @return the cityDto
	 */
	public CityDto getCityDto() {
		return cityDto;
	}
	/**
	 * @param cityDto the cityDto to set
	 */
	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}
	
	/**
	 * @return the lStateDto
	 */
	public List<StateDto> getlStateDto() {
		return lStateDto;
	}
	/**
	 * @param lStateDto the lStateDto to set
	 */
	public void setlStateDto(List<StateDto> lStateDto) {
		this.lStateDto = lStateDto;
	}
	/**
	 * @return the loweryOwnerDto
	 */
	public LoweryOwnerDto getLoweryOwnerDto() {
		return loweryOwnerDto;
	}
	/**
	 * @param loweryOwnerDto the loweryOwnerDto to set
	 */
	public void setLoweryOwnerDto(LoweryOwnerDto loweryOwnerDto) {
		this.loweryOwnerDto = loweryOwnerDto;
	}
	/**
	 * @return the transportDetailsDto
	 */
	public TransportDetailsDto getTransportDetailsDto() {
		return transportDetailsDto;
	}
	/**
	 * @param transportDetailsDto the transportDetailsDto to set
	 */
	public void setTransportDetailsDto(TransportDetailsDto transportDetailsDto) {
		this.transportDetailsDto = transportDetailsDto;
	}
	/**
	 * @return the companyRouteDto
	 */
	public CompanyRouteDto getCompanyRouteDto() {
		return companyRouteDto;
	}
	/**
	 * @param companyRouteDto the companyRouteDto to set
	 */
	public void setCompanyRouteDto(CompanyRouteDto companyRouteDto) {
		this.companyRouteDto = companyRouteDto;
	}
	
	
}
