package com.admas.logiware.dao.masters;

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
import com.admas.logiware.jpa.City;
import com.admas.logiware.jpa.Company;
import com.admas.logiware.jpa.CompanyBranch;
import com.admas.logiware.jpa.Employee;
import com.admas.logiware.jpa.Settings;
import com.admas.logiware.jpa.State;
import com.admas.logiware.jpa.TransportType;
import com.admas.logiware.jpa.TransportTypeDtl;

public interface MastersDao {

	
	public List<City> getAllCity() throws LogiwareExceptionHandler;

	public Boolean addCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean editCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean deleteCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public List<Company> getAllCompany()throws LogiwareExceptionHandler;

	public Boolean addcompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Boolean editCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompany(Integer companyId)throws LogiwareExceptionHandler;

	public Company getCompanyById(Integer companyId)throws LogiwareExceptionHandler;

	public City getCityById(Integer cityId)throws LogiwareExceptionHandler;

	public List<Employee> getAllEmployee()throws LogiwareExceptionHandler;

	public Employee getEmployeeById(Integer employeeId)throws LogiwareExceptionHandler;

	public Boolean addEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean editEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean deleteEmployee(Integer employeeId)throws LogiwareExceptionHandler;

	public Boolean addaddTransportType(TransportTypeDto transportTypeDto)throws LogiwareExceptionHandler;

	public List<TransportType> getAllTransportType()throws LogiwareExceptionHandler;

	public TransportType getTransportTypeById(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	public Boolean editTransportType(TransportTypeDto transportTypeDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransportType(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	//start transport type details dao 
	
	public Boolean addaddTransportTypeDtl(TransportTypeDtlDto transportTypeDto)throws LogiwareExceptionHandler;

	public List<TransportTypeDtl> getAllTransportTypeDtl()throws LogiwareExceptionHandler;

	public TransportTypeDtl getTransportTypeDtlById(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	public Boolean editTransportTypeDtl(TransportTypeDtlDto transportTypeDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransportTypeDtl(Integer transportTypeId)throws LogiwareExceptionHandler;
	
	//end transport type detail dao
	
	//start transport type details dao 
	
	public Boolean addBranch(CompanyBranchDto companyBranchDto)throws LogiwareExceptionHandler;

	public List<CompanyBranch> getAllBranch()throws LogiwareExceptionHandler;

	public CompanyBranch getBranchById(Integer companyBranchId)throws LogiwareExceptionHandler;
		
	public Boolean editBranch(CompanyBranchDto companyBranchDto)throws LogiwareExceptionHandler;

	public Boolean deleteBranch(Integer companyBranchId)throws LogiwareExceptionHandler;
		
		//end transport type detail dao
	
	public List<State> getAllState()throws LogiwareExceptionHandler;
	
	public Settings getSettingByType(Integer compId,String type)throws LogiwareExceptionHandler;
}
