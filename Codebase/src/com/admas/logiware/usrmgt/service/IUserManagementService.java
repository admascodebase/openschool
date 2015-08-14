/**
 * 
 */
package com.admas.logiware.usrmgt.service;

import java.util.Map;

import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.RestResponseUser;
import com.admas.logiware.exception.LogiwareBaseException;


/**
 * @author Raj Malekar
 *
 */
public interface IUserManagementService {
	
	public RestResponseUser isValidUser(FlowData flowData,
			Map<String, Object> reqDtoObjects, Map<String, Object> resDtoObjects)throws LogiwareBaseException ;

}
