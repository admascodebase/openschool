package com.admas.logiware.transowner.logic;

import java.util.List;

import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface TransportDetailLogic {

	public List<TransportDetailsDto> getAllTransportDetail(Integer transportDetailsId)throws LogiwareExceptionHandler;

	public TransportDetailsDto getTransportDetailById(Integer transportDetailsId)throws LogiwareExceptionHandler;

	public Boolean addTransportDetail(TransportDetailsDto transportDetailsDto)throws LogiwareExceptionHandler;

	public Boolean editTransportDetail(TransportDetailsDto transportDetailsDto)throws LogiwareExceptionHandler;

	public Boolean deleteTransportDetail(Integer transportDetailsId)throws LogiwareExceptionHandler;
}
