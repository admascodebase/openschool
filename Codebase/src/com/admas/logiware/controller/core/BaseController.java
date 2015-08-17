
package com.admas.logiware.controller.core;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.dto.Customer;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.usrmgt.service.UserManagementServiceImpl;

/**
 * The Class BaseController.
 */

@Controller
public class BaseController extends AbstractController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	@Qualifier("userManagementServiceImpl")
	private UserManagementServiceImpl userManagementServiceImpl;


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session.getAttribute(WebAppConstants.FLOWDATA) != null) {
			FlowData flowData = (FlowData) session
					.getAttribute(WebAppConstants.FLOWDATA);
			if ("false".equals(flowData.getSessionData("ISLOGEDIN"))
					|| flowData.getSessionData("ISLOGEDIN") == null) {

				flowData.setSessionData("ISLOGEDIN", "false");
			}
			session.setAttribute(WebAppConstants.FLOWDATA, flowData);
		} else {
			FlowData flowData = new FlowData();

			try {
				session.setMaxInactiveInterval(50 * 60);
				session.setAttribute(WebAppConstants.FLOWDATA, flowData);
				flowData.setSessionData("ISLOGEDIN", "false");
			} catch (Exception e) {
				logger.error("Got error while setting count ", e);
			}

		}
		return null;
	}

	/**
	 * Gets the nsi.
	 * @return the nsi
	 */

	public ModelAndView loginPage(FlowData flowData, HttpServletRequest request) {
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		logger.info("started loginPage method ");
		ModelAndView modelRoot = null;
		try {			
			String viewName = "";

			resDtoObjects = userManagementServiceImpl.login(flowData,
					reqDtoObjects, resDtoObjects);
			viewName = (String) resDtoObjects.get(WebAppConstants.VIEW_NAME);
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
		} catch (Exception ex) {
			logger.error("Exception in loginPage()", ex);
			modelRoot = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));

			return modelRoot;
		}
	}


	
	private void printHeader(HttpServletRequest request) {
		String headers = null;
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			headers = (String) e.nextElement();
			if (headers != null) {
				logger.debug(headers + ":");
				logger.debug(request.getHeader(headers));
			}
		}
	}
	
	/**
	 * @return generated token
	 */
	public static String nextToken() {
		long seed = System.currentTimeMillis();
		Random r = new Random();
		r.setSeed(seed);
		String token = Long.toString(seed)
				+ Long.toString(Math.abs(r.nextLong()));
		// logger.debug(BaseController.class.getName() + ".nextToken :" +
		// token);
		return token;
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

	public ModelAndView loginSubmit(FlowData flowData,
			HttpServletRequest request) {

		
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "Dashboard";
			//userManagementServiceImpl.isValidUser(flowData, reqDtoObjects, resDtoObjects);*/
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in loginsubmit method"+ex);
		}
		
		
		return modelRoot;
	}

	public ModelAndView customer(FlowData flowData, HttpServletRequest request) {

		
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "customer";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in customer method"+ex);
		}
		
		return modelRoot;
	}

	public ModelAndView addCustomer(FlowData flowData,	HttpServletRequest request, Model model) {


		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {
//			Customer customer=new Customer();
//			model.addAttribute("custyomer",customer);
			String viewName = "AddCustomer";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			modelRoot.addObject(model);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		ex.printStackTrace();
		logger.info("exception in Add customer method"+ex);
		}
		
		return modelRoot;
	}

	public ModelAndView addCustomersubmit(FlowData flowData, HttpServletRequest request) {
		
		
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "customer";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in Add customer submit method"+ex);
		}
		
		return modelRoot;
	}

	public ModelAndView editCustomersubmit(FlowData flowData,
			HttpServletRequest request) {

		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "AddCustomer";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in edit customer submit method"+ex);
		}
		
		return modelRoot;
	}

	public ModelAndView deleteCustomersubmit(FlowData flowData,
			HttpServletRequest request) {

		
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "Customer";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in delete customer submit method"+ex);
		}
		
		return modelRoot;
	}

	public ModelAndView smssetting(FlowData flowData, HttpServletRequest request) {
		
		
		
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "SmsSetting";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in smssetting method"+ex);
		}
		
		return modelRoot;
		
	}

	public ModelAndView addSmssetting(FlowData flowData, HttpServletRequest request) {
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "addSmsSetting";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in smssetting method"+ex);
		}
		
		return modelRoot;
		
	}

	public ModelAndView editSmssetting(FlowData flowData,
			HttpServletRequest request) {

		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "addSmsSetting";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in edit smssetting method"+ex);
		}
		
		return modelRoot;
	}

	public ModelAndView deleteSmssetting(FlowData flowData,
			HttpServletRequest request) {
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "SmsSetting";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in delete smssetting method"+ex);
		}
		
		return modelRoot;
	}

	public ModelAndView addSmssettingSubmit(FlowData flowData,
			HttpServletRequest request) {

		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "SmsSetting";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in add submit smssetting method"+ex);
		}
		
		return modelRoot;
	
	}

	public ModelAndView pricePlan(FlowData flowData, HttpServletRequest request) {
		
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		ModelAndView modelRoot = null;
		try {			
			String viewName = "pricePlan";
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
			
		} catch (Exception ex) {
		
		logger.info("exception in add submit smssetting method"+ex);
		}
		
		return modelRoot;
	}
	
	
	
	

}