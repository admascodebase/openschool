
package com.admas.logiware.controller.usrmgt;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.Customer;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.SmsSettings;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.UserManagementServiceImpl;


public class LoginController extends BaseController {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(LoginController.class);	

	/** The controller service. */	
	@Autowired
	@Qualifier("userManagementServiceImpl")
	private UserManagementServiceImpl userManagementServiceImpl;

	/**
	 * Etailer login.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the model and view
	 */
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		
		FlowData flowData = null;		
		logger.info(LoginController.class.getName()
				+ ".inside login controller START");
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}

		if (!flowData.isLoggedIn()) {
			return super.loginPage(flowData, request);
		} else {
			//return getPostLoginDtls(flowData, request);
			return null;
		}
	}

	
	@RequestMapping(value="/userLogin.htm", method=RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response){		

		logger.info(LoginController.class.getName()
				+ ".inside user login controller START");

		super.handleRequestInternal(request, response);
		FlowData flowData = null;
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}

		if (flowData.isLoggedIn()) {
			return null;//getPostLoginDtls(flowData, request);
		}

		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String userName = null;
		try {
			userName = request.getParameter(WebAppConstants.USERNAME);
			String password = request.getParameter(WebAppConstants.PASSWORD);
			reqDtoObjects.put(WebAppConstants.USERNAME, userName);
			reqDtoObjects.put(WebAppConstants.PASSWORD, password);			
			resDtoObjects =userManagementServiceImpl.isValidUser(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);
			mv.addAllObjects(resDtoObjects);
			flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
			mv.addObject("userDetails", resDtoObjects.get("userResponse"));	
			return mv;

		} catch (LogiwareBaseException we) {
			logger.error("Exception in LoginController:validateLogin", we);
			mv.addObject(WebAppConstants.ERROR_CODE, we.getErrorCode());
			mv.setViewName("login");
			
		} catch (Exception e) {
			logger.error("Exception in LoginController:validateLogin", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode());
		}
		
		logger.info(LoginController.class.getName()
				+ ".inside user login controller END");

		
		return mv;
		
	}
	
	
	
	/*@RequestMapping(value="/Customer.htm", method=RequestMethod.GET)
	public ModelAndView customer(HttpServletRequest request, HttpServletResponse response){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		logger.info("****************************in Customer action****************************");
		return super.customer(flowData, request);
		
	}
	
	
	
	
	@RequestMapping(value="/addCustomer.htm", method=RequestMethod.GET)
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response, Model model){
		
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		model.addAttribute("customer",new Customer());
		logger.info("****************************in Add Customer action****************************");
		return super.addCustomer(flowData, request, model);
		
	}
	
	
	
	@RequestMapping(value="/addCustomerSubmit.htm", method=RequestMethod.POST)
	public ModelAndView addCustomerSubmit(@ModelAttribute("customer") Customer customer, HttpServletRequest request, HttpServletResponse response){
		
		logger.info("***************customer data"+customer.getAddress()+"--"+customer.getCompanyName());
		logger.info(customer.toString());
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		logger.info("****************************in Add Customer action****************************");
		return super.addCustomersubmit(flowData, request);
		
	}
	
	
	@RequestMapping(value="/editCustomer.htm", method=RequestMethod.POST)
	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response){
		
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		logger.info("****************************in edit Customer action****************************");
		return super.editCustomersubmit(flowData, request);
		
	}
	
	
	
	@RequestMapping(value="/deleteCustomer.htm", method=RequestMethod.POST)
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		logger.info("****************************in edit Customer action****************************");
		return super.deleteCustomersubmit(flowData, request);
		
	}
	
	Sms Setting
	
	
	@RequestMapping(value="/smsSetting.htm", method=RequestMethod.GET)
	public ModelAndView smsSetting(HttpServletRequest request, HttpServletResponse response){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		logger.info("****************************in SMS Setting action****************************");
		return super.smssetting(flowData, request);
		
	}
	
	
	@RequestMapping(value="/addsmssetting.htm", method=RequestMethod.GET)
	public ModelAndView addSmsSetting(HttpServletRequest request, HttpServletResponse response,Model model){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		model.addAttribute("smssettings",new SmsSettings());
		logger.info("****************************in Add SMS Setting action****************************");
		return super.addSmssetting(flowData, request);
		
	}
	
	
	@RequestMapping(value="/addsmssettingsubmit.htm", method=RequestMethod.POST)
	public ModelAndView addSmsSettingSubmit(@ModelAttribute("smssettings")SmsSettings smsSettings, HttpServletRequest request, HttpServletResponse response,Model model){
		
		FlowData flowData=null;
		logger.info("***********smsSettings"+smsSettings.toString());
		model.addAttribute("smssettings",new SmsSettings());
		logger.info("****************************in Add SMS submit Setting action****************************");
		return super.addSmssettingSubmit(flowData, request);
		
	}
	
	
	@RequestMapping(value="/editSmsSetting.htm", method=RequestMethod.GET)
	public ModelAndView editSmsSetting(HttpServletRequest request, HttpServletResponse response,Model model){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		model.addAttribute("smssettings",new SmsSettings());
		logger.info("****************************in edit SMS Setting action****************************");
		return super.editSmssetting(flowData, request);
		
	}
	
	@RequestMapping(value="/deleteSmsSetting.htm", method=RequestMethod.GET)
	public ModelAndView deleteSmsSetting(HttpServletRequest request, HttpServletResponse response,Model model){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		model.addAttribute("smssettings",new SmsSettings());
		logger.info("****************************in delete SMS Setting action****************************");
		return super.deleteSmssetting(flowData, request);
		
	}
	
	
	@RequestMapping(value="./pricePlan", method=RequestMethod.GET)
	public ModelAndView pricePlan(HttpServletRequest request, HttpServletResponse response,Model model){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		model.addAttribute("smssettings",new SmsSettings());
		logger.info("****************************in Price Action action****************************");
		return super.pricePlan(flowData, request);
		
	}
	
	*//**
	 * @return the userManagementServiceImpl
	 *//*
	public UserManagementServiceImpl getUserManagementServiceImpl() {
		return userManagementServiceImpl;
	}

	*//**
	 * @param userManagementServiceImpl the userManagementServiceImpl to set
	 *//*
	public void setUserManagementServiceImpl(
			UserManagementServiceImpl userManagementServiceImpl) {
		this.userManagementServiceImpl = userManagementServiceImpl;
	}*/
	
	
	
}