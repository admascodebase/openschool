package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.LoadDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public interface LoadLogic {

	List<LoadDto> getAllLoadEntry(Integer contractCompId)throws LogiwareExceptionHandler;

}
