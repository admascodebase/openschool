package com.admas.logiware.controller.master;

import java.io.Serializable;
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
import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

public class TransportDetailsController extends BaseController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5376443190524292046L;

	public TransportDetailsController() {
	}

	Logger logger = LoggerFactory.getLogger(TransportDetailsController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@RequestMapping(value = "/getAllTransportDetails.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportDetails(HttpServletRequest request, HttpServletResponse response) {

		logger.info("TransportDetailsController: getAllTransportDetails Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllTransportDetails");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		
		try {
			Integer ownId=Integer.parseInt(request.getParameter("id"));
			reqDtoObjects.put("ownId", ownId);
			mv.addObject("ownId", ownId);
			resDtoObjects = masterServiceImpl.getAllTransportDetails(flowData,
					reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<TransportDetailsDto> lTransportDetails = (List<TransportDetailsDto>) resDtoObjects
					.get("lTransportDetails");
			mv.addObject("lTransportDetails", lTransportDetails);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: getAllTransportDetails", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In TransportDetailsController getAllTransportDetails Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportDetailsController: getAllTransportDetails Method End.");
		return mv;

	}
	
	@RequestMapping(value = "/showAddTransportDetails.htm", method = RequestMethod.GET)
	public ModelAndView showAddTransportDetails(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportDetailsController: showAddTransportDetails Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}	
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("showAddTransportDetails");
		try {
			TransportDetailsDto transportDetailsDto = new TransportDetailsDto();
			transportDetailsDto.setOwnId(Integer.parseInt(request.getParameter("ownId")));
			mv.addObject("TransportDetailsDto", transportDetailsDto);
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController: showAddTransportDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportDetailsController: showAddTransportDetails Method End.");
		return mv;
	}

	@RequestMapping(value = "/saveTransportDetails.htm", method = RequestMethod.POST)
	public ModelAndView saveTransportDetails(
			@ModelAttribute("TransportDetailsDto") TransportDetailsDto transportDetailsDto,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("TransportDetailsController: saveTransportDetails Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		transportDetailsDto.setDelFlag('N');
		ModelAndView mv = new ModelAndView("getAllTransportDetails");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage= "";
//		Integer transId = Integer.parseInt(request.getParameter("transId"));
		
		try {
			reqDtoObjects.put("transportDetailsDto", transportDetailsDto);
			Integer transOwnId = (Integer) Integer.parseInt(request.getParameter("ownId"));
//			Integer	transOwnId = transportDetailsDto.getOwnId();
			reqDtoObjects.put("ownId", transOwnId);
			if (transportDetailsDto.getId() != null && transportDetailsDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditTransportDetails(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = masterServiceImpl.saveTransportDetails(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: saveTransportDetails", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController saveTransportDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
					
		@SuppressWarnings("unchecked")
		List<TransportDetailsDto> lTransportDetailsDto = (List<TransportDetailsDto>) resDtoObjects
				.get("lTransportDetails");		
		mv.addObject("lTransportDetails", lTransportDetailsDto);		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("TransportDetailsController: saveTransportDetails Method End.");
		return mv;

	}

	@RequestMapping(value = "/editTransportDetails.htm", method = RequestMethod.GET)
	public ModelAndView editTransportDetails(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportDetailsController: editTransportDetails Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("getAllEmployee");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportDetailsId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("transportDetailsId", transportDetailsId);
			resDtoObjects = masterServiceImpl.getTransportDetailsById(flowData,
					reqDtoObjects, resDtoObjects);
			mv = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));
			mv.addObject("TransportDetailsDto", resDtoObjects.get("TransportDetailsDto"));			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: editTransportDetails",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController editTransportDetails Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportDetailsController: editTransportDetails Method End.");
		return mv;
	}

	@RequestMapping(value = "/deleteTransportDetails.htm", method = RequestMethod.GET)
	public ModelAndView deleteTransportDetails(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportDetailsController: deleteTransportDetails Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("getAllTransportDetails");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportDetailsId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("transportDetailsId", transportDetailsId);
			Integer transOwnId = (Integer)request.getAttribute("ownId");
			reqDtoObjects.put("ownId", transOwnId);
			resDtoObjects = masterServiceImpl.deleteTransportDetails(flowData,
					reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
			resDtoObjects = masterServiceImpl.getAllTransportDetails(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: deleteTransportDetails",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController deleteTransportDetails Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<TransportDetailsDto> lTransportDetailsDto = (List<TransportDetailsDto>) resDtoObjects
				.get("lTransportDetails");
		mv.addObject("lTransportDetails", lTransportDetailsDto);	
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("TransportDetailsController: deleteTransportDetails Method End.");
		return mv;
	}

	
}
