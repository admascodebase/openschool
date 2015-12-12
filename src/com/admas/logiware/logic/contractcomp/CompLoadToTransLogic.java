package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompanyLoadToTransDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface CompLoadToTransLogic {

	public List<CompanyLoadToTransDto> getAllCompLoadToTrans(Integer id)throws LogiwareExceptionHandler;

	public CompanyLoadToTransDto getCompLoadToTransById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addCompLoadToTrans(CompanyLoadToTransDto companyLoadToTransDto)throws LogiwareExceptionHandler;

	public Boolean editCompLoadToTrans(CompanyLoadToTransDto companyLoadToTransDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompLoadToTrans(Integer id)throws LogiwareExceptionHandler;

}
