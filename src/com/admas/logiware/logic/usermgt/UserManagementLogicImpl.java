package com.admas.logiware.logic.usermgt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.admas.logiware.dao.usermgt.IUserManagementDao;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.UserDetails;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.Employee;

@Repository
public class UserManagementLogicImpl implements IUserManagementLogic {

	private static IUserManagementDao userManagementDao;
	
	Logger logger = LoggerFactory.getLogger(UserManagementLogicImpl.class);
	
	@Override
	public UserDetails login(String userName, String password) throws LogiwareExceptionHandler {
		com.admas.logiware.jpa.UserDetails userDetailsJpa = null;
		com.admas.logiware.dto.UserDetails userDetailsDto = null;
		Employee companyEmployee = null;
		try {			
			userDetailsJpa= userManagementDao.login(userName, password);
			if(userDetailsJpa!=null){
				logger.info("User authenticated sucessfully");
				companyEmployee = userManagementDao.getEmployeeById(userDetailsJpa.getEmpId());
				if(companyEmployee != null){
					EmployeeDto employeeDto = new EmployeeDto();
					employeeDto.setAddress(companyEmployee.getAddress());
					employeeDto.setBranchId(companyEmployee.getBranchId());
					employeeDto.setCompId(companyEmployee.getCompId());
					employeeDto.setContactNo(companyEmployee.getContactNo());
					employeeDto.setGender(companyEmployee.getGender());
					employeeDto.setId(companyEmployee.getId());
					employeeDto.setIsSysAcc(companyEmployee.getIsSysAcc());
					employeeDto.setName(companyEmployee.getName());
					employeeDto.setPan(companyEmployee.getPan());
					employeeDto.setSalary(companyEmployee.getSalary());
					employeeDto.setSalaryType(companyEmployee.getSalaryType());

					userDetailsDto = new com.admas.logiware.dto.UserDetails();
					userDetailsDto.setCustCompEmployee(employeeDto);
					userDetailsDto.setLastLogin(userDetailsJpa.getLastLoginTime());
					userDetailsDto.setPassword(userDetailsJpa.getPasword());
					userDetailsDto.setUserName(userDetailsJpa.getUserName());
					logger.info("User converted to dto sucessfully");
				}
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		}catch (Exception e) {
			logger.error("Exception Error in UserManagementLogicImpl - > login ",e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return userDetailsDto;
	}

	/**
	 * @return the userManagementDao
	 */
	public static IUserManagementDao getUserManagementDao() {
		return userManagementDao;
	}

	/**
	 * @param userManagementDao the userManagementDao to set
	 */
	public static void setUserManagementDao(IUserManagementDao userManagementDao) {
		UserManagementLogicImpl.userManagementDao = userManagementDao;
	}

	

	@Override
	public boolean addUser(UserDetails userDetails)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return false;
	}
	
}
