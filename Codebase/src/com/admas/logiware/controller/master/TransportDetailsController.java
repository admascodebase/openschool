package com.admas.logiware.controller.master;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.xml.TransformSupport;
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
import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllTransportDetails.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportDetails(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("transportDetailsDto")TransportDetailsDto transportDetailsDto) throws LogiwareBaseException {

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
		Integer ownId = 0;
		TransportDetailsDto transportDetailsDto2 = new TransportDetailsDto();
		Integer flag=0;
		try {
			if(transportDetailsDto.getOwnId()==null){
				ownId=Integer.parseInt(request.getParameter("id"));
			}
			else{
				ownId = transportDetailsDto.getOwnId();
			}
			transportDetailsDto2.setOwnId(ownId);
//			Integer ownId=Integer.parseInt(request.getParameter("id"));
			reqDtoObjects.put("ownId", ownId);
			mv.addObject("ownId", ownId);
			resDtoObjects = masterServiceImpl.getAllTransportDetails(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			try {
				resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);	
			} catch (Exception e) {
				logger.error("Exception in TransportDetailsController: getAllTransportDetails", _be);
				mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
				flag=1;
			}
			logger.error("Exception in TransportDetailsController: getAllTransportDetails", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
			if(flag==1)
				mv.addObject(WebAppConstants.ERROR_CODE, "LW-TD-0002");
			
		} catch (Exception e) {
			logger.error("Exception In TransportDetailsController getAllTransportDetails Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
		}
		mv.addObject("transportDetailsDto", transportDetailsDto2);
		List<LoweryOwnerDto> lTransportOwners = (List<LoweryOwnerDto>) resDtoObjects.get("lTransportOwners");
		mv.addObject("lTransportOwners", lTransportOwners);	
		
		List<TransportDetailsDto> lTransportDetails = (List<TransportDetailsDto>) resDtoObjects.get("lTransportDetails");
		mv.addObject("lTransportDetails", lTransportDetails);
		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportDetailsController: getAllTransportDetails Method End.");
		return mv;

	}
	
	@SuppressWarnings("unchecked")
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
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			TransportDetailsDto transportDetailsDto = new TransportDetailsDto();
			transportDetailsDto.setOwnId(Integer.parseInt(request.getParameter("ownId")));
			mv.addObject("TransportDetailsDto", transportDetailsDto);
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			
//			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController: showAddTransportDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<TransportTypeDto> lTransportTypeDtos = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransportTypeDtos", lTransportTypeDtos);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportDetailsController: showAddTransportDetails Method End.");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveTransportDetails.htm", method = RequestMethod.POST)
	public ModelAndView saveTransportDetails(
			@ModelAttribute("TransportDetailsDto") TransportDetailsDto transportDetailsDto,
			HttpServletRequest request, HttpServletResponse response) throws LogiwareBaseException {
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
		TransportDetailsDto transportDetailsDto2 = new TransportDetailsDto();
		try {
			reqDtoObjects.put("transportDetailsDto", transportDetailsDto);
			Integer transOwnId = (Integer) Integer.parseInt(request.getParameter("ownId"));
//			Integer	transOwnId = transportDetailsDto.getOwnId();
			reqDtoObjects.put("ownId", transOwnId);
			mv.addObject("ownId", transOwnId);
			
			if (transportDetailsDto.getId() != null && transportDetailsDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditTransportDetails(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = masterServiceImpl.saveTransportDetails(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			transportDetailsDto2.setOwnId(transOwnId);
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: saveTransportDetails", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController saveTransportDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
		}
		
		mv.addObject("transportDetailsDto", transportDetailsDto2);
		List<LoweryOwnerDto> lTransportOwners = (List<LoweryOwnerDto>) resDtoObjects.get("lTransportOwners");
		mv.addObject("lTransportOwners", lTransportOwners);	
					
		List<TransportDetailsDto> lTransportDetailsDto = (List<TransportDetailsDto>) resDtoObjects
				.get("lTransportDetails");		
		mv.addObject("lTransportDetails", lTransportDetailsDto);		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("TransportDetailsController: saveTransportDetails Method End.");
		return mv;

	}

	@SuppressWarnings("unchecked")
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
		ModelAndView mv = new ModelAndView("showAddTransportDetails");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportDetailsId = Integer.parseInt(request.getParameter("id"));
		TransportDetailsDto transportDetailsDto = null;
		TransportTypeDtlDto transportTypeDtlDto = null;
		try {
			reqDtoObjects.put("transportDetailsId", transportDetailsId);
			resDtoObjects = masterServiceImpl.getTransportDetailsById(flowData,reqDtoObjects, resDtoObjects);
			
			transportDetailsDto = (TransportDetailsDto) resDtoObjects.get("TransportDetailsDto");
			
			Integer transporttypeDtlId = transportDetailsDto.getTranTypeDtlId();
			reqDtoObjects.put("transportTypeDtlId", transporttypeDtlId);
			resDtoObjects = masterServiceImpl.getTransportTypeDetailsById(flowData, reqDtoObjects, resDtoObjects);
			
			
			transportTypeDtlDto = (TransportTypeDtlDto) resDtoObjects.get("transportTypeDetails");
			Integer transId = transportTypeDtlDto.getTransId();
			reqDtoObjects.put("transId", transId);
			transportDetailsDto.setTransportTypeId(transId);
			
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			
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
		List<TransportTypeDtlDto> lTransportTypeDtlDtos = (List<TransportTypeDtlDto>) resDtoObjects.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtlDtos", lTransportTypeDtlDtos);
		
		List<TransportTypeDto> lTransportTypeDtos = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransportTypeDtos", lTransportTypeDtos);
		
		mv.addObject("TransportDetailsDto", transportDetailsDto);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("TransportDetailsController: editTransportDetails Method End.");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteTransportDetails.htm", method = RequestMethod.GET)
	public ModelAndView deleteTransportDetails(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("transportDetailsDto")TransportDetailsDto transportDetailsDto) {

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
		Integer transOwnId = transportDetailsDto.getOwnId(); //(Integer)request.getAttribute("ownId");

		try {
			reqDtoObjects.put("transportDetailsId", transportDetailsId);
			reqDtoObjects.put("ownId", transOwnId);
			mv.addObject("ownId", transOwnId);
			resDtoObjects = masterServiceImpl.deleteTransportDetails(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
			
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
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
		List<LoweryOwnerDto> lTransportOwners = (List<LoweryOwnerDto>) resDtoObjects.get("lTransportOwners");
		mv.addObject("lTransportOwners", lTransportOwners);	
		
		List<TransportDetailsDto> lTransportDetailsDto = (List<TransportDetailsDto>) resDtoObjects
				.get("lTransportDetails");
		mv.addObject("lTransportDetails", lTransportDetailsDto);	
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("TransportDetailsController: deleteTransportDetails Method End.");
		return mv;
	}

	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllTransportTypeDetailList.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportTypeDetailList(HttpServletRequest request,HttpServletResponse response, @ModelAttribute("TransportDetailsDto")TransportDetailsDto transportDetailsDto) {

		logger.info("TransportDetailsController: getAllTransportTypeDetailList Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("showAddTransportDetails");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportTypeId = Integer.parseInt(request.getParameter("transportTypeId"));
		Integer ownId = Integer.parseInt(request.getParameter("ownId"));
		TransportDetailsDto transportDetailsDto1 = new TransportDetailsDto();
		try {
			
			reqDtoObjects.put("transId", transportTypeId);
			reqDtoObjects.put("ownId", ownId);
			mv.addObject("transportTypeId", transportTypeId);
			mv.addObject("ownId", ownId);
			
			transportDetailsDto1.setOwnId(ownId);
			transportDetailsDto1.setTransportTypeId(transportTypeId);
			transportDetailsDto1.setLoweryNo(transportDetailsDto.getLoweryNo());
			transportDetailsDto1.setId(transportDetailsDto.getId());
			transportDetailsDto1.setDelFlag(transportDetailsDto.getDelFlag());
			
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);

		
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: getAllTransportTypeDetailList",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController getAllTransportTypeDetailList Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<TransportTypeDtlDto> lTransportTypeDtlDtos = (List<TransportTypeDtlDto>) resDtoObjects.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtlDtos", lTransportTypeDtlDtos);
		
		List<TransportTypeDto> lTransportTypeDtos = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransportTypeDtos", lTransportTypeDtos);
		
		mv.addObject("TransportDetailsDto", transportDetailsDto1);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("TransportDetailsController: getAllTransportTypeDetailList Method End.");
		return mv;
	}
}
