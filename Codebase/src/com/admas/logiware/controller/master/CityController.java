package com.admas.logiware.controller.master;

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
import com.admas.logiware.dto.State;
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
	public ModelAndView city(HttpServletRequest request,
			HttpServletResponse response){
		
		logger.info("CityController: city Method Start.");
		FlowData flowData = null;
		/*super.handleRequestInternal(request, response);
		FlowData flowData = null;
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
*/
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			resDtoObjects=masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<CityDto> lCities=(List<CityDto>) resDtoObjects.get("lCity");
			mv.addObject("lCities",lCities);
			@SuppressWarnings("unchecked")
			List<State> lState=(List<State>) resDtoObjects.get("lState");
			mv.addObject("lState",lState);
//			mv.addObject(viewName);
			
		/*} catch (LogiwareBaseException _be) {
			logger.error("Exception in PaymentController: viewPaymentEntries",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());*/
		} catch (Exception e) {
			logger.error(
					"Exception In CityController  --", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
		
		
	}
	
	
	
	@RequestMapping(value = "/showAddCity.htm", method = RequestMethod.GET)
	public ModelAndView addCity(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("MasterController: addCity Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			
			resDtoObjects=masterServiceImpl.showAddCity(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			mv.addObject("city",new CityDto());
		} catch (Exception e) {
			logger.error(
					"Exception In PaymentController viewPaymentEntries --", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
	}
	
	@RequestMapping(value="/saveCity.htm", method=RequestMethod.POST)
	public ModelAndView addCitySubmit(@ModelAttribute("city")CityDto city, HttpServletRequest request, HttpServletResponse response){
		logger.info("MasterController: addCity Method Start.");
		FlowData flowData = null;
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {	
			System.out.println(city);
			reqDtoObjects.put("city", city);
			resDtoObjects=masterServiceImpl.saveCity(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);		
			@SuppressWarnings("unchecked")
			List<CityDto> lCities=(List<CityDto>) resDtoObjects.get("lCity");
			mv.addObject("lCities",lCities);
		} catch (Exception e) {
			logger.error(
					"Exception In PaymentController viewPaymentEntries --", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="/showEditCity.htm",method=RequestMethod.GET)
	public ModelAndView editCity(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("cityController: editCity Method Start.");
		FlowData flowData = null;
		ModelAndView modelView = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try{
			System.out.println(request.getParameter("id"));
			logger.info("*******************"+request.getParameter("id"));
			resDtoObjects=masterServiceImpl.showEditCity(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			modelView=new ModelAndView(viewName);
			modelView.addObject("city",resDtoObjects.get("city"));
		} catch (Exception e) {
			logger.error(
					"Exception In PaymentController viewPaymentEntries --", e);
			modelView.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return modelView;
	}
	
	
	@RequestMapping(value="/showDeleteCity.htm",method=RequestMethod.GET)
	public ModelAndView showDeleteCity(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("cityController: editCity Method Start.");
		FlowData flowData = null;
		ModelAndView modelView = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try{
			System.out.println(request.getParameter("id"));
			logger.info("*******************"+request.getParameter("id"));
			resDtoObjects=masterServiceImpl.showDeleteCity(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			modelView=new ModelAndView(viewName);
			modelView.addObject("city",resDtoObjects.get("city"));
		} catch (Exception e) {
			logger.error(
					"Exception In PaymentController viewPaymentEntries --", e);
			modelView.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return modelView;
	}
	
	
	
	
}
