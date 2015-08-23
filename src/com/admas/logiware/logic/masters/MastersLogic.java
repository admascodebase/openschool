package com.admas.logiware.logic.masters;

import java.util.List;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface MastersLogic {

	public List<CityDto> getAllCity() throws LogiwareExceptionHandler;

	public Boolean addCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean editCity(CityDto cityDto)throws LogiwareExceptionHandler;

	public Boolean deleteCity(CityDto cityDto)throws LogiwareExceptionHandler;
}
