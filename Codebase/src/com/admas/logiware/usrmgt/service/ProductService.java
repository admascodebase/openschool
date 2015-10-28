/**
 * 
 */
package com.admas.logiware.usrmgt.service;

import java.util.Map;

import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwareBaseException;

/**
 * @author MAHESH
 *
 */
public interface ProductService {

	public Map<String, Object>getAllProduct(FlowData flowData, Map<String, Object> reqDtoObject, Map<String, Object>resDtoObject)throws LogiwareBaseException;
	public Map<String, Object>saveProduct(FlowData flowData, Map<String, Object> reqDtoObject, Map<String, Object>resDtoObject)throws LogiwareBaseException;
	public Map<String, Object> getProductById(FlowData flowData, Map<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects)throws LogiwareBaseException;
	public Map<String, Object> editProduct(FlowData flowData, Map<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects)throws LogiwareBaseException;
	public Map<String, Object> deleteProduct(FlowData flowData, Map<String, Object> requestDtoObjects,
			Map<String, Object> responseDtoObjects)throws LogiwareBaseException;
}
