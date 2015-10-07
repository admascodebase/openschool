package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.CompanyRoute;


public interface CompRouteDao {
	
	public List<CompanyRoute> getAllCompRoute(Integer contractCompId)throws LogiwareExceptionHandler;

	public CompanyRoute getCompRouteById(Integer comprouteId)throws LogiwareExceptionHandler;

	public Boolean addCompRoute(CompanyRouteDto companyRouteDto)throws LogiwareExceptionHandler;

	public Boolean editCompRoute(CompanyRouteDto companyRouteDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompRoute(Integer comprouteId)throws LogiwareExceptionHandler;
}
