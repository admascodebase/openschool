package com.admas.logiware.dao.masters;

import java.util.List;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.City;
import com.admas.logiware.jpa.Company;
import com.admas.logiware.jpa.Employee;

public interface MastersDao {

	
	public List<City> getAllCity() throws LogiwareExceptionHandler;

	public Boolean addCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean editCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean deleteCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public List<Company> getAllCompany()throws LogiwareExceptionHandler;

	public Boolean addcompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Boolean editCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompany(CompanyDto companyDto)throws LogiwareExceptionHandler;

	public Company getCompanyById(Integer companyId)throws LogiwareExceptionHandler;

	public City getCityById(Integer cityId)throws LogiwareExceptionHandler;

	public List<Employee> getAllEmployee()throws LogiwareExceptionHandler;

	public Employee getEmployeeById(Integer employeeId)throws LogiwareExceptionHandler;

	public Boolean addEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean editEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean deleteEmployee(EmployeeDto employeeDto)throws LogiwareExceptionHandler;
}
