/*
 * Copyright Currencies Direct Ltd 2013-2015. All rights reserved worldwide.
 * Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.
 */
package com.admas.logiware.client;

import java.io.Serializable;
import java.util.Map;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.logiware.client.ServiceEndPointConstants.ServiceName;
import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.ResponseDto;
import com.admas.logiware.dto.RestResponseUser;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.util.PropertyHandler;
import com.admas.logiware.util.ResourceHandler;


/**
 * The Class ServiceInvoker.
 */
/**
 * @author Hitesh S.
 * 
 */
@Component
@Qualifier("serviceInvoker")
public class ServiceInvoker implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);

	public <T, K> K invoke(ServiceName serviceName, T request)
			throws LogiwareBaseException {
		logger.info("ServiceInvoker:invoke method Start.");
		K response = null;
		String host = PropertyHandler.getProperty("banking.serivce.host");
		int port = Integer.parseInt(PropertyHandler
				.getProperty("banking.serivce.port"));
		String urlTemplate = PropertyHandler
				.getProperty("banking.serivce.url.template");

		String serviceEndPoint = ResourceHandler.instance()
				.getServiceEndPoints(serviceName.value());

		String url = String.format(urlTemplate, host, port, serviceEndPoint);
		switch (serviceName) {
		case login: {
			response = (K) login(url, (Map) request);
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
	public Boolean login(String url,Map<String, Object> request) throws LogiwareBaseException {
		logger.info("ServiceInvoker login method start. ");
		RestResponseUser restResponse = new RestResponseUser();
		try {
			String userName = (String) request.get("userName");
			String password = (String) request.get("password");
			ClientRequest clientRequest = new ClientRequest(url
					+ WebAppConstants.URL_SEPERATOR + userName
					+ WebAppConstants.URL_SEPERATOR + password);
			clientRequest.accept(WebAppConstants.APP_CONTENT_TYPE);
			ClientResponse<ResponseDto> response = clientRequest
					.get(ResponseDto.class);
			if (response.getStatus() != 200) {
				throw new LogiwareBaseException(response.getStatus() + "",
						response.getStatus() + "");
			}
			///restResponse = response.getEntity();
			if (!restResponse.getResponseStatusHeader().getCode()
					.equals("0000")) {
				throw new LogiwareBaseException(restResponse
						.getResponseStatusHeader().getCode(), restResponse
						.getResponseStatusHeader().getDescription());
			}

		} catch (LogiwareBaseException b) {
			throw b;
		} catch (Exception e) {
			logger.error("Exception In ServiceInvoker login method end.", e);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST
							.getErrorDescription());
		}
		logger.info("ServiceInvoker login method end. ");
		return true;
	}

	
}