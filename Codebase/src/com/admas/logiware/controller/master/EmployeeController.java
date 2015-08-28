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
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

public class EmployeeController extends BaseController{

	public EmployeeController() {
		
	}

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;
	
	@RequestMapping(value = "/getAllEmployee.htm", method = RequestMethod.GET)
	public ModelAndView getAllEmployee(HttpServletRequest request,
			HttpServletResponse response) {

		/*
		 * FlowData flowData=null; //HashMap<String,Object>reqDtoObject = new
		 * HashMap<String, Object>(); HashMap<String,Object>resDtoObject = new
		 * HashMap<String, Object>();
		 * 
		 * return masterServiceImpl.getAllBranches(flowData, resDtoObject);
		 */

		logger.info("EmployeeController: getAllEmployee Method Start.");
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
			resDtoObjects = masterServiceImpl.getAllEmployee(flowData,
					reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<EmployeeDto> lEmployees = (List<EmployeeDto>) resDtoObjects
					.get("lEmployees");
			mv.addObject("lEmployees", lEmployees);
			
			// mv.addObject(viewName);
			/*
			 * } catch (LogiwareBaseException _be) {
			 * logger.error("Exception in PaymentController: viewPaymentEntries"
			 * , _be); mv.addObject(WebAppConstants.ERROR_CODE,
			 * _be.getErrorCode());
			 */
		} catch (Exception e) {
			logger.error("Exception In EmployeeController  --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS
							.getErrorCode());
		}

		return mv;

	}
	
	
	
	@RequestMapping(value = "/showAddEmployee.htm", method = RequestMethod.GET)
	public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("EmployeeController: addEmployee Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			
			resDtoObjects=masterServiceImpl.showAddEmployee(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			mv.addObject("employee",new EmployeeDto());
		} catch (Exception e) {
			logger.error(
					"Exception In EmployeeController: addEmployee Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
}
	
	@RequestMapping(value="/saveEmployee.htm", method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee")EmployeeDto employeeDto, HttpServletRequest request, HttpServletResponse response){
		
		logger.info("CompanyController: saveCompany Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {	
			reqDtoObjects.put("employee", employeeDto);
			resDtoObjects=masterServiceImpl.saveEmployee(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			resDtoObjects=masterServiceImpl.getAllEmployee(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<EmployeeDto> lEmployees = (List<EmployeeDto>) resDtoObjects.get("lEmployees");
			mv=new ModelAndView(viewName);	
			mv.addObject("lEmployees", lEmployees);
		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController saveEmployee Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
		
		
	}
	
	@RequestMapping(value = "/showEditEmployee.htm", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("EmployeeController: editEmployee Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		EmployeeDto employeeDto=null;
		Integer employeeId=3;
		try {			
			reqDtoObjects.put("employeeId", employeeId);
			resDtoObjects=masterServiceImpl.showEditEmployee(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			resDtoObjects=masterServiceImpl.getEmployeeById(flowData, reqDtoObjects, resDtoObjects);
			employeeDto=(EmployeeDto) resDtoObjects.get("employee");
			mv.addObject("employee",employeeDto);
		} catch (Exception e) {
			logger.error(
					"Exception In EmployeeController: editEmployee Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.ERROR_WHILE_FETCHING_PAYMENT_MONITORING_RECORDS.getErrorCode());
		}
		
		return mv;
}
	

	
	
}
