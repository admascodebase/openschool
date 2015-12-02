package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.ContractCompLoadDao;
import com.admas.logiware.dto.CompanyLoadDetailDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompProduct;
import com.admas.logiware.jpa.CompanyLoadDetail;

public class CompLoadDtlLogicImpl implements CompLoadDtlLogic{
	
	private static ContractCompLoadDao contractCompLoadDaoImpl;
	Logger logger = LoggerFactory.getLogger(ContractCompLogicImpl.class);
	
	
	
	public static ContractCompLoadDao getContractCompLoadDaoImpl() {
		return contractCompLoadDaoImpl;
	}
	public static void setContractCompLoadDaoImpl(
			ContractCompLoadDao contractCompLoadDaoImpl) {
		CompLoadDtlLogicImpl.contractCompLoadDaoImpl = contractCompLoadDaoImpl;
	}
	
	@Override
	public List<CompanyLoadDetailDto> getAllCompLoadDtl(Integer contractCompId)
			throws LogiwareExceptionHandler {
		List<CompanyLoadDetail> lCompLoadDtl = null;
		List<CompanyLoadDetailDto> lCompLoadDtlDtos = new ArrayList<CompanyLoadDetailDto>();
		try {
			lCompLoadDtl = contractCompLoadDaoImpl.getAllContractCompLoadDetails(contractCompId);

			for (CompanyLoadDetail compProduct : lCompLoadDtl) {
				lCompLoadDtlDtos.add(compProduct._toDto());
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompLoadDtlLogicImpl - > getAllCompLoadDtl ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lCompLoadDtlDtos;
	}
	@Override
	public CompanyLoadDetailDto getCompLoadDtlById(Integer id)
			throws LogiwareExceptionHandler {
		CompanyLoadDetail companyLoadDetail = null;
		try {
			companyLoadDetail = contractCompLoadDaoImpl.getContractCompLoadDetailsById(id);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompLoadDtlLogicImpl - > CompanyLoadDetailDto ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return companyLoadDetail._toDto();
	}
	@Override
	public Boolean addCompLoadDtl(CompanyLoadDetailDto companyLoadDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = contractCompLoadDaoImpl.addContractCompLoadDetails(companyLoadDetailDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompLoadDtlLogicImpl - > addCompLoadDtl ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	@Override
	public Boolean editCompLoadDtl(CompanyLoadDetailDto companyLoadDetailDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = contractCompLoadDaoImpl.editContractCompLoadDetails(companyLoadDetailDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompLoadDtlLogicImpl - > editCompLoadDtl ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	@Override
	public Boolean deleteCompLoadDtl(Integer id)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = contractCompLoadDaoImpl.deleteContractCompLoadDetails(id);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompLoadDtlLogicImpl - > deleteCompLoadDtl ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	
	
}
