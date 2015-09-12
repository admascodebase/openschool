/**
 * 
 */
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
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.TransportOwnerDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

/**
 * @author AdmasTech
 *
 */
public class TransportOwnerController extends BaseController {
	
	public  TransportOwnerController() {
		
	}

	Logger logger = LoggerFactory.getLogger(TransportOwnerController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@RequestMapping(value = "/getAllTransportOwners.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportOwners(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportOwnerController: getAllTransportOwners Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllTransportOwners");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData,
					reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<TransportOwnerDto> lTransportOwners = (List<TransportOwnerDto>) resDtoObjects
					.get("lTransportOwners");
			mv.addObject("lTransportOwners", lTransportOwners);			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportOwnerController: getAllTransportOwners", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In TransportOwnerController getAllTransportOwners Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportOwnerController: getAllTransportOwners Method End.");
		return mv;

	}
	
	@RequestMapping(value = "/showAddTransportOwner.htm", method = RequestMethod.GET)
	public ModelAndView showAddTransportOwner(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportOwnerController: showAddTransportOwner Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("showAddTransportOwner");
		try {
			mv.addObject("transportOwner", new TransportOwnerDto());			
		} catch (Exception e) {
			logger.error(
					"Exception In TransportOwnerController: showAddTransportOwner Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportOwnerController: showAddTransportOwner Method End.");
		return mv;
	}

	
	
	@RequestMapping(value = "/saveTransportOwner.htm", method = RequestMethod.POST)
	public ModelAndView saveTransportOwner(
			@ModelAttribute("transportOwner") TransportOwnerDto transportOwnerDto,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("TransportOwnerController: saveTransportOwner Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		transportOwnerDto.setDelFlag('N');
		ModelAndView mv = new ModelAndView("getAllTransportOwner");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage= "";
		try {
			reqDtoObjects.put("transportOwnerDto", transportOwnerDto);
			if (transportOwnerDto.getId() != null && transportOwnerDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditTransportOwner(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = masterServiceImpl.saveTransportOwner(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportOwnerController: saveTransportOwner", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportOwnerController saveTransportOwner Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
					
		@SuppressWarnings("unchecked")
		List<TransportOwnerDto> lTransportOwners = (List<TransportOwnerDto>) resDtoObjects
				.get("lTransportOwners");		
		mv.addObject("lTransportOwners", lTransportOwners);		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportOwnerController: saveTransportOwner Method End.");
		return mv;

	}

	@RequestMapping(value = "/editTransportOwner.htm", method = RequestMethod.GET)
	public ModelAndView editTransportOwner(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportOwnerController: editTransportOwner Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllTransportOwners");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer TransportOwnerId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("TransportOwnerId", TransportOwnerId);
			resDtoObjects = masterServiceImpl.getTransportOwnerById(flowData,
					reqDtoObjects, resDtoObjects);
			mv = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));
			mv.addObject("transportOwner", resDtoObjects.get("transportOwner"));			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportOwnerController: editTransportOwner",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportOwnerController editTransportOwner Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportOwnerController: editTransportOwner Method End.");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteTransportOwner.htm", method = RequestMethod.GET)
	public ModelAndView deleteTransportOwner(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportOwnerController: deleteTransportOwner Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("getAllTransportOwners");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportOwnerId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("transportOwnerId", transportOwnerId);
			resDtoObjects = masterServiceImpl.deleteTransportOwner(flowData,
					reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportOwnerController: deleteTransportOwner",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportOwnerController deleteTransportOwner Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<TransportOwnerDto> lTransportOwners = (List<TransportOwnerDto>) resDtoObjects
				.get("lTransportOwners");		
		mv.addObject("lTransportOwners", lTransportOwners);	
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportOwnerController: deleteTransportOwner Method End.");
		return mv;
	}

	
}
