package com.admas.logiware.dao.masters;

import java.util.List;

import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.City;

public interface MastersDao {

	
	public List<City> getAllCity() throws LogiwareExceptionHandler;
}
