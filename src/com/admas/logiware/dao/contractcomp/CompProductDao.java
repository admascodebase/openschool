package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.CompProduct;


public interface CompProductDao {
	
	public List<CompProduct> getAllCompProduct(Integer id)throws LogiwareExceptionHandler;

	public CompProduct getCompProductById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addCompProduct(CompProductDto companyProductDto)throws LogiwareExceptionHandler;

	public Boolean editCompProduct(CompProductDto companyProductDto)throws LogiwareExceptionHandler;

	public Boolean deleteCompProduct(Integer id)throws LogiwareExceptionHandler;
}
