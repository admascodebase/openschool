package com.admas.logiware.usrmgt.service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.logiware.client.ServiceEndPointConstants.ServiceName;
import com.admas.logiware.client.ServiceInvoker;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.RestResponseUser;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;

@Component
@Qualifier("userManagementServiceImpl")
public class UserManagementServiceImpl implements IUserManagementService {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(UserManagementServiceImpl.class);
	
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
	
	@Override
	public RestResponseUser isValidUser(FlowData flowData,
			Map<String, Object> reqDtoObjects, Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		logger.info("EnterpriseControllerService customerLogin client method start. ");
		RestResponseUser responseUser = new RestResponseUser();
		try {
			responseUser = doServiceCall(flowData, ServiceName.login, reqDtoObjects);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In EnterpriseControllerService: customerLogin client method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());
		}
		logger.info("EnterpriseControllerService customerLogin method end. ");
		return responseUser;
	}
	
}

