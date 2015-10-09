package com.admas.logiware.logic.usermgt;

import com.admas.logiware.dto.UserDetails;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface IUserManagementLogic {

	public UserDetails login(String userName , String password) throws LogiwareExceptionHandler;
	
	public boolean addUser(UserDetails userDetails) throws LogiwareExceptionHandler;
	
}
