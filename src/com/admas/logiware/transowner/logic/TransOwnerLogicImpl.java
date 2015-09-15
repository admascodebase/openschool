package com.admas.logiware.transowner.logic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.LoweryOwner;
import com.admas.logiware.transowner.dao.TransOwnerDao;

public class TransOwnerLogicImpl implements TransOwnerLogic{

	private static TransOwnerDao transOwnerDao;
	
	Logger logger = LoggerFactory.getLogger(TransOwnerLogicImpl.class);
	
	
	
	@Override
	public List<LoweryOwnerDto> getAllTransOwner()
			throws LogiwareExceptionHandler {
		List<LoweryOwner> lTranOwners = null;
		List<LoweryOwnerDto> lTransOwnersDtos = new ArrayList<LoweryOwnerDto>();
		try {
			lTranOwners = transOwnerDao.getAllTransOwner();
			for (LoweryOwner transOwners : lTranOwners) {
				lTransOwnersDtos.add(transOwners._toDto());
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransOwnerLogicImpl - > getAllTransOwner ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lTransOwnersDtos;
	}

	@Override
	public LoweryOwnerDto getTransOwnerById(Integer transOwnerId)
			throws LogiwareExceptionHandler {
		LoweryOwner loweryOwner = null;
		try {
			loweryOwner = transOwnerDao.getTransOwnerById(transOwnerId);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransOwnerLogicImpl - > getTransOwnerById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return loweryOwner._toDto();
	}

	@Override
	public Boolean addTransOwner(LoweryOwnerDto transOwnerDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = transOwnerDao.addTransOwner(transOwnerDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransOwnerLogicImpl - > addTransOwner ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editTransOwner(LoweryOwnerDto transOwnerDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = transOwnerDao.editTransOwner(transOwnerDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransOwnerLogicImpl - > editTransOwner ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteTransOwner(Integer transOwnerId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = transOwnerDao.deleteTransOwner(transOwnerId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransOwnerLogicImpl - > deleteTransOwner ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	/**
	 * @return the transOwnerDao
	 */
	public static TransOwnerDao getTransOwnerDao() {
		return transOwnerDao;
	}

	/**
	 * @param transOwnerDao the transOwnerDao to set
	 */
	public static void setTransOwnerDao(TransOwnerDao transOwnerDao) {
		TransOwnerLogicImpl.transOwnerDao = transOwnerDao;
	}

	

}
