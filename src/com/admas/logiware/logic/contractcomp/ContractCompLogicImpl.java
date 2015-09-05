package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.ContractCompDao;
import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CustContractCompany;

public class ContractCompLogicImpl implements ContractCompLogic {

	private static ContractCompDao contractCompDao;
	Logger logger = LoggerFactory.getLogger(ContractCompLogicImpl.class);
	public static ContractCompDao getContractCompDao() {
		return contractCompDao;
	}
	public static void setContractCompDao(ContractCompDao contractCompDao) {
		ContractCompLogicImpl.contractCompDao = contractCompDao;
	}
	@Override
	public List<ContractCompDto> getAllContractComp()
			throws LogiwareExceptionHandler {
		List<CustContractCompany> lContractcompany = null;
		List<ContractCompDto> lContractCompDtos = new ArrayList<ContractCompDto>();
		try {
			lContractcompany = contractCompDao.getAllContractComp();

			for (CustContractCompany contractcompany : lContractcompany) {
				lContractCompDtos.add(contractcompany._toDto());
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
		return lContractCompDtos;
	}
	@Override
	public ContractCompDto getContractCompById(Integer contractCompId)
			throws LogiwareExceptionHandler {
		CustContractCompany contractcompany = null;
		try {
			contractcompany = contractCompDao.getContractCompById(contractCompId);			

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in ContractCompLogicImpl - > getContractCompById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return contractcompany._toDto();
	}
	@Override
	public Boolean addContractComp(ContractCompDto contractCompDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = contractCompDao.addContractComp(contractCompDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in ContractCompLogicImpl - > addContractComp ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	@Override
	public Boolean editContractComp(ContractCompDto contractCompDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = contractCompDao.editContractComp(contractCompDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in ContractCompLogicImpl - > editEmployee ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}
	@Override
	public Boolean deleteContractComp(Integer contractCompId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = contractCompDao.deleteContractComp(contractCompId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in ContractCompLogicImpl - > deleteContractComp ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	
}