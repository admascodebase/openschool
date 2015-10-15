
package com.admas.logiware.controller.usrmgt;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.FlowData;
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
			return getPostLoginDtls(flowData, request);
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
			getPostLoginDtls(flowData, request);
		}

		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String userName = null,balance = "";
		try {
			userName = request.getParameter(WebAppConstants.USERNAME);
			String password = request.getParameter(WebAppConstants.PASSWORD);
			reqDtoObjects.put(WebAppConstants.USERNAME, userName);
			reqDtoObjects.put(WebAppConstants.PASSWORD, password);			
			resDtoObjects =userManagementServiceImpl.isValidUser(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			resDtoObjects = userManagementServiceImpl.getSmsBalance(flowData, reqDtoObjects, resDtoObjects);
			balance = (String) resDtoObjects.get("balance");
			mv=new ModelAndView(viewName);
			flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
			mv.addObject(WebAppConstants.USERNAME, flowData.getSessionData(WebAppConstants.USERNAME));
			flowData.setSessionData("balance", balance);
			mv.addObject("balance", balance);
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
	


	public ModelAndView getPostLoginDtls(FlowData flowData,
			HttpServletRequest request) {
		logger.info("LoginController:getPostLoginDtls start");
		ModelAndView mv = new ModelAndView("Enterprise_en_dashBoard");
		String viewName="";
		try {
			viewName = "Dashboard";
			mv=new ModelAndView(viewName);
			flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
			mv.addObject(WebAppConstants.USERNAME, flowData.getSessionData(WebAppConstants.USERNAME));
			mv.addObject("balance", flowData.getSessionData("balance"));
			return mv;
		} catch (Exception e) {
			logger.error("Exception in LoginController:getPostLoginDtls", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.INVALID_REQUEST.getErrorCode());
		}
		
		logger.info(LoginController.class.getName()
				+ ".inside user login controller END");
		
		return mv;
	}
	
	@RequestMapping(value = "/showUserProfile.htm", method = RequestMethod.GET)
	public ModelAndView showUserProfile(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("LoginController: addEmployee Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("showUserProfile");
		try {
			mv.addObject("user", flowData.getSessionDataObject(WebAppConstants.USER));			
		} catch (Exception e) {
			logger.error(
					"Exception In LoginController: showUserProfile Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		return mv;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("login");
		try {			
			HttpSession session = request.getSession();
			session.removeAttribute(WebAppConstants.FLOWDATA);
			session.invalidate();
		} catch (Exception e) {
			logger.error("Exception in LoginController:logout--->", e);
		}
		return mv;
	}
	
}