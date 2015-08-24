package com.admas.logiware.logic.masters;

import java.util.List;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface MastersLogic {

	public List<CityDto> getAllCity() throws LogiwareExceptionHandler;

	public Boolean addCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean editCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean deleteCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public List<CompanyDto> getAllcompany()throws LogiwareExceptionHandler;

	public Boolean deleteCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Boolean editCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Boolean addCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public CompanyDto getCompanyById(Integer companyId)throws LogiwareExceptionHandler;

	public CityDto getCityById(Integer cityId)throws LogiwareExceptionHandler;

	public List<EmployeeDto> getAllEmployee()throws LogiwareExceptionHandler;

	public EmployeeDto getEmployeeById(Integer employeeId)throws LogiwareExceptionHandler;

	public Boolean addEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean editEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean deleteEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;
}
