package com.admas.logiware.usrmgt.service;

import java.util.ArrayList;
import java.util.List;
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
import com.admas.logiware.dto.ProductDto;
import com.admas.logiware.dto.response.ProductResponse;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
@Component
public class ProductServiceImpl implements ProductService {
	
	Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	@Qualifier("serviceInvoker")
	private ServiceInvoker serviceInvoker;

	public ProductServiceImpl() {
	}

	public ServiceInvoker getServiceInvoker() {
		return serviceInvoker;
	}

	public void setServiceInvoker(ServiceInvoker serviceInvoker) {
		this.serviceInvoker = serviceInvoker;
	}

	protected <T, K> K doServiceCall(FlowData flowData,
			ServiceName serviceName, T request) throws LogiwareBaseException {
		return serviceInvoker.invoke(serviceName, request);
	}
	
	@Override
	public Map<String, Object> getAllProduct(FlowData flowData, Map<String, Object> reqDtoObject,
			Map<String, Object> resDtoObject) throws LogiwareBaseException {
		logger.info("ProductServiceImpl getAllProduct method start.");
		List<ProductDto>lProducts = new ArrayList<ProductDto>();
		ProductResponse logiwareRespnse=null;
		try{
		logiwareRespnse = doServiceCall(flowData, ServiceName.getAllProduct, reqDtoObject);
		lProducts = logiwareRespnse.getlProductDto();
		resDtoObject.put("lProducts", lProducts);
		}
		catch(LogiwareBaseException baseException){
			throw baseException;
		}
		catch (Exception e) {
		}
		return resDtoObject;
	}

	@Override
	public Map<String, Object> saveProduct(FlowData flowData, Map<String, Object> reqDtoObject,
			Map<String, Object> resDtoObject) throws LogiwareBaseException {
		logger.info("ProductServiceImpl : saveProduct method start.");
		ProductResponse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData,
					ServiceName.addProduct, reqDtoObject);
			resDtoObject.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			resDtoObject = getAllProduct(flowData,
					reqDtoObject, resDtoObject);
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In ProductServiceImpl : saveProduct method end.",
					e);
			resDtoObject = getAllProduct(flowData, reqDtoObject, resDtoObject);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObject = getAllProduct(flowData,	reqDtoObject, resDtoObject);
		logger.info("ProductServiceImpl saveProduct method end. ");
		return resDtoObject;
	}

	@Override
	public Map<String, Object> getProductById(FlowData flowData, Map<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects) throws LogiwareBaseException {
		ProductResponse productResponse = null;
		String viewName = "addProduct";
		try{
			productResponse = doServiceCall(flowData,ServiceName.getProductById, reqDtoObjects);
			resDtoObjects.put("productResponse", productResponse.getProductDto());
			resDtoObjects.put(WebAppConstants.VIEW_NAME, viewName);
		}
		catch(LogiwareBaseException le){
			
		}

		return resDtoObjects;
	}

	@Override
	public Map<String, Object> editProduct(FlowData flowData, Map<String, Object> reqDtoObject,
			Map<String, Object> resDtoObject)throws LogiwareBaseException {
		logger.info("ProductServiceImpl : editProduct method start.");
		ProductResponse logiwareResponse = null;
		try {
			logiwareResponse = doServiceCall(flowData,
					ServiceName.editProduct, reqDtoObject);
			resDtoObject.put("userResponse", logiwareResponse);
		} catch (LogiwareBaseException b) {
			resDtoObject = getAllProduct(flowData,
					reqDtoObject, resDtoObject);
			throw b;
		} catch (Exception e) {
			logger.error(
					"Exception In ProductServiceImpl : saveProduct method end.",
					e);
			resDtoObject = getAllProduct(flowData, reqDtoObject, resDtoObject);
			throw new LogiwareBaseException(
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode(),
					LogiwarePortalErrors.INVALID_REQUEST.getErrorDescription());
		}
		resDtoObject = getAllProduct(flowData,	reqDtoObject, resDtoObject);
		logger.info("ProductServiceImpl editProduct method end. ");
		return resDtoObject;
	}

	@Override
	public Map<String, Object> deleteProduct(FlowData flowData, Map<String, Object> requestDtoObjects,
			Map<String, Object> responseDtoObjects) throws LogiwareBaseException {
		ProductResponse logiwareResponse = null;
		Boolean result = false;
		try{
			logiwareResponse = doServiceCall(flowData, ServiceName.deleteProduct, requestDtoObjects);
			result = logiwareResponse.getResult();
			responseDtoObjects.put("productResponse", result);
		}
		catch(LogiwareBaseException le){
			
		}
		
		return responseDtoObjects;
	}
}
