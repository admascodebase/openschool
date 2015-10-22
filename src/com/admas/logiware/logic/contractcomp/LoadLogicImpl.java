package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.LoadDao;
import com.admas.logiware.dto.LoadDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.Load;

public class LoadLogicImpl implements LoadLogic{
	
	private static LoadDao loadDao;
	Logger logger = LoggerFactory.getLogger(ContractCompLogicImpl.class);
	public static LoadDao getLoadDao() {
		return loadDao;
	}
	public static void setContractCompDao(LoadDao loadDao) {
		LoadLogicImpl.loadDao = loadDao;
	}
	
	
	@Override
	public List<LoadDto> getAllLoadEntry(Integer contractCompId) throws LogiwareExceptionHandler {

		List<Load> lLoad = null;
		List<LoadDto> lLoadDto = new ArrayList<LoadDto>();
		try {
			lLoad = loadDao.getAllLoadEntry(contractCompId);

			for (Load load  : lLoad) {
				lLoadDto.add(load._toDto());
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompLogicImpl - > getAllContractComp ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lLoadDto;
	}

}
