package com.admas.logiware.usrmgt.controller;

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
import com.admas.logiware.core.controller.BaseController;
import com.admas.logiware.dto.Customer;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.SmsSettings;
import com.admas.logiware.usrmgt.service.UserManagementServiceImpl;


public class LoginController extends BaseController {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(LoginController.class);	

	/** The controller service. */	
	@Autowired
	@Qualifier("userManagementServiceImpl")
	private UserManagementServiceImpl userManagementServiceImpl;

	
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
			return null;// getPostLoginDtls(flowData, request);
		}
	}

	
	@RequestMapping(value="/userLogin.htm", method=RequestMethod.POST)
	public ModelAndView loginSubmit(HttpServletRequest request, HttpServletResponse response){
		
		FlowData flowData=null;
//		logger.info("values====="+request.get)
		logger.info("****************************in login submit action****************************");
		return super.loginSubmit(flowData, request);
		
	}
	
	
	
	@RequestMapping(value="/Customer.htm", method=RequestMethod.GET)
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
	
	/*Sms Setting*/
	
	
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
	
	/**
	 * @return the userManagementServiceImpl
	 */
	public UserManagementServiceImpl getUserManagementServiceImpl() {
		return userManagementServiceImpl;
	}

	/**
	 * @param userManagementServiceImpl the userManagementServiceImpl to set
	 */
	public void setUserManagementServiceImpl(
			UserManagementServiceImpl userManagementServiceImpl) {
		this.userManagementServiceImpl = userManagementServiceImpl;
	}
	
	
	
}