package com.admas.logiware.controller.master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.StateDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

public class CityController extends BaseController{
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(CityController.class);	

	/** The controller service. */	
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;
	
	
	@RequestMapping(value = "/getAllCity.htm", method = RequestMethod.GET)
	public ModelAndView getAllCity(HttpServletRequest request,
			HttpServletResponse response){

		logger.info("CityController: getAllCity Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllCities");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CityDto> lCities=(List<CityDto>) resDtoObjects.get("lCities");
			mv.addObject("lCities",lCities);			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CityController: getAllCity", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In CityController getAllCity Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CityController: getAllCity Method End.");
		return mv;

	}

	
	@RequestMapping(value = "/showAddCity.htm", method = RequestMethod.GET)
	public ModelAndView addCity(HttpServletRequest request, HttpServletResponse response) {		
		
		
		logger.info("CityController: addCity Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView mv = new ModelAndView("showAddCity");
		List<StateDto> lStates =  new ArrayList<StateDto>();
		try {
			resDtoObjects = masterServiceImpl.getAllStates(flowData, resDtoObjects, reqDtoObjects);
			lStates = (List<StateDto>) resDtoObjects.get("lStates");
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CityController: saveCompany", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In CityController: addCity Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		mv.addObject("cityDto", new CityDto());
		mv.addObject("lStates", lStates);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("MasterController: addCity Method End.");
		return mv;
	}		

	
	@RequestMapping(value="/saveCity.htm", method=RequestMethod.POST)
	public ModelAndView addCitySubmit(@ModelAttribute("cityDto")CityDto city, HttpServletRequest request, HttpServletResponse response){
		
		logger.info("CityController: saveCity Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		city.setCompId(Integer.parseInt(flowData
				.getSessionData(WebAppConstants.COMPID)));
		city.setDelFlag('N');
		ModelAndView mv = new ModelAndView("getAllCities");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage= "";
		try {
			reqDtoObjects.put("city", city);
			if (city.getId() != null && city.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditCity(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = masterServiceImpl.saveCity(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CityController: saveCompany", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In CityController saveCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
					
		@SuppressWarnings("unchecked")
		List<CityDto> lCities = (List<CityDto>) resDtoObjects.get("lCities");		
		mv.addObject("lCities", lCities);		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CityController: addCity Method End.");
		return mv;
		
	}
	
	
	@RequestMapping(value="/showEditCity.htm",method=RequestMethod.GET)
	public ModelAndView showEditCity(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("CityController: showEditCity Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllCities");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		List<StateDto> lStates =  new ArrayList<StateDto>();
		Integer cityId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("cityId", cityId);
			resDtoObjects = masterServiceImpl.getCityById(flowData,
					reqDtoObjects, resDtoObjects);
			mv = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));
			mv.addObject("cityDto", resDtoObjects.get("city"));
			resDtoObjects = masterServiceImpl.getAllStates(flowData, resDtoObjects, reqDtoObjects);
			lStates = (List<StateDto>) resDtoObjects.get("lStates");
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CityController: showEditCity",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In CityController showEditCity Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		mv.addObject("lStates", lStates);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		return mv;
		
		
	}
	
	
	@RequestMapping(value="/showDeleteCity.htm",method=RequestMethod.GET)
	public ModelAndView showDeleteCity(HttpServletRequest request, HttpServletResponse response){

		logger.info("CityController: deleteCity Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("getAllCities");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer cityId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("cityId", cityId);
			resDtoObjects = masterServiceImpl.deleteCity(flowData,
					reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CityController: deleteCity",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In CityController deleteCity Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<CityDto> lCities = (List<CityDto>) resDtoObjects
				.get("lCities");		
		mv.addObject("lCities", lCities);	
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("CityController: deleteCity Method End.");
		return mv;

	}
}
