package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.Load;

public interface LoadDao {

	List<Load> getAllLoadEntry(Integer contractCompId)throws LogiwareExceptionHandler;

}
