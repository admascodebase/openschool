package com.admas.logiware.dto;

import com.admas.logiware.dao.UserDetails;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface IUserManagementDao {

	public UserDetails login(String userName , String password) throws LogiwareExceptionHandler;
}
