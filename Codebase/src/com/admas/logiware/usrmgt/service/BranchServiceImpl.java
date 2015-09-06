package com.admas.logiware.usrmgt.service;

import java.util.ArrayList;
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

}
