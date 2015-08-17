package com.admas.logiware.sysadmin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.core.controller.BaseController;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.SysAdminServiceImpl;

public class MasterController extends BaseController{
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(SysAdminController.class);	

	/** The controller service. */	
	@Autowired
	@Qualifier("sysAdminServiceImpl")
	private SysAdminServiceImpl sysAdminServiceImpl;

	
	
	@RequestMapping(value = "/city.htm", method = RequestMethod.GET)
	public ModelAndView city(HttpServletRequest request,
			HttpServletResponse response){		
		
		/*logger.info("MasterController: City Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			resDtoObjects=sysAdminServiceImpl.city(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);
		
		} catch (Exception e) {
			logger.error(
					"Exception In PaymentController viewPaymentEntries --", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;*/
		
		
		logger.info("SysAdminController: getAllCustomer Method Start.");
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
			resDtoObjects=sysAdminServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject("city", resDtoObjects.get("city"));
		/*} catch (LogiwareBaseException _be) {
			logger.error("Exception in PaymentController: viewPaymentEntries",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());*/
		} catch (Exception e) {
			logger.error(
					"Exception In PaymentController viewPaymentEntries --", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
		
		
	}
	
	
	
	@RequestMapping(value = "/addCity.htm", method = RequestMethod.GET)
	public ModelAndView addCity(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("MasterController: addCity Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			resDtoObjects=sysAdminServiceImpl.addCity(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);
		
		} catch (Exception e) {
			logger.error(
					"Exception In PaymentController viewPaymentEntries --", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
	}
	
	
	
	
}
