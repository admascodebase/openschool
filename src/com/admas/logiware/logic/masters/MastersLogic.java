package com.admas.logiware.logic.masters;

import java.util.List;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.SettingsDto;
import com.admas.logiware.dto.StateDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface MastersLogic {

	public List<CityDto> getAllCity() throws LogiwareExceptionHandler;

	public Boolean addCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean editCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean deleteCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public List<CompanyDto> getAllcompany()throws LogiwareExceptionHandler;

	public Boolean deleteCompany(Integer companyId)throws LogiwareExceptionHandler;

	public Boolean editCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Boolean addCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public CompanyDto getCompanyById(Integer companyId)throws LogiwareExceptionHandler;

	public CityDto getCityById(Integer cityId)throws LogiwareExceptionHandler;

	public List<EmployeeDto> getAllEmployee()throws LogiwareExceptionHandler;

	public EmployeeDto getEmployeeById(Integer employeeId)throws LogiwareExceptionHandler;

	public Boolean addEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean editEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean deleteEmployee(Integer employeeId)throws LogiwareExceptionHandler;

	public Boolean addTransportType(TransportTypeDto transportTypeDto) throws LogiwareExceptionHandler;

	public List<TransportTypeDto> getAllTransportType()throws LogiwareExceptionHandler;

	public TransportTypeDto getTransportTypeById(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	public Boolean editTransportType(TransportTypeDto traTypeDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransportType(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	//Start transport type details services
	
	public Boolean addTransportTypeDtl(TransportTypeDtlDto transportTypeDto) throws LogiwareExceptionHandler;

	public List<TransportTypeDtlDto> getAllTransportTypeDtl(Integer transportTypeId)throws LogiwareExceptionHandler;

	public TransportTypeDtlDto getTransportTypeDtlById(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	public Boolean editTransportTypeDtl(TransportTypeDtlDto traTypeDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransportTypeDtl(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	//End transport type detail services
	
	
	//Start branch details services
	
	public Boolean addBranch(CompanyBranchDto companyBranchDto) throws LogiwareExceptionHandler;

	public List<CompanyBranchDto> getAllBranch()throws LogiwareExceptionHandler;

	public CompanyBranchDto getBranchById(Integer compBranchId)throws LogiwareExceptionHandler;
		
	public Boolean editBranch(CompanyBranchDto comBranchDto)throws LogiwareExceptionHandler;

	public Boolean deleteBranch(Integer compBranchId)throws LogiwareExceptionHandler;
		
	//End branch services
	
	//start other services 
	
	public List<StateDto> getAllState()throws LogiwareExceptionHandler;
	
	public SettingsDto getSettingByType(Integer compId,String type)throws LogiwareExceptionHandler;
}
