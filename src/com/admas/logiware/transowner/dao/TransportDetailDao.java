/**
 * 
 */
package com.admas.logiware.transowner.dao;

import java.util.List;

import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.LoweryOwner;

/**
 * @author Raj
 *
 */
public interface TransportDetailDao {
	
	public Boolean addTransOwner(LoweryOwnerDto loweryOwnerDto)throws LogiwareExceptionHandler;

	public List<LoweryOwner> getAllTransOwner()throws LogiwareExceptionHandler;

	public LoweryOwner getTransOwnerById(Integer loweryOwnerId)throws LogiwareExceptionHandler;
		
	public Boolean editTransOwner(LoweryOwnerDto loweryOwnerDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransOwner(Integer loweryOwnerId)throws LogiwareExceptionHandler;
}
