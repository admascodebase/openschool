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
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

public class CompanyController extends BaseController {

	public CompanyController() {
	}

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@RequestMapping(value = "/getAllCompany.htm", method = RequestMethod.GET)
	public ModelAndView getAllBranches(HttpServletRequest request,
			HttpServletResponse response) {

		/*
		 * FlowData flowData=null; //HashMap<String,Object>reqDtoObject = new
		 * HashMap<String, Object>(); HashMap<String,Object>resDtoObject = new
		 * HashMap<String, Object>();
		 * 
		 * return masterServiceImpl.getAllBranches(flowData, resDtoObject);
		 */

		logger.info("CityController: city Method Start.");
		FlowData flowData = null;
		/*
		 * super.handleRequestInternal(request, response); FlowData flowData =
		 * null; if (request.getSession().getAttribute(WebAppConstants.FLOWDATA)
		 * != null) { flowData = (FlowData) request.getSession().getAttribute(
		 * WebAppConstants.FLOWDATA); } if (!flowData.isLoggedIn()) return
		 * super.loginPage(flowData, request);
		 */
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = masterServiceImpl.getAllCompany(flowData,
					reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<CompanyDto> lCompanies = (List<CompanyDto>) resDtoObjects
					.get("lCompanies");
			mv.addObject("lCompanies", lCompanies);
			// mv.addObject(viewName);

			/*
			 * } catch (LogiwareBaseException _be) {
			 * logger.error("Exception in PaymentController: viewPaymentEntries"
			 * , _be); mv.addObject(WebAppConstants.ERROR_CODE,
			 * _be.getErrorCode());
			 */
		} catch (Exception e) {
			logger.error("Exception In CityController  --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS
							.getErrorCode());
		}

		return mv;

	}

	
	
	@RequestMapping(value = "/showAddCompany.htm", method = RequestMethod.GET)
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("CompanyController: addCompany Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			
			resDtoObjects=masterServiceImpl.showAddCompany(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			mv.addObject("company",new CompanyDto());
		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController addCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
}
	
	
	
	@RequestMapping(value="/saveCompany.htm", method=RequestMethod.POST)
	public ModelAndView saveCompany(@ModelAttribute("company") CompanyDto companyDto, HttpServletRequest request, HttpServletResponse response){
		
		logger.info("CompanyController: saveCompany Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {	
			reqDtoObjects.put("company", companyDto);
			resDtoObjects=masterServiceImpl.saveCompany(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			resDtoObjects=masterServiceImpl.getAllCompany(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CompanyDto> lCompanies = (List<CompanyDto>) resDtoObjects.get("lCompanies");
			mv=new ModelAndView(viewName);	
			mv.addObject("lCompanies", lCompanies);
		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController saveCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
		
		
	}
	
}
