package com.admas.logiware.transowner.logic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.TransportDetails;
import com.admas.logiware.transowner.dao.TransportDetailDao;

public class TransportDetailLogicImpl implements TransportDetailLogic {

	private static TransportDetailDao transportDetailDao;

	Logger logger = LoggerFactory.getLogger(TransportDetailLogicImpl.class);
	

	/**
	 * @return the transportDetailDao
	 */
	public static TransportDetailDao getTransportDetailDao() {
		return transportDetailDao;
	}

	/**
	 * @param transportDetailDao the transportDetailDao to set
	 */
	public static void setTransportDetailDao(TransportDetailDao transportDetailDao) {
		TransportDetailLogicImpl.transportDetailDao = transportDetailDao;
	}

	@Override
	public List<TransportDetailsDto> getAllTransportDetail(Integer transportDetailsId)
			throws LogiwareExceptionHandler {
		List<TransportDetails> transportDetails = null;
		List<TransportDetailsDto> lTransportDetailsDtos = new ArrayList<TransportDetailsDto>();
		try {
			transportDetails = transportDetailDao
					.getAllTransportDetail(transportDetailsId);
			for (TransportDetails TransportDetails : transportDetails) {
				lTransportDetailsDtos.add(TransportDetails._toDto());
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailLogicImpl - > getAllTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lTransportDetailsDtos;
	}

	@Override
	public TransportDetailsDto getTransportDetailById(Integer transportDetailId)
			throws LogiwareExceptionHandler {
		TransportDetails loweryOwner = null;
		try {
			loweryOwner = transportDetailDao
					.getTransportDetailById(transportDetailId);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailLogicImpl - > getTransportDetailById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return loweryOwner._toDto();
	}

	@Override
	public Boolean addTransportDetail(TransportDetailsDto transportDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = transportDetailDao.addTransportDetail(transportDetailDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailLogicImpl - > addTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editTransportDetail(TransportDetailsDto transportDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = transportDetailDao.editTransportDetail(transportDetailDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailLogicImpl - > editTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteTransportDetail(Integer TransportDetailId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = transportDetailDao
					.deleteTransportDetail(TransportDetailId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailLogicImpl - > deleteTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
}
