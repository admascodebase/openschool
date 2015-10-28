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
	private RoutePaySettingDto routePaySettingDto;
//	private PaymentExceptionDto paymentExceptionDto;
	private TransportTypeDtlDto transportTypeDtlDto;
	private List<CityDto> lCityDto;
	private List<ContractCompDto> lContractCompDtos;
	private List<RoleDto> lRoles;
	private List<TransportTypeDto> lTransportTypeDtos;
	private List<LoweryOwnerDto> lLoweryOwnerDto;
	private List<TransportTypeDtlDto> lTransportTypeDtlDtos;
	private List<CompanyRouteDto> lCompanyRouteDto;
	private LoadDto loadDto;
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
/*	*//**
	 * @return the companyRouteDto
	 *//*
	public CompanyRouteDto getCompanyRouteDto() {
		return companyRouteDto;
	}
	*//**
	 * @param companyRouteDto the companyRouteDto to set
	 *//*
	public void setCompanyRouteDto(CompanyRouteDto companyRouteDto) {
		this.companyRouteDto = companyRouteDto;
	}
	/**
	 * @return the paymentExceptionDto
	 */
	/*public PaymentExceptionDto getPaymentExceptionDto() {
		return paymentExceptionDto;
	}
	*//**
	 * @param paymentExceptionDto the paymentExceptionDto to set
	 *//*
	public void setPaymentExceptionDto(PaymentExceptionDto paymentExceptionDto) {
		this.paymentExceptionDto = paymentExceptionDto;
	}*/
	/**
	 * @return the transportTypeDtlDto
	 */
	public TransportTypeDtlDto getTransportTypeDtlDto() {
		return transportTypeDtlDto;
	}
	/**
	 * @param transportTypeDtlDto the transportTypeDtlDto to set
	 */
	public void setTransportTypeDtlDto(TransportTypeDtlDto transportTypeDtlDto) {
		this.transportTypeDtlDto = transportTypeDtlDto;
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
	
	/**
	 * @return the lCityDto
	 */
	public List<CityDto> getlCityDto() {
		return lCityDto;
	}
	/**
	 * @param lCityDto the lCityDto to set
	 */
	public void setlCityDto(List<CityDto> lCityDto) {
		this.lCityDto = lCityDto;
	}
	/**
	 * @return the lContractCompDtos
	 */
	public List<ContractCompDto> getlContractCompDtos() {
		return lContractCompDtos;
	}
	/**
	 * @param lContractCompDtos the lContractCompDtos to set
	 */
	public void setlContractCompDtos(List<ContractCompDto> lContractCompDtos) {
		this.lContractCompDtos = lContractCompDtos;
	}
	/**
	 * @return the routePaySettingDto
	 */
	public RoutePaySettingDto getRoutePaySettingDto() {
		return routePaySettingDto;
	}
	/**
	 * @param routePaySettingDto the routePaySettingDto to set
	 */
	public void setRoutePaySettingDto(RoutePaySettingDto routePaySettingDto) {
		this.routePaySettingDto = routePaySettingDto;
	}
	/**
	 * @return the lRoles
	 */
	public List<RoleDto> getlRoles() {
		return lRoles;
	}
	/**
	 * @param lRoles the lRoles to set
	 */
	public void setlRoles(List<RoleDto> lRoles) {
		this.lRoles = lRoles;
	}
	/**
	 * @return the lTransportTypeDtos
	 */
	public List<TransportTypeDto> getlTransportTypeDtos() {
		return lTransportTypeDtos;
	}
	/**
	 * @param lTransportTypeDtos the lTransportTypeDtos to set
	 */
	public void setlTransportTypeDtos(List<TransportTypeDto> lTransportTypeDtos) {
		this.lTransportTypeDtos = lTransportTypeDtos;
	}
	/**
	 * @return the lLoweryOwnerDto
	 */
	public List<LoweryOwnerDto> getlLoweryOwnerDto() {
		return lLoweryOwnerDto;
	}
	/**
	 * @param lLoweryOwnerDto the lLoweryOwnerDto to set
	 */
	public void setlLoweryOwnerDto(List<LoweryOwnerDto> lLoweryOwnerDto) {
		this.lLoweryOwnerDto = lLoweryOwnerDto;
	}
	/**
	 * @return the lTransportTypeDtlDtos
	 */
	public List<TransportTypeDtlDto> getlTransportTypeDtlDtos() {
		return lTransportTypeDtlDtos;
	}
	/**
	 * @param lTransportTypeDtlDtos the lTransportTypeDtlDtos to set
	 */
	public void setlTransportTypeDtlDtos(List<TransportTypeDtlDto> lTransportTypeDtlDtos) {
		this.lTransportTypeDtlDtos = lTransportTypeDtlDtos;
	}
	/**
	 * @return the lCompanyRouteDto
	 */
	public List<CompanyRouteDto> getlCompanyRouteDto() {
		return lCompanyRouteDto;
	}
	/**
	 * @param lCompanyRouteDto the lCompanyRouteDto to set
	 */
	public void setlCompanyRouteDto(List<CompanyRouteDto> lCompanyRouteDto) {
		this.lCompanyRouteDto = lCompanyRouteDto;
	}
	/**
	 * @return the loadDto
	 */
	public LoadDto getLoadDto() {
		return loadDto;
	}
	/**
	 * @param loadDto the loadDto to set
	 */
	public void setLoadDto(LoadDto loadDto) {
		this.loadDto = loadDto;
	}
	
	
}
