package com.admas.logiware.logic.masters;

import java.util.List;

import com.admas.logiware.dto.CityDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface MastersLogic {

	public List<CityDto> getAllCity() throws LogiwareExceptionHandler;

}
