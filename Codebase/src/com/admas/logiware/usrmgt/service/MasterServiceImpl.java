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
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.client.ServiceEndPointConstants.ServiceName;
import com.admas.logiware.client.ServiceInvoker;
import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.dto.StateDto;
import com.admas.logiware.dto.TransportOwnerDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;

@Component
@Qualifier("sysAdminServiceImpl")
public class MasterServiceImpl {

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
			CityDto city = new CityDto();
			resDtoObjects.put("city", city);

		} catch (Exception exp) {
			logger.error("Exception in addCity()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllCities(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getAllCity method start. ");
		List<CityDto> lCities = new ArrayList<CityDto>();
		LogiwareRespnse logiwareRespnse = null;
		try {
			 logiwareRespnse = doServiceCall(flowData, ServiceName.getAllCity, reqDtoObjects);
			 lCities =(List<CityDto>) logiwareRespnse.getData();			 
			 resDtoObjects.put("lCities", lCities);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllCity method ->.",e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());

		}
		logger.info("MasterServiceImpl getAllCity method End. ");
		return resDtoObjects;
	}

	public Map<String, Object> showEditCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		logger.info("MasterServiceImpl editCity() method Start. ");
		String viewName = "";
		try {
			viewName = "showAddCity";
			CityDto city = new CityDto();
			city.setName("Pune");
			city.setId(1);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			resDtoObjects.put("city", city);
		} catch (Exception exp) {
			logger.error("Exception in editCity()", exp);
		}
		logger.info("MasterServiceImpl editCity() method end. ");
		return resDtoObjects;
	}

	public Map<String, Object> saveCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveCity method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllCities";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveCity, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllCities(flowData,
					reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {			
			logger.error(
					"Exception In MasterServiceImpl: saveCity method end.",
					e);
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllCities(flowData,
				reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveCity method end. ");
		return resDtoObjects;

	}

	//Start of the transport type services
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllTransportTypes(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getAllTransportTypes() method start. ");
		List<TransportTypeDto> lTransports = new ArrayList<TransportTypeDto>();
		LogiwareRespnse logiwareRespnse = null;
		try {
			logiwareRespnse  = doServiceCall(flowData, ServiceName.getAllTransportTypes, reqDtoObjects);			
			lTransports = (List<TransportTypeDto>) logiwareRespnse.getData();			
			resDtoObjects.put("lTransports", lTransports);
			
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllTransportTypes method end.",e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());
		}
		
		logger.info("MasterServiceImpl  getAllTransportTypes() method end. ");
		return resDtoObjects;

	}

	public Map<String, Object> saveTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException{

		logger.info("MasterServiceImpl saveTransportType method start. ");
		LogiwareRespnse logiwareRespnse = null;
		Boolean result=false;
		try {
			logiwareRespnse = doServiceCall(flowData, ServiceName.saveTransportType,
			 reqDtoObjects);
			logiwareRespnse.getData();
			resDtoObjects.put("result", result);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl saveTransportType method end.",e);
			resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());
		}
		resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveTransportType() method end. ");
		return resDtoObjects;

	}
	
	public Map<String, Object> saveEditTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException{
		logger.info("MasterServiceImpl saveEditTransportType method start. ");
		LogiwareRespnse logiwareRespnse = null;
		Boolean result=false;
		try {
			logiwareRespnse = doServiceCall(flowData, ServiceName.saveEditTransportType,
			 reqDtoObjects);
			logiwareRespnse.getData();
			resDtoObjects.put("result", result);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl saveEditTransportType method end.",e);
			resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());
		}
		resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveEditTransportType() method end. ");
		return resDtoObjects;

	}
	
	public Map<String, Object> gettransportTypeById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("MasterServiceImpl gettransportTypeById method start.");
		LogiwareRespnse logiwareResponse = null;
		TransportTypeDto transportTypeDto = new TransportTypeDto();
		try {
			logiwareResponse = doServiceCall(flowData, ServiceName.getTransportTypeById, reqDtoObjects);
			transportTypeDto =(TransportTypeDto) logiwareResponse.getTransportTypeDto();
			resDtoObjects.put("transportType", transportTypeDto);			
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: gettransportTypeById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl gettransportTypeById method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> deleteTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("MasterServiceImpl deleteTransportType method start.");
		LogiwareRespnse logiwareResponse = null;
		Boolean result=false;
		try {
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteTransportType, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {
			resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: deleteTransportType method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl deleteTransportType method end. ");
		return resDtoObjects;
		
	}

	//End of the transport type services

	public Map<String, Object> showDeleteCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		logger.info("MasterServiceImpl showDeleteCity method start. ");
		CityDto city = new CityDto();
		CityDto city1 = new CityDto();
		StateDto state = new StateDto();
		StateDto state1 = new StateDto();
		List<CityDto> lCities = new ArrayList<CityDto>();
		List<StateDto> lStates = new ArrayList<StateDto>();
		String viewName = "";
		try {
			viewName = "getAllCities";
			// city = doServiceCall(flowData, ServiceName.getAllCity,
			// reqDtoObjects);
			state.setId(1);
			state.setStateName("MH");
			state1.setId(2);
			state1.setStateName("TS");
			city.setName("Pune");
			city.setId(1);
			city1.setName("Mumbai");
			city1.setId(2);
			lCities.add(city);
			lCities.add(city1);
			lStates.add(state);
			lStates.add(state1);
			resDtoObjects.put("lCity", lCities);
			resDtoObjects.put("lState", lStates);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			/*
			 * } catch (LogiwareBaseException b) { throw b;
			 */
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl showDeleteCity client method end.",
					e);
			/*
			 * throw new LogiwareBaseException(
			 * LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
			 * LogiwarePortalErrors.INVALID_REQUEST .getErrorDescription());
			 */
		}
		logger.info("MasterServiceImpl showDeleteCity() method end. ");
		// return responseUser;
		return resDtoObjects;

	}

	public ModelAndView getAllBranches(FlowData flowData,
			HashMap<String, Object> resDtoObject) {
		CompanyBranchDto detail = new CompanyBranchDto();
		detail.setName("Hyderabad Branch");
		List<CompanyBranchDto> branchList = new ArrayList<CompanyBranchDto>();
		branchList.add(detail);
		resDtoObject.put("allBranch", branchList);
		String viewName = "";
		try {
			viewName = "branchTiles";
			resDtoObject.put(WebAppConstants.VIEW_NAME, viewName);
			return new ModelAndView(
					(String) resDtoObject.get(WebAppConstants.VIEW_NAME),
					resDtoObject);
		} catch (Exception e) {

		}
		return null;
	}

	public Map<String, Object> getAllCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getAllCompany method start. ");
		List<CompanyDto> lCompanies = new ArrayList<CompanyDto>();
		String viewName = "";
		try {
			viewName = "getAllCompany";
			lCompanies = doServiceCall(flowData, ServiceName.getAllCompany,
					reqDtoObjects);
			resDtoObjects.put("lCompanies", lCompanies);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllCompany method end.",e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());

		}
		logger.info("MasterServiceImpl getAllCompany method End. ");
		return resDtoObjects;

	}

	public Map<String, Object> showAddCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		String viewName = "";
		try {
			viewName = "showAddCompany";
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		}catch (Exception exp) {
			logger.error("Exception in addCompany()", exp);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());
		}

		
		return resDtoObjects;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllEmployee(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException{		
		
		logger.info("MasterServiceImpl getAllEmployee method start.");
		List<EmployeeDto> lEmployees = new ArrayList<EmployeeDto>();
		LogiwareRespnse logiwareRespnse = null;
		try {
			 logiwareRespnse = doServiceCall(flowData, ServiceName.getAllEmployee, reqDtoObjects);
			 lEmployees =(List<EmployeeDto>) logiwareRespnse.getData();			 
			 resDtoObjects.put("lEmployees", lEmployees);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllEmployee method end.",e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());

		}
		logger.info("MasterServiceImpl getAllEmployee method End. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> saveCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllCompany";
			logiwareResponse = doServiceCall(flowData, ServiceName.saveCompany,
					reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveCompany method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl saveCompany method end. ");
		return resDtoObjects;
	}

	public Map<String, Object> saveEmployee(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveEmployee method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllEmployee";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveEmployee, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {			
			logger.error(
					"Exception In MasterServiceImpl: saveEmployee method end.",
					e);
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllEmployee(flowData,
				reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveEmployee method end. ");
		return resDtoObjects;

	}
	
	public Map<String, Object> saveEditEmployee(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveEditEmployee method start.");
		LogiwareRespnse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveEditEmployee, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveEditEmployee method end.",
					e);
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllEmployee(flowData,
				reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveCompany method end. ");
		return resDtoObjects;

	}

	public Map<String, Object> getEmployeeById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getEmployeeById method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "showAddEmployee";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getEmployeeById, reqDtoObjects);
			resDtoObjects.put("viewName", viewName);
			resDtoObjects.put("employee", logiwareResponse.getEmployeeDto());
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: getEmployeeById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl getEmployeeById method end. ");
		return resDtoObjects;
	}

	public Map<String, Object> deleteEmployee(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		
		logger.info("MasterServiceImpl deleteEmployee method start.");
		LogiwareRespnse logiwareResponse = null;
		Boolean result=false;
		try {
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteEmployee, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: deleteEmployee method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl deleteEmployee method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> deleteCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("MasterServiceImpl deleteCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		Boolean result=false;
		try {
			viewName = "getAllCompany";
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteCompany, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: deleteEmployee method end.",
					e);
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllEmployee(flowData,
				reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl deleteEmployee method end. ");
		return resDtoObjects;
		
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllTransportTypeDetails(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {		
		logger.info("MasterServiceImpl getAllTransportTypeDetails() method start. ");
		List<TransportTypeDtlDto> lTransportTypeDtls = new ArrayList<TransportTypeDtlDto>();
		LogiwareRespnse logiwareRespnse = null;
		try {
			logiwareRespnse  = doServiceCall(flowData, ServiceName.getAllTransportTypeDetails, reqDtoObjects);			
			lTransportTypeDtls = (List<TransportTypeDtlDto>) logiwareRespnse.getData();			
			resDtoObjects.put("lTransportTypeDtls", lTransportTypeDtls);			
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllTransportTypeDetails method end.",e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());
		}
		logger.info("MasterServiceImpl  getAllTransportTypeDetails() method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> addTransportTypeDetails(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		String viewName = "";
		try {
			viewName = "showAddTranceportTypeDetails";

		} catch (Exception exp) {
			logger.error("Exception in addTransportTypeDetails()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> saveTransportTypeDetails(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveTransportTypeDetails method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllTransportTypeDetails";
			logiwareResponse = doServiceCall(flowData,	ServiceName.saveTransportTypeDetails, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveTransportTypeDetails method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl saveTransportTypeDetails method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> EditTransportTypeDetails(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		String viewName = "";
		try {
			viewName = "showAddTranceportTypeDetails";

		} catch (Exception exp) {
			logger.error("Exception in EditTransportTypeDetails()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	
	}

	public Map<String, Object> getTransportTypeDetailsById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getTransportTypeDetailsById method start.");
		LogiwareRespnse logiwareResponse = null;
		EmployeeDto employeeDto = new EmployeeDto();
		String viewName = "";
		try {
			viewName = "getAllTransportTypeDetails";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getTransportTypeDtlById, reqDtoObjects);
			Object object = logiwareResponse.getData();
			employeeDto =(EmployeeDto) object;
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
			resDtoObjects.put("employee", employeeDto);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: getEmployeeById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl getEmployeeById method end. ");
		return resDtoObjects;

		
	}

	public Map<String, Object> deleteTransportTypeDetails(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		logger.info("MasterServiceImpl deleteTransportTypeDetails() method Start. ");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		Boolean result=false;
		try {
			viewName = "getAllTransportTypeDetails";
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteTransportTypeDtl, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: deleteTransportTypeDetails method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl deleteTransportTypeDetails() method End. ");
		return resDtoObjects;
	}

	public Map<String, Object> showEditCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {
		String viewName = "";
		try {
			viewName = "showAddCompany";
		} catch (Exception exp) {
			logger.error("Exception in EditCompany()", exp);
		}
		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> getCompanyById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
			
		logger.info("MasterServiceImpl getCompanyById method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllCompany";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getCompanyById, reqDtoObjects);
			
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
			resDtoObjects.put("companyDto",  logiwareResponse.getCompanyDto());
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: getCompanyById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl getCompanyById method end. ");
		return resDtoObjects;
	
	}

	public Map<String, Object> addContractCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		String viewName = "";
		try {
			viewName = "showAddContractCompany";
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		} catch (Exception exp) {
			logger.error("Exception in addContractCompany()", exp);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorDescription());
		}
		return resDtoObjects;

	}

	public Map<String, Object> saveCOntractCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("MasterServiceImpl saveCOntractCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllContractCompany";
			logiwareResponse = doServiceCall(flowData, ServiceName.saveContractCompany,
					reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveCOntractCompany method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl saveCOntractCompany method end. ");
		return resDtoObjects;

	
	}
	

	public Map<String, Object> showEditEmployee(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		String viewName = "";
		try {
			viewName = "showAddEmployee";

		} catch (Exception exp) {
			logger.error("Exception in EditEmployee()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllContractCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getAllContractCompany() method start. ");
		List<ContractCompDto> lContractCompanies = new ArrayList<ContractCompDto>();
		LogiwareRespnse logiwareRespnse = null;
		String viewName = "";
		try {
			viewName = "getAllContractCompany";
			logiwareRespnse  = doServiceCall(flowData, ServiceName.getAllContractCompany, reqDtoObjects);
			
			lContractCompanies = (List<ContractCompDto>) logiwareRespnse.getData();			
			resDtoObjects.put("lContractCompanies", lContractCompanies);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			
			  } catch (LogiwareBaseException b) {
				  throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl  getAllContractCompany() method end.",
					e);
			/*
			 * throw new LogiwareBaseException(
			 * LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
			 * LogiwarePortalErrors.INVALID_REQUEST .getErrorDescription());
			 */
		}
		logger.info("MasterServiceImpl  getAllContractCompany() method end. ");
		// return responseUser;
		return resDtoObjects;

	}

	public Map<String, Object> showEditContractCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		String viewName = "";
		try {
			viewName = "showAddContractCompany";

		} catch (Exception exp) {
			logger.error("Exception in showEditContractCompany()", exp);
		}
		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> getContractCompanyById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getContractCompanyById method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllContractCompany";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getContractCompanyById, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: getContractCompanyById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl getContractCompanyById method end. ");
		return resDtoObjects;
	}

	public Map<String, Object> deleteContractCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		logger.info("MasterServiceImpl deleteContractCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		Boolean result=false;
		try {
			viewName = "getAllContractCompany";
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteContractCompany, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: deleteContractCompany method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl deleteContractCompany method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> saveEditContractCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		logger.info("MasterServiceImpl saveEditContractCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllContractCompany";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveEditContractCompany, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveEditContractCompany method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterSe" +
				"rviceImpl saveEditContractCompany method end. ");
		return resDtoObjects;
	}

	public Map<String, Object> saveEditCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("MasterServiceImpl saveEditCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllCompany";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveEditCompany, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveEditCompany method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterSe" +
				"rviceImpl saveEditCompany method end. ");
		return resDtoObjects;
	
	}

	public Map<String, Object> saveEditCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {


		logger.info("MasterServiceImpl saveEditCity method start.");
		LogiwareRespnse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveEditCity, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllCities(flowData,
					reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveEditCity method end.",
					e);
			resDtoObjects = getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllCities(flowData,
				reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveCity method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> deleteCity(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl deleteCity method start.");
		LogiwareRespnse logiwareResponse = null;
		Boolean result=false;
		try {
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteCity, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: deleteCity method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl deleteCity method end. ");
		return resDtoObjects;

	}

	public Map<String, Object> getCityById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getCityById method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "showAddCity";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getCityById, reqDtoObjects);
			resDtoObjects.put("viewName", viewName);
			resDtoObjects.put("city", logiwareResponse.getCityDto());
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: getCityById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl getCityById method end. ");
		return resDtoObjects;

		
		
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllStates(FlowData flowData,
			Map<String, Object> resDtoObjects,
			HashMap<String, Object> reqDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getAllStates method start. ");
		List<CityDto> lCities = new ArrayList<CityDto>();
		LogiwareRespnse logiwareRespnse = null;
		try {
			 logiwareRespnse = doServiceCall(flowData, ServiceName.getAllStates, reqDtoObjects);
			 lCities =(List<CityDto>) logiwareRespnse.getData();			 
			 resDtoObjects.put("lCities", lCities);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In MasterServiceImpl getAllStates method ->.",e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());

		}
		logger.info("MasterServiceImpl getAllStates method End. ");
		return resDtoObjects;

	}

	public Map<String, Object> getSettingByType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {


		logger.info("MasterServiceImpl getSettingByType method start.");
		LogiwareRespnse logiwareResponse = null;
		Integer compId = Integer.parseInt(flowData.getSessionData(WebAppConstants.COMPID));
		String typeValue = "CONTRACT_COMP_SMS";
		reqDtoObjects.put("compId", compId);
		reqDtoObjects.put("typeValue", typeValue);
		try {
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getSettingByType, reqDtoObjects);
			
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("settingDto",  logiwareResponse.getSettingDto());
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: getSettingByType method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl getSettingByType method end. ");
		return resDtoObjects;

	}

	public Map<String, Object> sendSmsToContractCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

			
		logger.info("MasterServiceImpl sendSmsToContractCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData,	ServiceName.sendSmsToContractCompany, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("settingDto",  logiwareResponse.getSettingDto());
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: sendSmsToContractCompany method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl sendSmsToContractCompany method end. ");
		return resDtoObjects;
		
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllTransportOwners(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
			
			logger.info("MasterServiceImpl getAllTransportOwners method start.");
			List<TransportOwnerDto> lTransportOwners = new ArrayList<TransportOwnerDto>();
			LogiwareRespnse logiwareRespnse = null;
			try {
				 logiwareRespnse = doServiceCall(flowData, ServiceName.getAllTransportOwners, reqDtoObjects);
				 lTransportOwners =(List<TransportOwnerDto>) logiwareRespnse.getData();			 
				 resDtoObjects.put("lTransportOwners", lTransportOwners);
			} catch (LogiwareBaseException b) {
				throw b;
			} catch (Exception e) {
				logger.error("Exception In MasterServiceImpl getAllTransportOwners method end.",e);
				throw new LogiwareBaseException(
						LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
						LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());
			}
			logger.info("MasterServiceImpl getAllTransportOwners method End. ");
			return resDtoObjects;
			
		}


	public Map<String, Object> saveTransportOwner(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveTransportOwner method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllTransportOwners";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveTransportOwner, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllTransportOwners(flowData,
					reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {			
			logger.error(
					"Exception In MasterServiceImpl: saveTransportOwner method end.",
					e);
			resDtoObjects = getAllTransportOwners(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllTransportOwners(flowData,
				reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveTransportOwner method end. ");
		return resDtoObjects;

	}
	
	public Map<String, Object> saveEditTransportOwner(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveEditTransportOwner method start.");
		LogiwareRespnse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveEditTransportOwner, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllTransportOwners(flowData,
					reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveEditTransportOwner method end.",
					e);
			resDtoObjects = getAllTransportOwners(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllTransportOwners(flowData,
				reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveEditTransportOwner method end. ");
		return resDtoObjects;

	}

	public Map<String, Object> getTransportOwnerById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("MasterServiceImpl getTransportOwnerById method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "showAddTransportOwner";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getTransportOwnerById, reqDtoObjects);
			resDtoObjects.put("viewName", viewName);
			resDtoObjects.put("transportOwner", logiwareResponse.getTransportOwnerDto());
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: getTransportOwnerById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl getTransportOwnerById method end. ");
		return resDtoObjects;

		
	}

	public Map<String, Object> deleteTransportOwner(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl deleteTransportOwner method start.");
		LogiwareRespnse logiwareResponse = null;
		Boolean result=false;
		try {
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteTransportOwner, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: deleteTransportOwner method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl deleteTransportOwner method end. ");
		return resDtoObjects;
	}

	
	
}
