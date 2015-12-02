package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.CompProductDao;
import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompProduct;

public class CompProductLogicImpl implements CompProductLogic {

	private static CompProductDao compProductDaoImpl;
	
	Logger logger = LoggerFactory.getLogger(CompProductLogicImpl.class);
	

	

	/**
	 * @return the compProductDaoImpl
	 */
	public static CompProductDao getCompProductDaoImpl() {
		return compProductDaoImpl;
	}

	/**
	 * @param compProductDaoImpl the compProductDaoImpl to set
	 */
	public static void setCompProductDaoImpl(CompProductDao compProductDaoImpl) {
		CompProductLogicImpl.compProductDaoImpl = compProductDaoImpl;
	}

	@Override
	public List<CompProductDto> getAllCompProduct(Integer contractCompId)
			throws LogiwareExceptionHandler {
		List<CompProduct> lCompProduct = null;
		List<CompProductDto> lCompProductDtos = new ArrayList<CompProductDto>();
		try {
			lCompProduct = compProductDaoImpl.getAllCompProduct(contractCompId);

			for (CompProduct compProduct : lCompProduct) {
				lCompProductDtos.add(compProduct._toDto());
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompProductLogicImpl - > getAllCompProduct ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lCompProductDtos;
	}

	@Override
	public CompProductDto getCompProductById(Integer id)
			throws LogiwareExceptionHandler {
		CompProduct compRoute = null;
		try {
			compRoute = compProductDaoImpl.getCompProductById(id);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompProductLogicImpl - > getCompProductById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return compRoute._toDto();
	}

	@Override
	public Boolean addCompProduct(CompProductDto compProductDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compProductDaoImpl.addCompProduct(compProductDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompProductLogicImpl - > addCompProduct ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editCompProduct(CompProductDto compProductDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compProductDaoImpl.editCompProduct(compProductDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompProductLogicImpl - > editCompProduct ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteCompProduct(Integer id) throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compProductDaoImpl.deleteCompProduct(id);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompProductLogicImpl - > deleteCompProduct ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

}