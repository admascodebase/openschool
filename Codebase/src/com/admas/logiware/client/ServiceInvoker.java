
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
import com.admas.logiware.dto.ContractCompDto;
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
	public <T, K> K invoke(ServiceName serviceName, T request) throws LogiwareBaseException {
		logger.info("ServiceInvoker:invoke method Start.");
		K response = null;
		String host = PropertyHandler.getProperty("logiware.serivce.host");
		int port = Integer.parseInt(PropertyHandler.getProperty("logiware.serivce.port"));
		String urlTemplate = PropertyHandler.getProperty("logiware.serivce.url.template");
		logger.info("**************" + serviceName.value());
		String serviceEndPoint = ResourceHandler.instance().getServiceEndPoints(serviceName.value());

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

		case saveEditEmployee: {
			response = (K) saveEditEmployee(url, (Map) request);
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
		case saveEditTransportType: {
			response = (K) saveEditTransportType(url, (Map) request);
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

		case saveEditContractCompany: {
			response = (K) saveEditContractCompany(url, (Map) request);
			break;
		}

		case getAllBranch: {
			response = (K) getAllBranch(url, (Map) request);
			break;
		}
		
		case saveEditCompany: {
			response = (K) saveEditCompany(url, (Map) request);
			break;
		}
		
		case saveEditCompanyBranch: {
			response = (K) saveEditCompanyBranch(url, (Map) request);
			break;
		}
		
		case saveCompanyBranch: {
			response = (K) saveCompanyBranch(url, (Map) request);
			break;
		}
		
		case getCompanyBranchById: {
			response = (K) getCompanyBranchById(url, (Map) request);
			break;
		}
		
		case deleteCompanyBranch: {
			response = (K) deleteCompanyBranch(url, (Map) request);
			break;
		}
		
		case getAllCity: {
			response = (K) getAllCity(url, (Map) request);
			break;
		}
		
		case saveEditCity: {
			response = (K) saveEditCity(url, (Map) request);
			break;
		}
		
		case saveCity: {
			response = (K) saveCity(url, (Map) request);
			break;
		}
		
		case deleteCity: {
			response = (K) deleteCity(url, (Map) request);
			break;
		}
		
		case getCityById: {
			response = (K) getCityById(url, (Map) request);
			break;
		}
		
		case getAllStates: {
			response = (K) getAllStates(url, (Map) request);
			break;
		}
		
		case getSettingByType: {
			response = (K) getSettingByType(url, (Map) request);
			break;
		}
		
		case sendSmsToContractCompany: {
			response = (K) sendSmsToContractCompany(url, (Map) request);
			break;
		}
		
		case getAllTransportOwners: {
			response = (K) getAllTransportOwners(url, (Map) request);
			break;
		}
		
		case getTransportOwnerById: {
			response = (K) getTransportOwnerById(url, (Map) request);
			break;
		}
		
		case saveTransportOwner: {
			response = (K) saveTransportOwner(url, (Map) request);
			break;
		}
		
		case saveEditTransportOwner: {
			response = (K) saveTransportOwner(url, (Map) request);
			break;
		}
		
		case deleteTransportOwner: {
			response = (K) deleteTransportOwner(url, (Map) request);
			break;
		}
		
		case getAllTransportDetails: {
			response = (K) getAllTransportDetails(url, (Map) request);
			break;
		}
		
		case getTransportDetailsById: {
			response = (K) getTransportDetailsById(url, (Map) request);
			break;
		}
		
		case saveTransportDetails: {
			response = (K) saveTransportDetails(url, (Map) request);
			break;
		}
		
		case saveEditTransportDetails: {
			response = (K) saveEditTransportDetails(url, (Map) request);
			break;
		}
		
		case deleteTransportDetails: {
			response = (K) deleteTransportDetails(url, (Map) request);
			break;
		}
		
		case getSmsBalance: {
			response = (K) getSmsBalance(url, (Map) request);
			break;
		}
		
		case saveEditTransportTypeDtl: {
			response = (K) saveEditTransportTypeDtl(url, (Map) request);
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
	public LogiwareRespnse login(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker login method start. ");
		LogiwareRespnse logiwareResponse = null;
		try {
			String userName = (String) request.get("userName");
			String password = (String) request.get("password");
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + userName + WebAppConstants.URL_SEPERATOR + password);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);

			// In case of post request we have to writethe code like

			/*
			 * clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, queryPojo);
			 * ClientResponse<LogiwareRespnse> response = clientRequest
			 * .post(LogiwareRespnse.class);
			 */

			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker login method end. ");
		return logiwareResponse;
	}

	public Customer getAllCustomer(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker login method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		Customer customer = new Customer();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			// /restResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker login method end. ");
		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<CompanyDto> getAllCompany(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		List<CompanyDto> lCompanies = new ArrayList<CompanyDto>();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} else {
				lCompanies = (List<CompanyDto>) logiwareResponse.getData();
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllCompany method end. ");
		return lCompanies;
	}

	public LogiwareRespnse saveCompany(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("company"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
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
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} /*
				 * else { lCompanies = (List<CompanyDto>)
				 * logiwareResponse.getData(); }
				 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllEmployee method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllEmployee method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveEmployee(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveemployee method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("employee"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} /*
				 * else { result = (Boolean) logiwareResponse.getData(); }
				 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllCompany method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveEditEmployee(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditEmployee method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("employee"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditEmployee method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditEmployee method end. ");
		return logiwareResponse;
	}

	/*
	 * Get Employee By Id
	 */
	public LogiwareRespnse getEmployeeById(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getEmployeeById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer Employeeid = (Integer) request.get("employeeId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + Employeeid);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} /*
				 * else { result = (Boolean) logiwareResponse.getData(); }
				 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getEmployeeById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getEmployeeById method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse deleteEmployee(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteEmployee method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("employeeId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteEmployee method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteEmployee method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse deleteCompany(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("companyId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteCompany method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse getAllTransportTypes(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getAllTransportType method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllTransportType method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllTransportType method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveTransportType(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveTransportType method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportType"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception In ServiceInvoker saveTransportType method.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveTransportType method end. ");
		return logiwareResponse;
	}
	
	public LogiwareRespnse saveEditTransportType(String url,
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
			logger.error("Exception In ServiceInvoker saveEditTransportType method.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditTransportType method end. ");
		return logiwareResponse;
	}
	/*
	 * get TransportType By Id
	 */
	public LogiwareRespnse getTransportTypeById(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker gettransportTypeById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer transportTypeId = (Integer) request.get("transportTypeId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + transportTypeId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} /*
				 * else { result = (Boolean) logiwareResponse.getData(); }
				 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker gettransportTypeById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker gettransportTypeById method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse deleteTransportType(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteTransportType method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("transportTypeId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteTransportType method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteTransportType method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse getAllTransportTypeDetails(String url, Map<String, Object> request)
			throws LogiwareBaseException {

		logger.info("ServiceInvoker getAllTransportTypeDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			Integer transportTypeId = Integer.parseInt(request.get("transId").toString());
			ClientRequest clientRequest = new ClientRequest(url+ WebAppConstants.URL_SEPERATOR +transportTypeId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllTransportTypeDetails method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllTransportTypeDetails method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveTransportTypeDetails(String url, Map<String, Object> request)
			throws LogiwareBaseException {

		logger.info("ServiceInvoker saveTransportTypeDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportTypeDtlDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception In ServiceInvoker saveTransportTypeDetails method.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveTransportTypeDetails method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse getTransportTypeDtlById(String url, Map<String, Object> request)
			throws LogiwareBaseException {
		logger.info("ServiceInvoker gettransportTypeDtlById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer transportTypeId = (Integer) request.get("transportTypeDtlId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + transportTypeId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} /*
				 * else { result = (Boolean) logiwareResponse.getData(); }
				 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker gettransportTypeDtlById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker gettransportTypeDtlById method end. ");
		return logiwareResponse;
	}

	/*
	 * Delete Transport Type Details
	 * 
	 */
	public LogiwareRespnse deleteTransportTypeDtl(String url, Map<String, Object> request)
			throws LogiwareBaseException {
		logger.info("ServiceInvoker deleteTransportTypeDtl method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("transportTypeDtlId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteTransportTypeDtl method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteTransportTypeDtl method end. ");
		return logiwareResponse;
	}

	/*
	 * Get Company By Id
	 */
	public LogiwareRespnse getCompanyById(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getCompanyById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer companyId = (Integer) request.get("companyId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + companyId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} /*
				 * else { result = (Boolean) logiwareResponse.getData(); }
				 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getCompanyById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getCompanyById method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveContractCompany(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("contractCompDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveContractCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveContractCompany method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse getAllContractCompany(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllContractCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllContractCompany method end. ");
		return logiwareResponse;
	}

	/*
	 * Get Employee By Id
	 */
	public LogiwareRespnse getContractCompanyById(String url, Map<String, Object> request)
			throws LogiwareBaseException {
		logger.info("ServiceInvoker getContractCompanyById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			Integer contractCompanyId = (Integer) request.get("contractCompanyId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + contractCompanyId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getContractCompanyById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getContractCompanyById method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse deleteContractCompany(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("ContractcompanyId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteContractCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteContractCompany method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveEditContractCompany(String url, Map<String, Object> request)
			throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("employee"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditContractCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditContractCompany method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse getAllBranch(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditContractCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditContractCompany method end. ");
		return logiwareResponse;
	}

	
	public LogiwareRespnse saveEditCompany(String url, Map<String, Object> request)
			throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("company"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditCompany method end. ");
		return logiwareResponse;
	}

	
	
	
	public LogiwareRespnse saveEditCompanyBranch(String url, Map<String, Object> request)
			throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditCompanyBranch method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("companyBranchDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditCompanyBranch method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditCompanyBranch method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveCompanyBranch(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveCompanyBranch method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("companyBranchDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} /*
				 * else { result = (Boolean) logiwareResponse.getData(); }
				 */

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveCompanyBranch method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveCompanyBranch method end. ");
		return logiwareResponse;
	}

	
	/*
	 * Get Company Branch By Id
	 */
	public LogiwareRespnse getCompanyBranchById(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getCompanyBranchById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer companyBranchId = (Integer) request.get("companyBranchId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + companyBranchId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getCompanyBranchById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getCompanyBranchById method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse deleteCompanyBranch(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteCompanyBranch method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("companyBranchId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteCompanyBranch method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteCompanyBranch method end. ");
		return logiwareResponse;
	}

	
	public LogiwareRespnse getAllCity(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllCity method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllCity method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllCity method end. ");
		return logiwareResponse;
	}


	
	public LogiwareRespnse saveEditCity(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditCity method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("city"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditCity method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditCity method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveCity(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveCity method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("city"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveCity method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveCity method end. ");
		return logiwareResponse;
	}

	
	public LogiwareRespnse deleteCity(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteCity method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("cityId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteCity method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteCity method end. ");
		return logiwareResponse;
	}


	/*
	 * Get City By Id
	 */
	public LogiwareRespnse getCityById(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getCityById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			Integer cityId = (Integer) request.get("cityId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + cityId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getCityById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getCityById method end. ");
		return logiwareResponse;
	}

	
	public LogiwareRespnse getAllStates(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllStates method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllStates method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllStates method end. ");
		return logiwareResponse;
	}

	

	/*
	 * Get Setting By Type
	 */
	public LogiwareRespnse getSettingByType(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getSettingByType method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer companyId = (Integer) request.get("compId");
			String typeValue = (String) request.get("typeValue");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + companyId + WebAppConstants.URL_SEPERATOR + typeValue);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
			
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getSettingByType method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getSettingByType method end. ");
		return logiwareResponse;
	}


	
	
	/*
	 * snd sms to contract company
	 */
	public LogiwareRespnse sendSmsToContractCompany(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker sendSmsToContractCompany method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			ContractCompDto company = (ContractCompDto) request.get("contractCompDto");
			
			String mobile = company.getContactNo1();
			String message="Yuor company registered in our company ";
			String route="4";
			String orgCode="1";//company.getName();
			
			ClientRequest clientRequest = new ClientRequest(url
					+ WebAppConstants.URL_SEPERATOR + mobile
					+ WebAppConstants.URL_SEPERATOR + message
					+ WebAppConstants.URL_SEPERATOR + route
					+ WebAppConstants.URL_SEPERATOR + orgCode);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
			
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker sendSmsToContractCompany method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker sendSmsToContractCompany method end. ");
		return logiwareResponse;
	}

	
	
	/**
	 *Transport Owner Services START. 
	 */
	
	public LogiwareRespnse getAllTransportOwners(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllTransportOwners method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllTransportOwners method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllTransportOwners method end. ");
		return logiwareResponse;
	}



	public LogiwareRespnse saveTransportOwner(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveTransportOwener method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportOwnerDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveTransportOwener method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveTransportOwener method end. ");
		return logiwareResponse;
	}


	public LogiwareRespnse saveEditTransportOwner(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditTransportOwener method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportOwner"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditTransportOwener method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditTransportOwener method end. ");
		return logiwareResponse;
	}

	
	public LogiwareRespnse getTransportOwnerById(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getTransportOwnerById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer transportOwnerId = (Integer) request.get("TransportOwnerId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + transportOwnerId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getTransportOwnerById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getTransportOwnerById method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse deleteTransportOwner(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteTransportOwner method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("transportOwnerId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteTransportOwner method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteTransportOwner method end. ");
		return logiwareResponse;
	}

	
	
	/**
	 *Transport Owner Services END. 
	 */
	
	
	/**
	 *Transport Details Services Start. 
	 */
	public LogiwareRespnse getAllTransportDetails(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getAllTransportDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			Integer ownerId = 1;
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + ownerId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getAllTransportDetails method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getAllTransportDetails method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveTransportDetails(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveTransportDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportDetailsDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveTransportDetails method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveTransportDetails method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse saveEditTransportDetails(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditTransportDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportDetailsDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditTransportDetails method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditTransportDetails method end. ");
		return logiwareResponse;
	}

	
	public LogiwareRespnse getTransportDetailsById(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker getTransportDetailsById method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {

			Integer transportDetailsId = (Integer) request.get("transportDetailsId");
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + transportDetailsId);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = (LogiwareRespnse) response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			} 
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getTransportDetailsById method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getTransportDetailsById method end. ");
		return logiwareResponse;
	}

	public LogiwareRespnse deleteTransportDetails(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker deleteTransportDetails method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + request.get("transportDetailsId"));
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker deleteTransportDetails method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker deleteTransportDetails method end. ");
		return logiwareResponse;
	}
	
	
	/**
	 *Transport Details Services End. 
	 */
	
	public LogiwareRespnse getSmsBalance(String url, Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker getSmsBalance method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		Integer route=4;
		try {
			ClientRequest clientRequest = new ClientRequest(url + WebAppConstants.URL_SEPERATOR + route);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<LogiwareRespnse> response = clientRequest.get(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker getSmsBalance method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker getSmsBalance method end. ");
		return logiwareResponse;
	}

	

	
	public LogiwareRespnse saveEditTransportTypeDtl(String url, Map<String, Object> request) throws LogiwareBaseException {

		logger.info("ServiceInvoker saveEditTransportTypeDtl method start. ");
		LogiwareRespnse logiwareResponse = new LogiwareRespnse();
		try {
			ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			clientRequest.body(WebAppConstants.APP_CONTENT_TYPE, request.get("transportTypeDtlDto"));
			ClientResponse<LogiwareRespnse> response = clientRequest.post(LogiwareRespnse.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			logiwareResponse = response.getEntity();
			if (!logiwareResponse.getCode().equals("0000")) {
				throw new LogiwareBaseException(logiwareResponse.getCode(), logiwareResponse.getDescription());
			}
		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker saveEditTransportTypeDtl method end.", e);
			throw new LogiwareBaseException(LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker saveEditTransportTypeDtl method end. ");
		return logiwareResponse;
	}

	
	
}