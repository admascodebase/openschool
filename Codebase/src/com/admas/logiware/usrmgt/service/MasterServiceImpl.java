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
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.State;
import com.admas.logiware.dto.TransportType;
import com.admas.logiware.exception.LogiwareBaseException;



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
		State state=new State();
		State state1=new State();
		List<City> lCities=new ArrayList<City>();
		List<State> lStates=new ArrayList<State>();
		String viewName="";
		try {
			viewName="getAllCities";
//			city = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			state.setId(1);
			state.setStateName("MH");
			state1.setId(2);
			state1.setStateName("TS");
			city.setCityName("Pune");
			city.setId(1);
			city1.setCityName("Mumbai");
			city1.setId(2);
			lCities.add(city);
			lCities.add(city1);
			lStates.add(state);
			lStates.add(state1);
			resDtoObjects.put("lCity", lCities);
			resDtoObjects.put("lState", lStates);
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

	public Map<String, Object> showEditCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		logger.info("MasterServiceImpl editCity() method Start. ");
		String viewName = "";
		try {
			viewName = "showAddCity";
			City city = new City();
			city.setCityName("Pune");
			city.setId(1);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			resDtoObjects.put("city", city)
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

	
	
	public Map<String, Object> getAllTransportTypes(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		logger.info("MasterServiceImpl getAllTransportTypes() method start. ");
		TransportType type=new TransportType();
		TransportType type1=new TransportType();
		List<TransportType> lTransports=new ArrayList<TransportType>();
		String viewName="";
		try {
			viewName="getAllTransportTypes";
//			city = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			type.setId(1);
			type.setName("ADMAS");
			type.setDescription("ADMASTECH...");
			type1.setId(2);
			type1.setName("HENX");
			type1.setDescription("henx...");
			lTransports.add(type);
			lTransports.add(type1);
			
			resDtoObjects.put("lTransports", lTransports);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		/*} catch (LogiwareBaseException b) {
			throw b;*/
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl  getAllTransportTypes() method end.",
					e);
			/*throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());*/
		}
		logger.info("MasterServiceImpl  getAllTransportTypes() method end. ");
		//return responseUser;
		return resDtoObjects;
		
		
		
	}

	public Map<String, Object> showAddTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		
		
		String viewName = "";
		try {
			viewName = "showAddTranceportType";
			TransportType transportType=new TransportType();
			resDtoObjects.put("transportType", transportType);

		} catch (Exception exp) {
			logger.error("Exception in TransportType()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> saveTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		
		logger.info("MasterServiceImpl saveTransportType method start. ");
		TransportType type=new TransportType();
		TransportType type1=new TransportType();
		List<TransportType> lTransports=new ArrayList<TransportType>();
		String viewName="";
		try {
			viewName="getAllTransportTypes";
//			city = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			type.setId(1);
			type.setName("ADMAS");
			type.setDescription("ADMASTECH...");
			type1.setId(2);
			type1.setName("HENX");
			type1.setDescription("henx...");
			lTransports.add(type);
			lTransports.add(type1);
			
			resDtoObjects.put("lTransports", lTransports);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		/*} catch (LogiwareBaseException b) {
			throw b;*/
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception In MasterServiceImpl saveTransportType  method end.", e);
					
			/*throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());*/
		}
		logger.info("MasterServiceImpl saveTransportType() method end. ");
		//return responseUser;
		return resDtoObjects;
	
	}

	public Map<String, Object> showEditTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		logger.info("MasterServiceImpl showEditTransportType() method Start. ");
		String viewName = "";
		try {
			viewName = "showAddTranceportType";
			TransportType type=new TransportType();
			type.setCompanyId(123);
			type.setDescription("XXXXXX");
			logger.info("########################"+reqDtoObjects.get("id"));
			type.setId(Integer.parseInt(reqDtoObjects.get("id").toString()));
			type.setName("ASDASD");
			
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			resDtoObjects.put("transportType",type);
			} catch (Exception exp) {
			logger.error("Exception in showEditTransportType()", exp);
		}
		logger.info("MasterServiceImpl showEditTransportType() method End. ");
		return resDtoObjects;
	}

	public Map<String, Object> showDeleteTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		
		logger.info("MasterServiceImpl showDeleteTransportType() method Start. ");
		TransportType type=new TransportType();
		TransportType type1=new TransportType();
		List<TransportType> lTransports=new ArrayList<TransportType>();
		String viewName="";
		try {
			viewName="getAllTransportTypes";
//			city = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			System.out.println("#########delete###############"+reqDtoObjects.get("id"));
			type.setId(1);
			type.setName("ADMAS");
			type.setDescription("ADMASTECH...");
			type1.setId(2);
			type1.setName("HENX");
			type1.setDescription("henx...");
			lTransports.add(type);
			lTransports.add(type1);
			
			resDtoObjects.put("lTransports", lTransports);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			
			} catch (Exception exp) {
			logger.error("Exception in showDeleteTransportType()", exp);
		}
		logger.info("MasterServiceImpl showDeleteTransportType() method End. ");
		return resDtoObjects;
	}

	public Map<String, Object> showDeleteCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		
		
		logger.info("MasterServiceImpl showDeleteCity method start. ");
		City city=new City();
		City city1=new City();
		State state=new State();
		State state1=new State();
		List<City> lCities=new ArrayList<City>();
		List<State> lStates=new ArrayList<State>();
		String viewName="";
		try {
			viewName="getAllCities";
//			city = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			state.setId(1);
			state.setStateName("MH");
			state1.setId(2);
			state1.setStateName("TS");
			city.setCityName("Pune");
			city.setId(1);
			city1.setCityName("Mumbai");
			city1.setId(2);
			lCities.add(city);
			lCities.add(city1);
			lStates.add(state);
			lStates.add(state1);
			resDtoObjects.put("lCity", lCities);
			resDtoObjects.put("lState", lStates);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		/*} catch (LogiwareBaseException b) {
			throw b;*/
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl showDeleteCity client method end.",
					e);
			/*throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());*/
		}
		logger.info("MasterServiceImpl showDeleteCity() method end. ");
		//return responseUser;
		return resDtoObjects;
		
	}
	
	
	
	
	
	
	
	
}

