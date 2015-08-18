package com.admas.logiware.usrmgt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.logiware.client.ServiceEndPointConstants.ServiceName;
import com.admas.logiware.client.ServiceInvoker;
import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.City;
import com.admas.logiware.dto.Customer;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;



@Component
@Qualifier("sysAdminServiceImpl")
public class MasterServiceImpl{

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(MasterServiceImpl.class);
	
	@Autowired
	@Qualifier("serviceInvoker")
	private ServiceInvoker serviceInvoker;

	/**
	 * @param orderField
	 * @param orderType
	 * @return
	 * @throws IOException
	 */

	protected <T, K> K doServiceCall(FlowData flowData,
			ServiceName serviceName, T request) throws LogiwareBaseException {
		return serviceInvoker.invoke(serviceName, request);
	}

	public Map<String, Object> showAddCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		String viewName = "";
		try {
			viewName = "showAddCity";
			City city = new City();
			resDtoObjects.put("city", city);

		} catch (Exception exp) {
			logger.error("Exception in addCity()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> getAllCities(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		
		logger.info("MasterServiceImpl getAllCity method start. ");
		City city=new City();
		City city1=new City();
		List<City> lCities=new ArrayList<City>();
		String viewName="";
		try {
			viewName="getAllCities";
//			city = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			city.setCityName("Pune");
			city1.setCityName("Mumbai");
			lCities.add(city);
			lCities.add(city1);
			resDtoObjects.put("lCity", lCities);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		/*} catch (LogiwareBaseException b) {
			throw b;*/
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllCity client method end.",
					e);
			/*throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());*/
		}
		logger.info("MasterServiceImpl getAllCity() method end. ");
		//return responseUser;
		return resDtoObjects;
		
	}

	public Map<String, Object> editCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		logger.info("MasterServiceImpl editCity() method Start. ");
		String viewName = "";
		try {
			viewName = "addCity";
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName)
;		} catch (Exception exp) {
			logger.error("Exception in editCity()", exp);
		}
		logger.info("MasterServiceImpl editCity() method end. ");
		return resDtoObjects;
	}
	
	public Map<String, Object> saveCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		logger.info("MasterServiceImpl getAllCity method start. ");
		City city=new City();
		City city1=new City();
		List<City> lCities=new ArrayList<City>();
		String viewName="";
		try {
			viewName="getAllCities";
//			city = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			city.setCityName("Pune");
			city1.setCityName("Mumbai");
			lCities.add(city);
			lCities.add(city1);
			resDtoObjects.put("lCity", lCities);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		/*} catch (LogiwareBaseException b) {
			throw b;*/
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllCity client method end.",
					e);
			/*throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());*/
		}
		logger.info("MasterServiceImpl getAllCity() method end. ");
		//return responseUser;
		return resDtoObjects;
	}
	
	
	
	
	
	
	
}

