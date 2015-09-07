/**
 * 
 */
package com.admas.logiware.usrmgt.service;

import java.util.HashMap;
import java.util.Map;

import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwareBaseException;

/**
 * @author Admas
 *
 */
public interface BranchService {

	
	Map<String,Object> getAllBranch(FlowData flowData, Map<String, Object> reqDtoObjects, Map<String, Object> resDtoObjects)throws LogiwareBaseException;

	Map<String, Object> saveEditCompanyBranch(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects)throws LogiwareBaseException;

	Map<String, Object> saveCompanyBranch(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects)throws LogiwareBaseException;

	Map<String, Object> getCompanyBranchById(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects)throws LogiwareBaseException;

	Map<String, Object> deleteCompanyBranch(FlowData flowData,
			HashMap<String, Object> reqDtoObjects,
			Map<String, Object> resDtoObjects)throws LogiwareBaseException;
}
