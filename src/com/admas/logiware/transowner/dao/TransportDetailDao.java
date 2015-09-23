/**
 * 
 */
package com.admas.logiware.transowner.dao;

import java.util.List;

import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.TransportDetails;

/**
 * @author Raj
 *
 */
public interface TransportDetailDao {
	
	public Boolean addTransportDetail(TransportDetailsDto transportDetailsDto)throws LogiwareExceptionHandler;

	public List<TransportDetails> getAllTransportDetail(Integer transOwnerId)throws LogiwareExceptionHandler;

	public TransportDetails getTransportDetailById(Integer transportDetailsId)throws LogiwareExceptionHandler;
		
	public Boolean editTransportDetail(TransportDetailsDto  transportDetailsDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransportDetail(Integer  transportDetailsId)throws LogiwareExceptionHandler;
}
