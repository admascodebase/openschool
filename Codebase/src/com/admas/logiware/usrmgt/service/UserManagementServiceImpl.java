package com.admas.logiware.usrmgt.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.logiware.client.ServiceEndPointConstants.ServiceName;
import com.admas.logiware.client.ServiceInvoker;
import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.EmployeeDto;
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
			flowData.setSessionDataObject(WebAppConstants.USER, userDetails);
			flowData.setSessionData(WebAppConstants.USERNAME, userDetails.getCustCompEmployee().getName());
			flowData.setSessionData(WebAppConstants.COMPID, userDetails.getCustCompEmployee().getCompId()!=null ? userDetails.getCustCompEmployee().getCompId().toString() : "");
			flowData.setSessionData(WebAppConstants.BRANCHID, userDetails.getCustCompEmployee().getBranchId() != null ? userDetails.getCustCompEmployee().getBranchId().toString() : "");
			flowData.setSessionData(WebAppConstants.ROLEID, "2");
			flowData.setSessionData(WebAppConstants.EMPID, userDetails.getCustCompEmployee().getId().toString());
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

	public Map<String, Object> getSmsBalance(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("UserManagementServiceImpl getSmsBalance method start. ");
		LogiwareRespnse logiwareResponse = null;
		String balance="";
		try {
			logiwareResponse = doServiceCall(flowData, ServiceName.getSmsBalance, reqDtoObjects);
			balance = (String)logiwareResponse.getData();
			resDtoObjects.put("balance", balance);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In UserManagementServiceImpl: getSmsBalance method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("UserManagementServiceImpl getSmsBalance method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> saveChangePassword(FlowData flowData, HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("UserManagementServiceImpl saveChangePassword method start. ");
		LogiwareRespnse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData, ServiceName.saveChangePassword, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In UserManagementServiceImpl: saveChangePassword method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("UserManagementServiceImpl saveChangePassword method end. ");
		return resDtoObjects;
	
	}

	public Map<String, Object> getemployeeDetails(FlowData flowData, HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		logger.info("UserManagementServiceImpl getemployeeDetails method start. ");
		LogiwareRespnse logiwareResponse = null;
		try {
			reqDtoObjects.put("employeeId", Integer.parseInt(flowData.getSessionData(WebAppConstants.EMPID)));
			logiwareResponse = doServiceCall(flowData, ServiceName.getemployeeDetails,
					reqDtoObjects);
			EmployeeDto employeeDto = logiwareResponse.getEmployeeDto();
			resDtoObjects.put("employeeDto", employeeDto);
			resDtoObjects.put("userRensponce", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In EnterpriseControllerService: getemployeeDetails method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("UserManagementServiceImpl getemployeeDetails method end. ");
		return resDtoObjects;
		
	}

	public Map<String, Object> resetPassword(FlowData flowData, HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		logger.info("UserManagementServiceImpl getemployeeDetails method start. ");
		LogiwareRespnse logiwareResponse = null;
		try {
			
			logiwareResponse = doServiceCall(flowData, ServiceName.resetPassword,
					reqDtoObjects);
			resDtoObjects.put("userRensponce", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In EnterpriseControllerService: getemployeeDetails method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("UserManagementServiceImpl getemployeeDetails method end. ");
		return resDtoObjects;

	}

	public Map<String, Object> authenticateEmail(FlowData flowData, HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("UserManagementServiceImpl authenticateEmail method start. ");
		LogiwareRespnse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData, ServiceName.authenticateEmail, reqDtoObjects);
			resDtoObjects.put("employeeDto", logiwareResponse.getEmployeeDto());
			resDtoObjects.put("userRensponce", logiwareResponse);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In EnterpriseControllerService: authenticateEmail method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("UserManagementServiceImpl authenticateEmail method end. ");
		return resDtoObjects;

	}

	public Map<String, Object> updateProfile(FlowData flowData, HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {

		logger.info("UserManagementServiceImpl updateProfile method start.");
		LogiwareRespnse logiwareResponse = null;
		Boolean result = false;
		try {
			logiwareResponse = doServiceCall(flowData, ServiceName.saveEditEmployee, reqDtoObjects);
			resDtoObjects.put("userResponse", logiwareResponse);
			result = (Boolean) logiwareResponse.getData();
			resDtoObjects.put("result", result);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In UserManagementServiceImpl: updateProfile method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}

		logger.info("UserManagementServiceImpl updateProfile method End.");
		return resDtoObjects;

	}

}
