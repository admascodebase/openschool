package com.admas.logiware.transowner.logic;

import java.util.List;

import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface TransOwnerLogic {

	public List<LoweryOwnerDto> getAllTransOwner()throws LogiwareExceptionHandler;

	public LoweryOwnerDto getTransOwnerById(Integer transOwnerId)throws LogiwareExceptionHandler;

	public Boolean addTransOwner(LoweryOwnerDto transOwnerDto)throws LogiwareExceptionHandler;

	public Boolean editTransOwner(LoweryOwnerDto transOwnerDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransOwner(Integer transOwnerId)throws LogiwareExceptionHandler;
}
