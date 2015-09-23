package com.admas.logiware.transowner.logic;


import java.util.List;

import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

public class TransportDetailLogicImpl implements TransportDetailLogic{

	@Override
	public List<TransportDetailsDto> getAllTransportDetail()
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransportDetailsDto getTransportDetailById(Integer transOwnerId)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addTransportDetail(TransportDetailsDto transOwnerDto)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editTransportDetail(TransportDetailsDto transOwnerDto)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTransportDetail(Integer transOwnerId)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}/*

	private static TransportDetailsDto TransportDetailDao;
	
	Logger logger = LoggerFactory.getLogger(TransportDetailLogicImpl.class);
	
	
	
	@Override
	public List<TransportDetailsDto> getAllTransportDetail()
			throws LogiwareExceptionHandler {
		List<TransportDetails> lTranOwners = null;
		List<TransportDetailsDto> lTransportDetailsDtos = new ArrayList<TransportDetailsDto>();
		try {
			lTranOwners = TransportDetailDao.getAllTransportDetail();
			for (TransportDetails TransportDetails : lTranOwners) {
				lTransportDetailsDtos.add(TransportDetails.to_Dto());
			}
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransportDetailLogicImpl - > getAllTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lTransportDetailsDtos;
	}

	@Override
	public TransportDetailsDto getTransportDetailById(Integer TransportDetailId)
			throws LogiwareExceptionHandler {
		LoweryOwner loweryOwner = null;
		try {
			loweryOwner = TransportDetailDao.getTransportDetailById(TransportDetailId);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in TransportDetailLogicImpl - > getTransportDetailById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return loweryOwner._toDto();
	}

	@Override
	public Boolean addTransportDetail(TransportDetailsDto TransportDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = TransportDetailDao.addTransportDetail(TransportDetailDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransportDetailLogicImpl - > addTransportDetail ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editTransportDetail(TransportDetailsDto TransportDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = TransportDetailDao.editTransportDetail(TransportDetailDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransportDetailLogicImpl - > editTransportDetail ", e);
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
			result = TransportDetailDao.deleteTransportDetail(TransportDetailId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in TransportDetailLogicImpl - > deleteTransportDetail ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
*/}
