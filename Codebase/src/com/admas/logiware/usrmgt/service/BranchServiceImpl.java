package com.admas.logiware.usrmgt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admas.logiware.client.ServiceEndPointConstants.ServiceName;
import com.admas.logiware.client.ServiceInvoker;
import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
@Component
public class BranchServiceImpl implements BranchService {

	@Autowired
	private ServiceInvoker serviceInvoker;

	public BranchServiceImpl() {
	}
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);
	
	protected <T, K> K doServiceCall(FlowData flowData,
			ServiceName serviceName, T request) throws LogiwareBaseException {
		return serviceInvoker.invoke(serviceName, request);
	}

	@Override
	public Map<String,Object> getAllBranch(FlowData flowData, Map<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects)throws LogiwareBaseException {
		logger.info("BranchServiceImpl getAllEmployee method start.");
		List<CompanyBranchDto> lBranches = new ArrayList<CompanyBranchDto>();
		LogiwareRespnse logiwareRespnse = null;
		String viewName = "";
		try {
			viewName = "getAllBranch";
			 logiwareRespnse = doServiceCall(flowData, ServiceName.getAllBranch, reqDtoObjects);
			 lBranches =(List<CompanyBranchDto>) logiwareRespnse.getData();
			 
			resDtoObjects.put("lBranches", lBranches);
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

	@Override
	public Map<String, Object> saveEditCompanyBranch(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
			logger.info("BranchServiceImpl saveEditCompanyBranch method start.");
			LogiwareRespnse logiwareResponse = null;
			try {
				logiwareResponse = doServiceCall(flowData,
						ServiceName.saveEditCompanyBranch, reqDtoObjects);
				resDtoObjects.put("userResponse", logiwareResponse);
			} catch (LogiwareBaseException b) {
				resDtoObjects = getAllBranch(flowData,
						reqDtoObjects, resDtoObjects);
				throw b;
			} catch (Exception e) {
				logger.error(
						"Exception In BranchServiceImpl : saveEditCompanyBranch method end.",
						e);
				resDtoObjects = getAllBranch(flowData, reqDtoObjects, resDtoObjects);
				throw new LogiwareBaseException(
						LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
						LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
			}
			resDtoObjects = getAllBranch(flowData,	reqDtoObjects, resDtoObjects);
			logger.info("BranchServiceImpl saveEditCompanyBranch method end. ");
			return resDtoObjects;
		
	}

	@Override
	public Map<String, Object> saveCompanyBranch(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("MasterServiceImpl saveEmployee method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "getAllBranch";
			logiwareResponse = doServiceCall(flowData,	ServiceName.saveCompanyBranch, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			resDtoObjects = getAllBranch(flowData,	reqDtoObjects, resDtoObjects);
			throw b;
		} catch (Exception e) {			
			logger.error(
					"Exception In MasterServiceImpl: saveEmployee method end.",
					e);
			resDtoObjects = getAllBranch(flowData,
					reqDtoObjects, resDtoObjects);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObjects = getAllBranch(flowData, reqDtoObjects, resDtoObjects);
		logger.info("MasterServiceImpl saveEmployee method end. ");
		return resDtoObjects;
		
	}

	@Override
	public Map<String, Object> getCompanyBranchById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("BranchServiceImpl getCompanyBranchById method start.");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "showAddCompanyBranch";
			logiwareResponse = doServiceCall(flowData,
					ServiceName.getCompanyBranchById, reqDtoObjects);
			resDtoObjects.put("viewName", viewName);
			resDtoObjects.put("companyBranch", logiwareResponse.getCompanyBranchDto());
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"Exception In BranchServiceImpl: getCompanyBranchById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("BranchServiceImpl getCompanyBranchById method end. ");
		return resDtoObjects;
	}

	@Override
	public Map<String, Object> deleteCompanyBranch(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		
		logger.info("branchServiceImpl deleteCompanyBranch method start.");
		LogiwareRespnse logiwareResponse = null;
		Boolean result=false;
		try {
			logiwareResponse = doServiceCall(flowData,	ServiceName.deleteCompanyBranch, reqDtoObjects);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In branchServiceImpl: deleteCompanyBranch method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("branchServiceImpl deleteCompanyBranch method end. ");
		return resDtoObjects;
	}

}
