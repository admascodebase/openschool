package com.admas.logiware.transowner.logic;

import java.util.List;

import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface TransportDetailLogic {

	public List<TransportDetailsDto> getAllTransportDetail()throws LogiwareExceptionHandler;

	public TransportDetailsDto getTransportDetailById(Integer transOwnerId)throws LogiwareExceptionHandler;

	public Boolean addTransportDetail(TransportDetailsDto transOwnerDto)throws LogiwareExceptionHandler;

	public Boolean editTransportDetail(TransportDetailsDto transOwnerDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransportDetail(Integer transOwnerId)throws LogiwareExceptionHandler;
}
