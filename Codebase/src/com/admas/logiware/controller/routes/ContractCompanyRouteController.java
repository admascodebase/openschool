package com.admas.logiware.controller.routes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

public class ContractCompanyRouteController extends BaseController{

	
	public ContractCompanyRouteController() {
	}
	
	Logger logger = LoggerFactory.getLogger(ContractCompanyRouteController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@RequestMapping(value = "/getAllContractCompRoutes.htm", method = RequestMethod.GET)
	public ModelAndView getAllContractCompRoutes(HttpServletRequest request, HttpServletResponse response) {
		logger.info("ContractCompanyRouteController: getAllContractCompRoutes Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("getAllContractCompRoute");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			Integer contractCompId = Integer.parseInt(request.getParameter("id"));
			reqDtoObjects.put("contractCompId", contractCompId);
			mv.addObject("contractCompId", contractCompId);
			resDtoObjects = masterServiceImpl.getAllContractCompRoutes(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CompanyRouteDto> lCompanyRouteDtos = (List<CompanyRouteDto>) resDtoObjects
					.get("lCompanyRouteDtos");
			mv.addObject("lCompanyRouteDtos", lCompanyRouteDtos);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: getAllContractCompRoutes", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In TransportDetailsController getAllContractCompRoutes Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("ContractCompanyRouteController: getAllContractCompRoutes Method End.");
		return mv;

	}
	
	@RequestMapping(value = "/showAddContractCompRoute.htm", method = RequestMethod.GET)
	public ModelAndView showAddContractCompRoute(HttpServletRequest request, HttpServletResponse response) {

		logger.info("ContractCompanyRouteController: showAddContractCompRoute Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}	
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("showAddContractCompRoute");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			CompanyRouteDto companyRouteDto= new CompanyRouteDto();
//			companyRouteDto.setOwnId(Integer.parseInt(request.getParameter("ownId")));
			
			resDtoObjects=masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CityDto> lCityStart = (List<CityDto>) resDtoObjects.get("lCities");
			resDtoObjects = masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CityDto> lCityEnd = (List<CityDto>) resDtoObjects.get("lCities");
			
			mv.addObject("lCityStart", lCityStart);
			mv.addObject("lCityEnd", lCityEnd);
			mv.addObject("companyRouteDto", companyRouteDto);
		} catch (Exception e) {
			logger.error(
					"Exception In ContractCompanyRouteController: showAddContractCompRoute Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("ContractCompanyRouteController: showAddContractCompRoute Method End.");
		return mv;
	}

/*	@RequestMapping(value = "/saveTransportDetails.htm", method = RequestMethod.POST)
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

	}*/

	@RequestMapping(value = "/editContractCompanyRoute.htm", method = RequestMethod.GET)
	public ModelAndView editContractCompanyRoute(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("ContractCompanyRouteController: editContractCompanyRoute Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("getAllContractCompRoute");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer contractCompRouteId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("contractCompRouteId", contractCompRouteId);
			resDtoObjects = masterServiceImpl.getContractCompRouteById(flowData,
					reqDtoObjects, resDtoObjects);
			mv = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));
			mv.addObject("contractCompRouteDto", resDtoObjects.get("contractCompRouteDto"));			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in ContractCompanyRouteController: editContractCompanyRoute",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In ContractCompanyRouteController editContractCompanyRoute Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("ContractCompanyRouteController: editContractCompanyRoute Method End.");
		return mv;
	}

	@RequestMapping(value = "/deleteContractCompanyRoute.htm", method = RequestMethod.GET)
	public ModelAndView deleteContractCompanyRoute(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("TransportDetailsController: deleteContractCompanyRoute Method Start.");
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
		Integer companyRouteId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("companyRouteId", companyRouteId);
			Integer contractCompanyId = (Integer)request.getAttribute("contractCompanyId");
			reqDtoObjects.put("contractCompanyId", contractCompanyId);
			
			resDtoObjects = masterServiceImpl.deleteTransportDetails(flowData,
					reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
			resDtoObjects = masterServiceImpl.getAllTransportDetails(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: deleteContractCompanyRoute",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In TransportDetailsController deleteContractCompanyRoute Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<CompanyRouteDto> lCompanyRouteDtos = (List<CompanyRouteDto>) resDtoObjects
				.get("lTransportDetails");
		mv.addObject("lCompanyRouteDtos", lCompanyRouteDtos);	
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("TransportDetailsController: deleteContractCompanyRoute Method End.");
		return mv;
	}

}
