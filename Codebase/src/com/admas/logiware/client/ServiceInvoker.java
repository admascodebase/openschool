/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.logiware.client.ServiceEndPointConstants.ServiceName;
import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.Customer;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.util.PropertyHandler;
import com.admas.logiware.util.ResourceHandler;

/**
 * @author Admas Tech
 * 
 */
@Component
@Qualifier("serviceInvoker")
public class ServiceInvoker implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T, K> K invoke(ServiceName serviceName, T request)
			throws LogiwareBaseException {
		logger.info("ServiceInvoker:invoke method Start.");
		K response = null;
		String host = PropertyHandler.getProperty("logiware.serivce.host");
		int port = Integer.parseInt(PropertyHandler
				.getProperty("logiware.serivce.port"));
		String urlTemplate = PropertyHandler
				.getProperty("logiware.serivce.url.template");
		logger.info("**************" + serviceName.value());
		String serviceEndPoint = ResourceHandler.instance()
				.getServiceEndPoints(serviceName.value());

		String url = String.format(urlTemplate, host, port, serviceEndPoint);
		switch (serviceName) {
		case login: {
			response = (K) login(url, (Map) request);
			break;
		}
		case getAllCustomer: {
			response = (K) getAllCustomer(url, (Map) request);
			break;
		}
		case getAllCompany: {
			response = (K) getAllCompany(url, (Map) request);
			break;
		}
		case saveCompany: {
			response = (K) saveCompany(url, (Map) request);
			break;
		}
		case getAllEmployee: {
			response = (K) getAllEmployee(url, (Map) request);
			break;
		}
		case saveEmployee: {
			response = (K) saveEmployee(url, (Map) request);
			break;
		}
		case getEmployeeById: {
			response = (K) getEmployeeById(url, (Map) request);
			break;
		}
		case deleteEmployee: {
			response = (K) deleteEmployee(url, (Map) request);
			break;
		}
		case getCompanyById: {
			response = (K) getCompanyById(url, (Map) request);
			break;
		}
		case deleteCompany: {
			response = (K) deleteCompany(url, (Map) request);
			break;
		}
		case getAllTransportTypes: {
			response = (K) getAllTransportTypes(url, (Map) request);
			break;
		}
		case saveTransportType: {
			response = (K) saveTransportType(url, (Map) request);
			break;
		}
		case getTransportTypeById: {
			response = (K) getTransportTypeById(url, (Map) request);
			break;
		}
		case deleteTransportType: {
			response = (K) deleteTransportType(url, (Map) request);
			break;
		}
		case getAllTransportTypeDetails: {
			response = (K) getAllTransportTypeDetails(url, (Map) request);
			break;
		}
		case saveTransportTypeDetails: {
			response = (K) saveTransportTypeDetails(url, (Map) request);
			break;
		}
		case getTransportTypeDtlById: {
			response = (K) getTransportTypeDtlById(url, (Map) request);
			break;
		}
		case deleteTransportTypeDtl: {
			response = (K) deleteTransportTypeDtl(url, (Map) request);
			break;
		}
		case saveContractCompany: {
			response = (K) saveContractCompany(url, (Map) request);
			break;
		}
		case getAllContractCompany: {
			response = (K) getAllContractCompany(url, (Map) request);
			break;
		}
		case getContractCompanyById: {
			response = (K) getContractCompanyById(url, (Map) request);
			break;
		}
		case deleteContractCompany: {
			response = (K) deleteContractCompany(url, (Map) request);
			break;
		}
		default:
			break;
		}
		logger.info("ServiceInvoker:invoke method End");
		return response;
	}

	/**
	 * @param flowData
	 * @param url
	 * @param request
	 * @return
	 * @throws LogiwareBaseException
	 */
	public LogiwareRespnse login(String url, Map<String, Object> request)
			throws LogiwareBaseException {
		logger.info("ServiceInvoker login method start. ");
		LogiwareRespnse logiwareResponse = null;
		try {
			String userName = (String) request.get("userName");
			String password = (String) request.get("password");
			ClientRequest clientRequest = new ClientRequest(url
					+ WebAppConstants.URL_SEPERATOR + userName
					+ WebAppConstants.URL_SEPERATOR + password);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);

			// In case of post request we have to writethe code like

			/*
			 * clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, queryPojo);
			 * ClientResponse<LogiwareRespnse> response = clientRequest
			 * .post(LogiwareRespnse.class);
			 */

			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker login method end. ");
		return logiwareResponse;
	}

	public Customer getAllCustomer(String url, Map<String, Object> request)
			throws LogiwareBaseException {
		logger.info("ServiceInvoker login method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		Customer customer = new Customer();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			// /restResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker login method end. ");
		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<CompanyDto> getAllCompany(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		List<CompanyDto> lCompanies = new ArrayList<CompanyDto>();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} else {
				lCompanies = (List<CompanyDto>) logiwareResponse.getData();
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllCompany method end. ");
		return lCompanies;
	}

	
	
	public LogiwareRespnse saveCompany(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker saveCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("company"));
			ClientResponse<LogiwareRespnse> response = clientRequest
					.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllCompany method end. ");
		return logiwareResponse;
	}
	
	
	
	public LogiwareRespnse getAllEmployee(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllEmployee method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} /*else {
				lCompanies = (List<CompanyDto>) logiwareResponse.getData();
			}*/

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllEmployee method end. ");
		return logiwareResponse;
	}
	
	
	

	public LogiwareRespnse saveEmployee(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker saveemployee method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("employee"));
			ClientResponse<LogiwareRespnse> response = clientRequest
					.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} /*else {
				result = (Boolean) logiwareResponse.getData();
			}*/

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllCompany method end. ");
		return logiwareResponse;
	}
	
	/*
	 *Get Employee By Id 
	 */
	public LogiwareRespnse getEmployeeById(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker getEmployeeById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			
			Integer Employeeid= (Integer)request.get("employeeId");
			ClientRequest clientRequest = new ClientRequest(url+ WebAppConstants.URL_SEPERATOR + Employeeid);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} /*else {
				result = (Boolean) logiwareResponse.getData();
			}*/

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getEmployeeById method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getEmployeeById method end. ");
		return logiwareResponse;
	}
	
	
	
	
	
	public LogiwareRespnse deleteEmployee(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker deleteEmployee method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + request.get("employeeId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteEmployee method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteEmployee method end. ");
		return logiwareResponse;
	}
	
	
	
	
	public LogiwareRespnse deleteCompany(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker deleteCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + request.get("companyId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteCompany method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteCompany method end. ");
		return logiwareResponse;
	}
	
	
	public LogiwareRespnse getAllTransportTypes(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker getAllTransportType method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllTransportType method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllTransportType method end. ");
		return logiwareResponse;
	}
	
	
	
	
	public LogiwareRespnse saveTransportType(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker saveTransportType method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportType"));
			ClientResponse<LogiwareRespnse> response = clientRequest
					.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception In ServiceInvoker saveTransportType method.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveTransportType method end. ");
		return logiwareResponse;
	}
	
	
	
	/*
	 *get TransportType By Id
	 */
	public LogiwareRespnse getTransportTypeById(String url,	Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker gettransportTypeById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			
			Integer transportTypeId= (Integer)request.get("transportTypeId");
			ClientRequest clientRequest = new ClientRequest(url+ WebAppConstants.URL_SEPERATOR + transportTypeId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} /*else {
				result = (Boolean) logiwareResponse.getData();
			}*/

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker gettransportTypeById method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker gettransportTypeById method end. ");
		return logiwareResponse;
	}
	
	
	
	public LogiwareRespnse deleteTransportType(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker deleteTransportType method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + request.get("transportTypeId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteTransportType method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteTransportType method end. ");
		return logiwareResponse;
	}
	
	
	
	public LogiwareRespnse getAllTransportTypeDetails(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker getAllTransportTypeDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllTransportTypeDetails method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllTransportTypeDetails method end. ");
		return logiwareResponse;
	}
	
	
	public LogiwareRespnse saveTransportTypeDetails(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker saveTransportTypeDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportTypeDtlDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest
					.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception In ServiceInvoker saveTransportTypeDetails method.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveTransportTypeDetails method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse getTransportTypeDtlById(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker gettransportTypeDtlById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer transportTypeId = (Integer) request.get("transportTypeDtlId");
			ClientRequest clientRequest = new ClientRequest(url
					+ WebAppConstants.URL_SEPERATOR + transportTypeId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} /*
			 * else { result = (Boolean) logiwareResponse.getData(); }
			 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In ServiceInvoker gettransportTypeDtlById method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker gettransportTypeDtlById method end. ");
		return logiwareResponse;
	}



/*
 * Delete Transport Type Details
 * 
 */
	public LogiwareRespnse deleteTransportTypeDtl(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker deleteTransportTypeDtl method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + request.get("transportTypeDtlId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteTransportTypeDtl method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteTransportTypeDtl method end. ");
		return logiwareResponse;
	}

	
	/*
	 *Get Company By Id 
	 */
	public LogiwareRespnse getCompanyById(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker getCompanyById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			
			Integer companyId= (Integer)request.get("companyId");
			ClientRequest clientRequest = new ClientRequest(url+ WebAppConstants.URL_SEPERATOR + companyId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} /*else {
				result = (Boolean) logiwareResponse.getData();
			}*/

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getCompanyById method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getCompanyById method end. ");
		return logiwareResponse;
	}
	
	
	public LogiwareRespnse saveContractCompany(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker saveContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("contractCompDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest
					.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveContractCompany method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveContractCompany method end. ");
		return logiwareResponse;
	}
	
	
	
	public LogiwareRespnse getAllContractCompany(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In ServiceInvoker getAllContractCompany method end.",
					e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllContractCompany method end. ");
		return logiwareResponse;
	}
	
	
	/*
	 *Get Employee By Id 
	 */
	public LogiwareRespnse getContractCompanyById(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getContractCompanyById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			Integer contractCompanyId= (Integer)request.get("contractCompanyId");
			ClientRequest clientRequest = new ClientRequest(url+ WebAppConstants.URL_SEPERATOR + contractCompanyId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getContractCompanyById method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getContractCompanyById method end. ");
		return logiwareResponse;
	}

	
	public LogiwareRespnse deleteContractCompany(String url,
			Map<String, Object> request) throws LogiwareBaseException {
		
		logger.info("ServiceInvoker deleteContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + request.get("ContractcompanyId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest
					.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(),
						logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteContractCompany method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteContractCompany method end. ");
		return logiwareResponse;
	}
	
	
	
}