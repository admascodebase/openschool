package com.admas.logiware.dto;

import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface IUserManagementDao {

	public Boolean login(String userName , String password) throws LogiwareExceptionHandler;
}
