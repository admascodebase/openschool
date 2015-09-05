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
import com.admas.logiware.dto.BranchDetail;
import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.dto.State;
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

	public Map<String, Object> getAllCities(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		logger.info("MasterServiceImpl getAllCity method start. ");
		CityDto city = new CityDto();
		CityDto city1 = new CityDto();
		State state = new State();
		State state1 = new State();
		List<CityDto> lCities = new ArrayList<CityDto>();
		List<State> lStates = new ArrayList<State>();
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
					"Exception In MasterServiceImpl getAllCity client method end.",
					e);
			/*
			 * throw new LogiwareBaseException(
			 * LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
			 * LogiwarePortalErrors.INVALID_REQUEST .getErrorDescription());
			 */
		}
		logger.info("MasterServiceImpl getAllCity() method end. ");
		// return responseUser;
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
			Map<String, Object> resDtoObjects) {

		logger.info("MasterServiceImpl getAllCity method start. ");
		CityDto city = new CityDto();
		CityDto city1 = new CityDto();
		List<CityDto> lCities = new ArrayList<CityDto>();
		String viewName = "";
		try {
			viewName = "getAllCities";
			// city = doServiceCall(flowData, ServiceName.getAllCity,
			// reqDtoObjects);
			city.setName("Pune");
			city1.setName("Mumbai");
			lCities.add(city);
			lCities.add(city1);
			resDtoObjects.put("lCity", lCities);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			/*
			 * } catch (LogiwareBaseException b) { throw b;
			 */
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl getAllCity client method end.",
					e);
			/*
			 * throw new LogiwareBaseException(
			 * LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
			 * LogiwarePortalErrors.INVALID_REQUEST .getErrorDescription());
			 */
		}
		logger.info("MasterServiceImpl getAllCity() method end. ");
		// return responseUser;
		return resDtoObjects;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllTransportTypes(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl getAllTransportTypes() method start. ");
		List<TransportTypeDto> lTransports = new ArrayList<TransportTypeDto>();
		LogiwareRespnse logiwareRespnse = null;
		String viewName = "";
		try {
			viewName = "getAllTransportTypes";
			logiwareRespnse  = doServiceCall(flowData, ServiceName.getAllTransportTypes, reqDtoObjects);
			
			lTransports = (List<TransportTypeDto>) logiwareRespnse.getData();			
			resDtoObjects.put("lTransports", lTransports);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			
			  } catch (LogiwareBaseException b) {
				  throw b;
			 
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl  getAllTransportTypes() method end.",
					e);
			/*
			 * throw new LogiwareBaseException(
			 * LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
			 * LogiwarePortalErrors.INVALID_REQUEST .getErrorDescription());
			 */
		}
		logger.info("MasterServiceImpl  getAllTransportTypes() method end. ");
		// return responseUser;
		return resDtoObjects;

	}

	public Map<String, Object> addTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		String viewName = "";
		try {
			viewName = "showAddTranceportType";

		} catch (Exception exp) {
			logger.error("Exception in addTransportType()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> saveTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		logger.info("MasterServiceImpl saveTransportType method start. ");
		String viewName = "";
		LogiwareRespnse logiwareRespnse = null;
		Boolean result=false;
		try {
			viewName = "getAllTransportTypes";
			logiwareRespnse = doServiceCall(flowData, ServiceName.saveTransportType,
			 reqDtoObjects);
			logiwareRespnse.getData();
			resDtoObjects.put("result", result);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			/*
			 * } catch (LogiwareBaseException b) { throw b;
			 */
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl saveTransportType  method end.",
					e);

			/*
			 * throw new LogiwareBaseException(
			 * LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
			 * LogiwarePortalErrors.INVALID_REQUEST .getErrorDescription());
			 */
		}
		logger.info("MasterServiceImpl saveTransportType() method end. ");
		// return responseUser;
		return resDtoObjects;

	}

	public Map<String, Object> EditTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		String viewName = "";
		try {
			viewName = "showAddTranceportType";

		} catch (Exception exp) {
			logger.error("Exception in showEditTransportType()", exp);
		}
		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> showDeleteTransportType(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

		logger.info("MasterServiceImpl showDeleteTransportType() method Start. ");
		TransportTypeDto type = new TransportTypeDto();
		TransportTypeDto type1 = new TransportTypeDto();
		List<TransportTypeDto> lTransports = new ArrayList<TransportTypeDto>();
		String viewName = "";
		try {
			viewName = "getAllTransportTypes";
			// city = doServiceCall(flowData, ServiceName.getAllCity,
			// reqDtoObjects);
			System.out.println("#########delete###############"
					+ reqDtoObjects.get("id"));
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
		CityDto city = new CityDto();
		CityDto city1 = new CityDto();
		State state = new State();
		State state1 = new State();
		List<CityDto> lCities = new ArrayList<CityDto>();
		List<State> lStates = new ArrayList<State>();
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
		BranchDetail detail = new BranchDetail();
		detail.setBranchName("Hyderabad Branch");
		List<BranchDetail> branchList = new ArrayList<BranchDetail>();
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
		String viewName = "";
		try {
			viewName = "getAllEmployee";
			 logiwareRespnse = doServiceCall(flowData, ServiceName.getAllEmployee, reqDtoObjects);
			 lEmployees =(List<EmployeeDto>) logiwareRespnse.getData();
			 
			resDtoObjects.put("lEmployees", lEmployees);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
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

	public Map<String, Object> showAddEmployee(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) {

	
		String viewName = "";
		try {
			viewName = "showAddEmployee";

		} catch (Exception exp) {
			logger.error("Exception in addEmployee()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	
	}

	public Map<String, Object> saveCompany(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveCompany method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllCompanies";
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
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveEmployee method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl saveEmployee method end. ");
		return resDtoObjects;

	}
	
	public Map<String, Object> saveEditEmployee(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveEditEmployee method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllEmployee";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.saveEditEmployee, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl: saveEditEmployee method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
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
		EmployeeDto employeeDto = new EmployeeDto();
		String viewName = "";
		Boolean result=false;
		try {
			viewName = "getAllEmployee";
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteEmployee, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
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
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
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

	public Map<String, Object> gettransportTypeById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("MasterServiceImpl gettransportTypeById method start.");
		LogiwareRespnse logiwareResponse = null;
		TransportTypeDto transportTypeDto = new TransportTypeDto();
		String viewName = "";
		try {
			viewName = "getAllTransportTypes";
			logiwareResponse = doServiceCall(flowData, ServiceName.getTransportTypeById, reqDtoObjects);
			
			/*
			 * here conversion exception occurs
			 * 
			 */
			
			Object object = logiwareResponse.getData();
			transportTypeDto =(TransportTypeDto) object;
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
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
		String viewName = "";
		Boolean result=false;
		try {
			viewName = "getAllTransportTypes";
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteTransportType, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In MasterServiceImpl: deleteTransportType method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("MasterServiceImpl deleteTransportType method end. ");
		return resDtoObjects;
		
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllTransportTypeDetails(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

	
		
		logger.info("MasterServiceImpl getAllTransportTypeDetails() method start. ");
		List<TransportTypeDtlDto> lTransportTypeDtls = new ArrayList<TransportTypeDtlDto>();
		LogiwareRespnse logiwareRespnse = null;
		String viewName = "";
		try {
			viewName = "getAllTransportTypeDetails";
			logiwareRespnse  = doServiceCall(flowData, ServiceName.getAllTransportTypeDetails, reqDtoObjects);
			
			lTransportTypeDtls = (List<TransportTypeDtlDto>) logiwareRespnse.getData();			
			resDtoObjects.put("lTransportTypeDtls", lTransportTypeDtls);
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
			
			  } catch (LogiwareBaseException b) {
				  throw b;
			 
		} catch (Exception e) {
			logger.error(
					"Exception In MasterServiceImpl  getAllTransportTypeDetails() method end.",
					e);
			/*
			 * throw new LogiwareBaseException(
			 * LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
			 * LogiwarePortalErrors.INVALID_REQUEST .getErrorDescription());
			 */
		}
		logger.info("MasterServiceImpl  getAllTransportTypeDetails() method end. ");
		// return responseUser;
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
		EmployeeDto employeeDto = new EmployeeDto();
		String viewName = "";
		try {
			viewName = "getAllCompany";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getCompanyById, reqDtoObjects);
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
			viewName = "getAllCompany";
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

}
