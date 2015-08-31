package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.CustContractCompany;


public interface ContractCompDao {
	public List<CustContractCompany> getAllContractComp()throws LogiwareExceptionHandler;

	public CustContractCompany getContractCompById(Integer contractCompId)throws LogiwareExceptionHandler;

	public Boolean addContractComp(ContractCompDto contractCompDto)throws LogiwareExceptionHandler;

	public Boolean editContractComp(ContractCompDto contractCompDto)throws LogiwareExceptionHandler;

	public Boolean deleteContractComp(Integer contractCompId)throws LogiwareExceptionHandler;
}
