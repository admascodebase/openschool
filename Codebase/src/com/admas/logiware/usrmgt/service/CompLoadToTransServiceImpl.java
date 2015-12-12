/**
 * 
 */
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
import com.admas.logiware.dto.CompanyLoadToTransDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.response.CompLoadDtlResponse;
import com.admas.logiware.dto.response.CompLoadToTransResponse;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;

/**
 * @author Ajinkya
 *
 */
@Component
@Qualifier("sysAdminServiceImpl")
public class CompLoadToTransServiceImpl {

	/**
	 * 
	 */
	public CompLoadToTransServiceImpl() {
	}

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(CompLoadToTransServiceImpl.class);

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

	public Map<String, Object> getAllCompLoadToTrans(FlowData flowData, HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("CompLoadToTransServiceImpl getAllCompLoadToTrans method start.");
		List<CompanyLoadToTransDto> lcompanyLoadToTransDto = new ArrayList<CompanyLoadToTransDto>();
		CompLoadToTransResponse compLoadToTransResponse = null;
		try {
			compLoadToTransResponse = doServiceCall(flowData, ServiceName.getAllCompLoadToTrans, reqDtoObjects);
			lcompanyLoadToTransDto =(List<CompanyLoadToTransDto>) compLoadToTransResponse.getlCompanyLoadToTransDtos();		 
			 resDtoObjects.put("lcompanyLoadToTransDto", lcompanyLoadToTransDto);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In CompLoadToTransServiceImpl getAllCompLoadToTrans method end.",e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode(),
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorDescription());
		}
		logger.info("CompLoadToTransServiceImpl getAllCompLoadToTrans method End. ");
		return resDtoObjects;
	}

	public Map<String, Object> saveCompanyLoadToTransDto(FlowData flowData, HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		

		logger.info("CompLoadToTransServiceImpl saveCompanyLoadToTransDto method start.");
		CompLoadDtlResponse compLoadDtlResponse = null;
		String viewName = "";
		try {
			compLoadDtlResponse = doServiceCall(flowData,	ServiceName.saveCompanyLoadToTransDto, reqDtoObjects);
			resDtoObjects.put("userResponse", compLoadDtlResponse);
			resDtoObjects.put("viewName", viewName);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In CompLoadToTransServiceImpl: saveCompanyLoadToTransDto method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
//		resDtoObjects = getAllLoadEntry(flowData, reqDtoObjects, resDtoObjects);
		logger.info("CompLoadToTransServiceImpl saveCompanyLoadToTransDto method end. ");
		return resDtoObjects;

	
	}

	
	
	
	
}
