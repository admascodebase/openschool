package com.admas.logiware.logic.contractcomp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.logiware.dao.contractcomp.RoutePaySettingDao;
import com.admas.logiware.dto.RoutePaySettingDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.exception.LogiwareServiceErrors;
import com.admas.logiware.jpa.RoutePaySetting;

public class RoutePaySettingLogicImpl implements RoutePaySettingLogic {

	private static RoutePaySettingDao routePaySettingDaoImpl;
	
	Logger logger = LoggerFactory.getLogger(RoutePaySettingLogicImpl.class);
	
	@Override
	public List<RoutePaySettingDto> getAllRoutePaySetting(Integer routeId)
			throws LogiwareExceptionHandler {
		List<RoutePaySetting> lRoutePaySetting = null;
		List<RoutePaySettingDto> lRoutePaySettingDto = new ArrayList<RoutePaySettingDto>();
		try {
			lRoutePaySetting = routePaySettingDaoImpl.getAllRoutePaySetting(routeId);

			for (RoutePaySetting routePaySetting : lRoutePaySetting) {
				lRoutePaySettingDto.add(routePaySetting._toDto());
			}

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in RoutePaySettingLogicImpl - > getAllRoutePaySetting ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return lRoutePaySettingDto;
	}

	@Override
	public RoutePaySettingDto getRoutePaySettingById(Integer id)
			throws LogiwareExceptionHandler {
		RoutePaySetting routePaySetting = null;
		try {
			routePaySetting = routePaySettingDaoImpl.getRoutePaySettingById(id);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error(
					"Exception Error in RoutePaySettingLogicImpl - > getRoutePaySettingById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return routePaySetting._toDto();
	}

	@Override
	public Boolean addRoutePaySetting(RoutePaySettingDto routePaySettingDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = routePaySettingDaoImpl.addRoutePaySetting(routePaySettingDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in RoutePaySettingLogicImpl - > getRoutePaySettingById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean editRoutePaySetting(RoutePaySettingDto routePaySettingDto)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = routePaySettingDaoImpl.editRoutePaySetting(routePaySettingDto);

		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in RoutePaySettingLogicImpl - > getRoutePaySettingById ", e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	@Override
	public Boolean deleteRoutePaySetting(Integer id)
			throws LogiwareExceptionHandler {
		Boolean result = false;
		try {
			result = routePaySettingDaoImpl.deleteRoutePaySetting(id);
		} catch (LogiwareExceptionHandler e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception Error in RoutePaySettingLogicImpl - > getRoutePaySettingById ",
					e);
			throw new LogiwareExceptionHandler(
					LogiwareServiceErrors.GENERIC_EXCEPTION);
		}
		return result;
	}

	/**
	 * @return the routePaySettingDaoImpl
	 */
	public static RoutePaySettingDao getRoutePaySettingDaoImpl() {
		return routePaySettingDaoImpl;
	}

	/**
	 * @param routePaySettingDaoImpl the routePaySettingDaoImpl to set
	 */
	public static void setRoutePaySettingDaoImpl(RoutePaySettingDao routePaySettingDaoImpl) {
		RoutePaySettingLogicImpl.routePaySettingDaoImpl = routePaySettingDaoImpl;
	}
	
}