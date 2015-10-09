package com.admas.logiware.dao.contractcomp;

import java.util.List;

import com.admas.logiware.dto.RoutePaySettingDto;
import com.admas.logiware.exception.LogiwareExceptionHandler;
import com.admas.logiware.jpa.RoutePaySetting;


public interface RoutePaySettingDao {
	
	public List<RoutePaySetting> getAllRoutePaySetting(Integer routeId)throws LogiwareExceptionHandler;

	public RoutePaySetting getRoutePaySettingById(Integer id)throws LogiwareExceptionHandler;

	public Boolean addRoutePaySetting(RoutePaySettingDto routePaySettingDto)throws LogiwareExceptionHandler;

	public Boolean editRoutePaySetting(RoutePaySettingDto routePaySettingDto)throws LogiwareExceptionHandler;

	public Boolean deleteRoutePaySetting(Integer id)throws LogiwareExceptionHandler;
}
