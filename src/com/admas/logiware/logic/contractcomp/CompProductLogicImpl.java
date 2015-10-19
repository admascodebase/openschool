package com.admas.logiware.logic.contractcomp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.CompProductDao;
import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompProductDto getCompRouteById(Integer id)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addCompRoute(CompProductDto compProductDto)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editCompRoute(CompProductDto compProductDto)
			throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteCompRoute(Integer id) throws LogiwareExceptionHandler {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<CompProductDto> getAllCompProduct(Integer contractCompId)
			throws LogiwareExceptionHandler {
		List<CompProduct> lCompRoute = null;
		List<CompProductDto> lContractCompDtos = new ArrayList<CompProductDto>();
		try {
			lCompRoute = compProductDaoImpl.getAllCompRoute(contractCompId);

			for (CompanyRoute compRoute : lCompRoute) {
				lContractCompDtos.add(compRoute._toDto());
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompRouteLogicImpl - > getAllCompRoute ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lContractCompDtos;
	}

	@Override
	public CompanyRouteDto getCompRouteById(Integer comprouteId)
			throws LogiwareExceptionHandler {
		CompanyRoute compRoute = null;
		try {
			compRoute = compProductDaoImpl.getCompRouteById(comprouteId);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in CompRouteLogicImpl - > getCompRouteById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return compRoute._toDto();
	}

	@Override
	public Boolean addCompRoute(CompanyRouteDto companyRouteDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compProductDaoImpl.addCompRoute(companyRouteDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompRouteLogicImpl - > addCompRoute ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editCompRoute(CompanyRouteDto companyRouteDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compProductDaoImpl.editCompRoute(companyRouteDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompRouteLogicImpl - > editCompRoute ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteCompRoute(Integer comprouteId)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = compProductDaoImpl.deleteCompRoute(comprouteId);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in CompRouteLogicImpl - > deleteCompRoute ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}	
*/	
}