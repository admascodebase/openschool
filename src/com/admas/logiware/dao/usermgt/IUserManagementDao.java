package com.admas.logiware.dao.usermgt;

import com.admas.logiware.jpa.Employee;
import com.admas.logiware.jpa.UserDetails;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface IUserManagementDao {

	public UserDetails login(String userName , String password) throws LogiwareExceptionHandler;
	
	public Employee getEmployeeById(Integer empId) throws LogiwareExceptionHandler;
}
