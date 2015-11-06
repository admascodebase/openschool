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
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

/**
 * @author Admas Technologies
 * 
 */
public class TransportTypeController extends BaseController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(TransportTypeController.class);

	/** The controller service. */
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@RequestMapping(value = "/getAllTransportTypes.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportTypes(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportTypeController: getAllTransportTypes() Method Start.");
		
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllTransportTypes");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData,
					reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects
					.get("lTransports");
			mv.addObject("lTransports", lTransports);

		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: getAllTransportTypes", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In CompanyController getAllTransportTypes Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		return mv;

	}

	@RequestMapping(value = "/showAddTransportType.htm", method = RequestMethod.GET)
	public ModelAndView showAddTransportType(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportTypeController: showAddTransportType() Method Start.");

		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("showAddTranceportType");
		try {
			mv.addObject("transportType", new TransportTypeDto());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController showAddTransportType --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportTypeController: addTransportType() Method End.");
		return mv;
	}

	@RequestMapping(value = "/saveTransportType.htm", method = RequestMethod.POST)
	public ModelAndView saveTransportType(
			@ModelAttribute("transportType") TransportTypeDto transportType,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("TransportTypeController: saveTransportType() Method Start.");		
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);		
		
		ModelAndView mv = new ModelAndView("getAllTransportTypes");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();		
		String sucessMessage= "";
		try {			
			reqDtoObjects.put("transportType", transportType);
			if (transportType.getId() != null && transportType.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditTransportType(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				transportType.setCompId(Integer.parseInt(flowData
						.getSessionData(WebAppConstants.COMPID)));
				transportType.setDelFlag('N');
				resDtoObjects = masterServiceImpl.saveTransportType(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		}catch (LogiwareBaseException _be) {
				logger.error("Exception in TransportTypeController: saveTransportType",
						_be);
				mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
			
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController saveTransportType --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransports", lTransports);
		logger.info("TransportTypeController: saveTransportType() Method End.");
		return mv;
	}

	@RequestMapping(value = "/editTransportType.htm", method = RequestMethod.GET)
	public ModelAndView editTransportType(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("TransportTypeController: editTransportType Method Start.");
		FlowData flowData = null;
		ModelAndView mv = new ModelAndView("showAddTranceportType") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		TransportTypeDto transportTypeDto = null;
		Integer transportTypeId=Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("transportTypeId", transportTypeId);
			resDtoObjects=masterServiceImpl.gettransportTypeById(flowData, reqDtoObjects, resDtoObjects);
			transportTypeDto=(TransportTypeDto) resDtoObjects.get("transportType");
			mv.addObject("transportType",transportTypeDto);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportTypeController: showEditTransportType",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController showEditTransportType Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		return mv;
	}
	
	
	@RequestMapping(value="/deleteTransportType.htm",method=RequestMethod.GET)
	public ModelAndView deleteTransportType(HttpServletRequest request,HttpServletResponse response){
		
		logger.info("TransportTypeController: showDeleteTransportType Method Start.");

		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("getAllTransportTypes") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportTypeId=Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("transportTypeId", transportTypeId);
			resDtoObjects = masterServiceImpl.deleteTransportType(flowData, reqDtoObjects, resDtoObjects);			
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportTypeController: showDeleteTransportType",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController showDeleteTransportType Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects
				.get("lTransports");
		mv.addObject("lTransports", lTransports);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		return mv;
		
	}

	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllTransportTypeDetails.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportTypeDetails(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("transportTypeDto")TransportTypeDtlDto transportTypeDtlDto) throws LogiwareBaseException {

		logger.info("TransportTypeController: getAllTransportTypeDetails() Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("getAllTransportTypeDetails");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportTypeId = 0;
		Integer flag=0;
		TransportTypeDtlDto transportTypeDtlDto2 = new TransportTypeDtlDto();
		try {
			if(transportTypeDtlDto.getTransId()==null){
				transportTypeId=Integer.parseInt(request.getParameter("id"));
			}
			else{
				transportTypeId = transportTypeDtlDto.getTransId();
			}
			transportTypeDtlDto2.setTransId(transportTypeId);
			reqDtoObjects.put("transId", transportTypeId);
			mv.addObject("transId", transportTypeId);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportTypeController: getAllTransportTypeDetails",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
			try {
				resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);	
			} catch (Exception e) {
				logger.error("Exception in TransportTypeController: getAllTransportTypeDetails",_be);
				mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
				flag=1;
			}
			if(flag==1)
			mv.addObject(WebAppConstants.ERROR_CODE, "LW-MM-0009");
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController getAllTransportTypeDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
		}
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects
				.get("lTransports");
		mv.addObject("lTransports", lTransports);
		List<TransportTypeDtlDto> lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects
				.get("lTransportTypeDtls");
		mv.addObject("transportTypeDtlDto", transportTypeDtlDto2);
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		return mv;

	}
	
	
	@RequestMapping(value = "/showAddTransportTypeDetails.htm", method = RequestMethod.GET)
	public ModelAndView addTransportTypeDetails(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("TransportTypeController: addTransportTypeDetails Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("showAddTranceportTypeDetails") ;
		Integer trnasportTypeId = Integer.parseInt(request.getParameter("transId"));
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		TransportTypeDto transportTypeDto = null;
		try {
			TransportTypeDtlDto transportTypeDtlDto = new TransportTypeDtlDto();
			transportTypeDtlDto.setTransId(trnasportTypeId);
			reqDtoObjects.put("transportTypeId", trnasportTypeId);
		resDtoObjects = masterServiceImpl.gettransportTypeById(flowData, reqDtoObjects, resDtoObjects);
		transportTypeDto = (TransportTypeDto) resDtoObjects.get("transportType");
		
			mv.addObject("transportTypeDetails",transportTypeDtlDto);
		} catch (Exception e) {
			logger.error("Exception In TransportTypeController: addTransportTypeDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
			mv.addObject(WebAppConstants.ERROR_CODE, "LW-MM-0010");
			mv.setViewName("getAllTransportTypeDetails");
			mv.addObject("'transportTypeDtlDto", new TransportTypeDtlDto());
		}
		if(transportTypeDto!=null)
		mv.addObject("transportTypeName", transportTypeDto.getName());
		return mv;
}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/saveTransportTypeDetails.htm", method=RequestMethod.POST)
	public ModelAndView saveTransportTypeDetails(@ModelAttribute("transportTypeDetails")TransportTypeDtlDto transportTypeDtlDto, HttpServletRequest request, HttpServletResponse response){
		
		logger.info("TransportTypeController: saveTransportTypeDetails Method Start.");
		FlowData flowData = null;
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
		flowData = (FlowData) request.getSession().getAttribute(
				WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		transportTypeDtlDto.setDelFlag('N');
		ModelAndView mv = new ModelAndView("showAddTranceportTypeDetails") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		TransportTypeDtlDto transportTypeDtlDto2 = new TransportTypeDtlDto();
		Integer transId = 0;
		try {
			if(transportTypeDtlDto.getTransId()==null){
				transId = Integer.parseInt(request.getParameter("transId"));
			}else{
				transId = transportTypeDtlDto.getTransId();	
			}
			reqDtoObjects.put("transportTypeDtlDto", transportTypeDtlDto);
			reqDtoObjects.put("transId", transId);
			mv.addObject("transId", transId);
			transportTypeDtlDto2.setTransId(transId);
			String sucessMessage="";
			if (transportTypeDtlDto.getId() != null && transportTypeDtlDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditTransportTypeDtl(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects=masterServiceImpl.saveTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
		
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			
			mv.addObject(WebAppConstants.SUCESS_MESSAGE, sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportTypeController: saveTransportTypeDetails",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController saveTransportTypeDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransports", lTransports);
		mv.addObject("transportTypeDtlDto", transportTypeDtlDto2);
		List<TransportTypeDtlDto> lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);
		transportTypeDtlDto = new TransportTypeDtlDto();
		transportTypeDtlDto.setTransId(transId);
		mv.addObject("transportTypeDetails", transportTypeDtlDto);
		return mv;
		
		
	}
	
	
	/*
	 * Edit Transport Type Details
	 */
	
	@RequestMapping(value = "/showEditTransportTypeDetails.htm", method = RequestMethod.GET)
	public ModelAndView EditTransportTypeDetails(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("TransportTypeController: EditTransportTypeDetails Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportTypeDtlId=Integer.parseInt(request.getParameter("id"));
		try {			
			reqDtoObjects.put("transportTypeDtlId", transportTypeDtlId);
			resDtoObjects=masterServiceImpl.EditTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			resDtoObjects=masterServiceImpl.getTransportTypeDetailsById(flowData, reqDtoObjects, resDtoObjects);
			TransportTypeDtlDto transportTypeDtlDto=(TransportTypeDtlDto) resDtoObjects.get("transportTypeDetails");
			mv.addObject("transportTypeDetails",transportTypeDtlDto);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportTypeController: EditTransportTypeDetails",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController EditTransportTypeDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		return mv;
}
	
	/*
	 * Delete Transport Type Details
	 * 
	 * */
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/showDeleteTransportTypeDetails.htm", method = RequestMethod.GET)
	public ModelAndView deleteTransportTypeDetails(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("TransportTypeController: deleteTransportTypeDetails Method Start.");
		FlowData flowData = null;
		
		ModelAndView mv = new ModelAndView("getAllTransportTypeDetails") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportTypeDtlId=Integer.parseInt(request.getParameter("id")); 
		Integer transId = Integer.parseInt(request.getParameter("transId"));
		/*Integer transId = Integer.parseInt(request.getParameter("transId"));
		reqDtoObjects.put("transId", transId);*/
		String sucessMessage = "";
		TransportTypeDtlDto transportTypeDtlDto2 = new TransportTypeDtlDto();
		try {			
			reqDtoObjects.put("transportTypeDtlId", transportTypeDtlId);
			reqDtoObjects.put("transId", transId);
			mv.addObject("transId", transId);
			transportTypeDtlDto2.setTransId(transId);
			resDtoObjects = masterServiceImpl.deleteTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			sucessMessage= WebAppConstants.LW_SUCESS_DELETE;
			mv.addObject(WebAppConstants.SUCESS_MESSAGE, sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportTypeController: deleteTransportTypeDetails",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
			
		} catch (Exception e) {
			logger.error(
					"Exception In TransportTypeController deleteTransportTypeDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<TransportTypeDtlDto> lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects
				.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransports", lTransports);
		mv.addObject("transportTypeDtlDto", transportTypeDtlDto2);
		return mv;
}
	
}
