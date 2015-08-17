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
import com.admas.logiware.dto.Customer;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.RestResponseUser;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;

@Component
@Qualifier("sysAdminServiceImpl")
public class SysAdminServiceImpl{

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(SysAdminServiceImpl.class);
	
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
	
	public void getAllCustomer(FlowData flowData,
			Map<String, Object> reqDtoObjects, Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		logger.info("SysAdminServiceImpl getAllCustomer client method start. ");
		Customer customer = new Customer();
		try {
			customer = doServiceCall(flowData, ServiceName.getAllCustomer, reqDtoObjects);
			resDtoObjects.put("customer", customer);
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In EnterpriseControllerService: customerLogin client method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());
		}
		logger.info("EnterpriseControllerService customerLogin method end. ");
		//return responseUser;
	}
	
	
	
	
}

