package com.admas.logiware.transowner.logic;

import java.util.List;

import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface TransOwnerLogic {

	public List<LoweryOwnerDto> getAllEmployee()throws LogiwareExceptionHandler;

	public LoweryOwnerDto getTransOwnerById(Integer employeeId)throws LogiwareExceptionHandler;

	public Boolean addTransOwner(LoweryOwnerDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean editTransOwner(LoweryOwnerDto employeeDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransOwner(Integer employeeId)throws LogiwareExceptionHandler;
}
