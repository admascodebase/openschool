package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;


public interface CompRouteLogic {
	
	public List<CompanyRouteDto> getAllCompRoute(Integer contractCompId)throws LogiwareExceptionHandler;

	public CompanyRouteDto getCompRouteById(Integer comprouteId)throws LogiwareExceptionHandler;

	public Boolean addCompRoute(CompanyRouteDto companyRouteDto)throws LogiwareExceptionHandler;

	public Boolean editCompRoute(CompanyRouteDto companyRouteDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompRoute(Integer comprouteId)throws LogiwareExceptionHandler;
}
