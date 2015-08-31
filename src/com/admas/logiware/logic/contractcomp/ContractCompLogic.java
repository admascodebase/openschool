package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;


public interface ContractCompLogic {

	public List<ContractCompDto> getAllContractComp()throws LogiwareExceptionHandler;

	public ContractCompDto getContractCompById(Integer contractCompId)throws LogiwareExceptionHandler;

	public Boolean addContractComp(ContractCompDto contractCompDto)throws LogiwareExceptionHandler;

	public Boolean editContractComp(ContractCompDto contractCompDto)throws LogiwareExceptionHandler;

	public Boolean deleteContractComp(Integer contractCompId)throws LogiwareExceptionHandler;
}
