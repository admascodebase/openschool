package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.CompLoadToTransDao;
import com.admas.logiware.dto.CompanyLoadToTransDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompanyLoadToTrans;

public class CompLoadToTransLogicImpl implements CompLoadToTransLogic{
	
	private static CompLoadToTransDao compLoadToTransDaoImpl;
	Logger logger = LoggerFactory.getLogger(ContractCompLogicImpl.class);
	/**
	 * @return the compLoadToTransDaoImpl
	 */
	public static CompLoadToTransDao getCompLoadToTransDaoImpl() {
		return compLoadToTransDaoImpl;
	}
	/**
	 * @param compLoadToTransDaoImpl the compLoadToTransDaoImpl to set
	 */
	public static void setCompLoadToTransDaoImpl(CompLoadToTransDao compLoadToTransDaoImpl) {
		CompLoadToTransLogicImpl.compLoadToTransDaoImpl = compLoadToTransDaoImpl;
	}
	
	
	@Override
	public List<CompanyLoadToTransDto> getAllCompLoadToTrans()
			throws LogiwareExceptionHandler {
		List<CompanyLoadToTrans> lCompLoadToTrans = null;
		List<CompanyLoadToTransDto> lCompLoadDtlDtos = new ArrayList<CompanyLoadToTransDto>();
		try {
			lCompLoadToTrans = compLoadToTransDaoImpl.getAllCompLoadtoTrans();

			for (CompanyLoadToTrans companyLoadToTrans : lCompLoadToTrans) {
				lCompLoadDtlDtos.add(companyLoadToTrans._toDto());
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompLoadToTransLogicImpl - > getAllCompLoadToTrans ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lCompLoadDtlDtos;
	}
	
	@Override
	public CompanyLoadToTransDto getCompLoadToTransById(Integer id)
			throws LogiwareExceptionHandler {
		CompanyLoadToTrans companyLoadToTrans = null;
		try {
			companyLoadToTrans = compLoadToTransDaoImpl.getCompLoadtoTransById(id);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompLoadToTransLogicImpl - > getCompLoadToTransById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return companyLoadToTrans._toDto();
	}
	@Override
	public Boolean addCompLoadToTrans(
			CompanyLoadToTransDto companyLoadToTransDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compLoadToTransDaoImpl.addCompLoadtoTrans(companyLoadToTransDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompLoadToTransLogicImpl - > addCompLoadtoTrans ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	@Override
	public Boolean editCompLoadToTrans(
			CompanyLoadToTransDto companyLoadToTransDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compLoadToTransDaoImpl.editCompLoadtoTrans(companyLoadToTransDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompLoadToTransLogicImpl - > editCompLoadtoTrans ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	@Override
	public Boolean deleteCompLoadToTrans(Integer id)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compLoadToTransDaoImpl.deleteCompLoadtoTrans(id);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompLoadToTransLogicImpl - > deleteCompLoadToTrans ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	
		
}
