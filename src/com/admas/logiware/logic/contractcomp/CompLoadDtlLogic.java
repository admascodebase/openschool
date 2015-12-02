package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompanyLoadDetailDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface CompLoadDtlLogic {

	public List<CompanyLoadDetailDto> getAllCompLoadDtl(Integer contractCompId)throws LogiwareExceptionHandler;

	public CompanyLoadDetailDto getCompLoadDtlById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addCompLoadDtl(CompanyLoadDetailDto companyLoadDetailDto)throws LogiwareExceptionHandler;

	public Boolean editCompLoadDtl(CompanyLoadDetailDto companyLoadDetailDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompLoadDtl(Integer id)throws LogiwareExceptionHandler;

}
