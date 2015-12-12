package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompanyLoadToTransDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.CompanyLoadToTrans;


public interface CompLoadToTransDao {
	
	public List<CompanyLoadToTrans> getAllCompLoadtoTrans(Integer id)throws LogiwareExceptionHandler;

	public CompanyLoadToTrans getCompLoadtoTransById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addCompLoadtoTrans(CompanyLoadToTransDto companyLoadToTransDto)throws LogiwareExceptionHandler;

	public Boolean editCompLoadtoTrans(CompanyLoadToTransDto companyLoadToTransDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompLoadtoTrans(Integer id)throws LogiwareExceptionHandler;
}
