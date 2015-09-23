package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.CompRouteDao;
import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.CompanyRoute;

public class CompRouteLogicImpl implements CompRouteLogic {

	private static CompRouteDao compRouteDaoImpl;
	
	Logger logger = LoggerFactory.getLogger(CompRouteLogicImpl.class);
	

	/**
	 * @return the compRouteDaoImpl
	 */
	public static CompRouteDao getCompRouteDaoImpl() {
		return compRouteDaoImpl;
	}

	/**
	 * @param compRouteDaoImpl the compRouteDaoImpl to set
	 */
	public static void setCompRouteDaoImpl(CompRouteDao compRouteDaoImpl) {
		CompRouteLogicImpl.compRouteDaoImpl = compRouteDaoImpl;
	}

	@Override
	public List<CompanyRouteDto> getAllCompRoute()
			throws LogiwareExceptionHandler {
		List<CompanyRoute> lCompRoute = null;
		List<CompanyRouteDto> lContractCompDtos = new ArrayList<CompanyRouteDto>();
		try {
			lCompRoute = compRouteDaoImpl.getAllCompRoute();

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
			compRoute = compRouteDaoImpl.getCompRouteById(comprouteId);

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
			result = compRouteDaoImpl.addCompRoute(companyRouteDto);

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
			result = compRouteDaoImpl.editCompRoute(companyRouteDto);

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
			result = compRouteDaoImpl.deleteCompRoute(comprouteId);
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
	
}