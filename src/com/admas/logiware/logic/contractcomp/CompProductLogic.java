package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;


public interface CompProductLogic {
	
	public List<CompProductDto> getAllCompProduct(Integer contractCompId)throws LogiwareExceptionHandler;

	public CompProductDto getCompProductById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addCompProduct(CompProductDto compProductDto)throws LogiwareExceptionHandler;

	public Boolean editCompProduct(CompProductDto compProductDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompProduct(Integer id)throws LogiwareExceptionHandler;
}
