package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompanyLoadDetailDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.CompanyLoadDetail;

public interface ContractCompLoadDao {
	
	public List<CompanyLoadDetail> getAllContractCompLoadDetails(Integer contractCompId)throws LogiwareExceptionHandler;

	public CompanyLoadDetail getContractCompLoadDetailsById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addContractCompLoadDetails(CompanyLoadDetailDto companyLoadDetailDto)throws LogiwareExceptionHandler;

	public Boolean editContractCompLoadDetails(CompanyLoadDetailDto companyLoadDetailDto)throws LogiwareExceptionHandler;

	public Boolean deleteContractCompLoadDetails(Integer id)throws LogiwareExceptionHandler;


}
