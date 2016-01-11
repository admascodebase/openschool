
package com.admas.property.client;

import java.io.Serializable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.property.client.ServiceEndPointConstants.ServiceName;
import com.admas.property.dto.PocRespnse;
import com.admas.property.exception.PropertyBaseException;
import com.admas.property.exception.PropertyErrors;
import com.admas.property.util.PropertyHandler;
import com.admas.property.util.ResourceHandler;

/**
 * @author bnt soft
 * 
 */
@Component
@Qualifier("serviceInvoker")
public class ServiceInvoker implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T, K> K invoke(ServiceName serviceName, T request) throws PropertyBaseException {
		logger.info("ServiceInvoker:invoke method Start.");
		K response = null;
		String host = PropertyHandler.getProperty("poc.serivce.host");
		int port = Integer.parseInt(PropertyHandler.getProperty("poc.serivce.port"));
		String urlTemplate = PropertyHandler.getProperty("poc.serivce.url.template");
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
	 * @throws PropertyBaseException
	 */
	public PocRespnse login(String url, Map<String, Object> request) throws PropertyBaseException {
		logger.info("ServiceInvoker login method start. ");
		PocRespnse pocResponse = null;
		try {
			String userName = (String) request.get("userName");
			String password = (String) request.get("password");
		/*	ClientRequest clientRequest = new ClientRequest(
					url + WebAppConstants.URL_SEPERATOR + userName + WebAppConstants.URL_SEPERATOR + password);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<PocRespnse> response = clientRequest.get(PocRespnse.class);

			pocResponse = (PocRespnse) response.getEntity();
			if (!pocResponse.getCode().equals("0000")) {
				throw new PropertyBaseException(pocResponse.getCode(), pocResponse.getDescription());
			}

		} catch (PropertyBaseException b) {
			throw b;*/
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new PropertyBaseException(PropertyErrors.INVALID_REQUEST.getErrorCode(),
					PropertyErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker login method end. ");
		return pocResponse;
	}

	public String getAllCustomer(String url, Map<String, Object> request) throws PropertyBaseException {
		logger.info("ServiceInvoker login method start. ");
		PocRespnse pocResponse = new PocRespnse();
		try {
			/*ClientRequest clientRequest = new ClientRequest(url);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<PocRespnse> response = clientRequest.get(PocRespnse.class);
			if (response.getStatus() != 200) {
				throw new PropertyBaseException(response.getStatus() + "", response.getStatus() + "");
			}
			if (!pocResponse.getCode().equals("0000")) {
				throw new PropertyBaseException(pocResponse.getCode(), pocResponse.getDescription());
			}

		} catch (PropertyBaseException b) {
			throw b;*/
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new PropertyBaseException(PropertyErrors.INVALID_REQUEST.getErrorCode(),
					PropertyErrors.INVALID_REQUEST.getErrorDescription());
		}
		logger.info("ServiceInvoker login method end. ");
		return "";
	}
}