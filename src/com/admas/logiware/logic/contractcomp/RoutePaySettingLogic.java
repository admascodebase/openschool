package com.admas.logiware.logic.contractcomp;

import java.util.List;

import com.admas.logiware.dto.RoutePaySettingDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;


public interface RoutePaySettingLogic {
	
	
	public List<RoutePaySettingDto> getAllRoutePaySetting(Integer routeId)throws LogiwareExceptionHandler;

	public RoutePaySettingDto getRoutePaySettingById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addRoutePaySetting(RoutePaySettingDto routePaySettingDto)throws LogiwareExceptionHandler;

	public Boolean editRoutePaySetting(RoutePaySettingDto routePaySettingDto)throws LogiwareExceptionHandler;

	public Boolean deleteRoutePaySetting(Integer id)throws LogiwareExceptionHandler;

	public RoutePaySettingDto getRoutePaySetting(Integer transportTypeId, Integer transportTypeDtlId,
			Integer compRouteId)throws LogiwareExceptionHandler;
	
}
