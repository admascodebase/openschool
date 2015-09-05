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
import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.dto.UserDetails;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.exception.WebAppException;

@Component
@Qualifier("userManagementServiceImpl")
public class UserManagementServiceImpl {

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

	public Map<String, Object> login(FlowData flowData,
			Map<String, Object> reqDtoObjects, Map<String, Object> resDtoObjects)
			throws WebAppException {

		String viewName = "";
		try {
			viewName = "login";

		} catch (Exception exp) {
			logger.error("Exception in login()", exp);
		}

		resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		return resDtoObjects;
	}

	public Map<String, Object> isValidUser(FlowData flowData,
			Map<String, Object> reqDtoObjects, Map<String, Object> resDtoObjects)
			throws LogiwareBaseException {
		logger.info("UserManagementServiceImpl isValidUser method start. ");
		LogiwareRespnse logiwareResponse = null;
		String viewName = "";
		try {
			viewName = "Dashboard";
			logiwareResponse = doServiceCall(flowData, ServiceName.login,
					reqDtoObjects);
			UserDetails userDetails = (UserDetails)logiwareResponse.getUerDetailsDto();
			flowData.setSessionDataObject("user", userDetails);
			flowData.setSessionData("userName", userDetails.getCustCompEmployee().getName());
			resDtoObjects.put("viewName", viewName);
			} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In EnterpriseControllerService: customerLogin client method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("UserManagementServiceImpl isValidUser method end. ");
		return resDtoObjects;
	}

}
