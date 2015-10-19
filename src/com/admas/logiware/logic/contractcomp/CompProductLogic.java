package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;


public interface CompProductLogic {
	
	public List<CompProductDto> getAllCompProduct(Integer contractCompId)throws LogiwareExceptionHandler;

	public CompProductDto getCompRouteById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addCompRoute(CompProductDto compProductDto)throws LogiwareExceptionHandler;

	public Boolean editCompRoute(CompProductDto compProductDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompRoute(Integer id)throws LogiwareExceptionHandler;
}
