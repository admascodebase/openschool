/**
 * 
 */
package com.admas.logiware.controller.master;

import java.util.ArrayList;
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
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.RoutePaySettingDto;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

/**
 * @author Ajinkya
 *
 */
public class RoutePaySettingController extends BaseController{
	
	public RoutePaySettingController() {

	}
	
	Logger logger = LoggerFactory.getLogger(RoutePaySettingController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllRoutePaySetting.htm", method = RequestMethod.GET)
	public ModelAndView getAllRoutePaySetting(@ModelAttribute("companyRouteDto")CompanyRouteDto companyRouteDto, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("RoutePaySettingController: getAllRoutePaySetting Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllRoutePaySetting");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer routePaySettingId = Integer.parseInt(request.getParameter("id"));
		List<CompanyRouteDto> lCompanyRouteDto2 = new ArrayList<CompanyRouteDto>();
		Integer contractCompId = companyRouteDto.getCompId();
		try {
			reqDtoObjects.put("routePaySettingId", routePaySettingId);
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
			
			
			if(contractCompId!=null){
				reqDtoObjects.put("contractCompId", contractCompId);
				resDtoObjects = masterServiceImpl.getAllContractCompRoutes(flowData, reqDtoObjects, resDtoObjects);
				
				List<CompanyRouteDto> lCompanyRouteDto = (List<CompanyRouteDto>) resDtoObjects.get("lCompanyRouteDtos");
				for (CompanyRouteDto companyRouteDto2 : lCompanyRouteDto) {
					String routeName = companyRouteDto2.getStartCityId().getName() + " - " +companyRouteDto2.getEndCityId().getName();
					companyRouteDto2.setRouteName(routeName);
					lCompanyRouteDto2.add(companyRouteDto2);
				}
				mv.addObject("lCompanyRouteDto", lCompanyRouteDto2);
			}
			resDtoObjects = masterServiceImpl.getAllRoutePaySetting(flowData, reqDtoObjects, resDtoObjects);
					
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in RoutePaySettingController: getAllRoutePaySetting", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In RoutePaySettingController getAllRoutePaySetting Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<RoutePaySettingDto> lRoutePaySettingDto = (List<RoutePaySettingDto>) resDtoObjects.get("lRoutePaySettingDto");
		mv.addObject("lRoutePaySettingDto", lRoutePaySettingDto);
		
		List<CompanyDto> lCompanies = (List<CompanyDto>) resDtoObjects.get("lContractCompanies");
		mv.addObject("lCompanies", lCompanies);
		mv.addObject("routeId", routePaySettingId);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("RoutePaySettingController: getAllRoutePaySetting Method End.");
		return mv;

	}


	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllCompRoutes.htm", method = RequestMethod.GET)
	public ModelAndView getAllCompRoutes(@ModelAttribute("companyRouteDto")CompanyRouteDto companyRouteDto,  HttpServletRequest request, HttpServletResponse response) {

		logger.info("RoutePaySettingController: getAllCompRoutes Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllRoutePaySetting");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer contractCompId =0;
		List<CompanyRouteDto> lCompanyRouteDto2 = new ArrayList<CompanyRouteDto>();
		try {
			if(companyRouteDto.getCompId()!=null){
				contractCompId = companyRouteDto.getCompId();	
			}else{
				contractCompId = Integer.parseInt(request.getParameter("id"));
			}
			
			
			reqDtoObjects.put("contractCompId", contractCompId);
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllContractCompRoutes(flowData, reqDtoObjects, resDtoObjects);
			
			
			List<CompanyRouteDto> lCompanyRouteDto = (List<CompanyRouteDto>) resDtoObjects.get("lCompanyRouteDtos");
			for (CompanyRouteDto companyRouteDto2 : lCompanyRouteDto) {
				String routeName = companyRouteDto2.getStartCityId().getName() + " - " +companyRouteDto2.getEndCityId().getName();
				companyRouteDto2.setRouteName(routeName);
				lCompanyRouteDto2.add(companyRouteDto2);
			}
			mv.addObject("lCompanyRouteDto", lCompanyRouteDto2);
			mv.addObject("companyRouteDto", companyRouteDto);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in RoutePaySettingController: getAllCompRoutes", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, "LW-CC-0002");

		} catch (Exception e) {
			logger.error("Exception In RoutePaySettingController getAllCompRoutes method --", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<CompanyDto> lCompanies = (List<CompanyDto>) resDtoObjects.get("lContractCompanies");
		mv.addObject("lCompanies", lCompanies);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("RoutePaySettingController: getAllCompRoutes Method End.");
		return mv;
	}

	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/showAddRoutePaySetting.htm", method = RequestMethod.GET)
	public ModelAndView showAddRoutePaySetting(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("RoutePaySettingController: showAddRoutePaySetting Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}	
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("showAddRoutePaySetting");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		RoutePaySettingDto routePaySettingDto = new RoutePaySettingDto();
		Integer routeId = (Integer) request.getAttribute("routeId");
		try {
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
		} catch (Exception e) {
			logger.error(
					"Exception In RoutePaySettingController: showAddRoutePaySetting Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		mv.addObject("routePaySettingDto", routePaySettingDto);
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransports", lTransports);
		List<TransportTypeDtlDto> lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);		
		mv.addObject("routeId", routeId);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("RoutePaySettingController: showAddRoutePaySetting Method End.");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllTransportTypeDetailsList.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportTypeDetailsList(@ModelAttribute("routePaySettingDto")RoutePaySettingDto routePaySettingDto, HttpServletRequest request, HttpServletResponse response) {
		logger.info("RoutePaySettingController: getAllTransportTypeDetailsList Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("showAddRoutePaySetting");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportTypeId = routePaySettingDto.getTransportTypeId();
		try {
			reqDtoObjects.put("transId", transportTypeId);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects= masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
						
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in RoutePaySettingController: getAllRoutePaySetting", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error("Exception In RoutePaySettingController getAllTransportTypeDetailsList Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		mv.addObject("routePaySettingDto", routePaySettingDto);
		
		List<TransportTypeDtlDto> lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects
				.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransports", lTransports);
		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("RoutePaySettingController: getAllTransportTypeDetailsList Method End.");
		return mv;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveRoutePaySetting.htm", method = RequestMethod.POST)
	public ModelAndView saveRoutePaySetting(
			@ModelAttribute("routePaySettingDto")RoutePaySettingDto routePaySettingDto,
			HttpServletRequest request, HttpServletResponse response) throws LogiwareBaseException {
		logger.info("RoutePaySettingController: saveRoutePaySetting Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		routePaySettingDto.setDelFlag('N');
		routePaySettingDto.setRouteId(1);
		ModelAndView mv = new ModelAndView("getAllRoutePaySetting");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage= "";
		try {
			reqDtoObjects.put("routePaySettingDto", routePaySettingDto);
//			need to remove hard coded id below
			reqDtoObjects.put("routePaySettingId", 1);
			if (routePaySettingDto.getId() != null && routePaySettingDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditRoutePaySetting(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = masterServiceImpl.saveRoutePaySetting(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
//			resDtoObjects = masterServiceImpl.getAllRoutePaySetting(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in RoutePaySettingController: saveRoutePaySetting", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In RoutePaySettingController saveRoutePaySetting Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<RoutePaySettingDto> lRoutePaySettingDto = (List<RoutePaySettingDto>) resDtoObjects.get("lRoutePaySettingDto");
		mv.addObject("lRoutePaySettingDto", lRoutePaySettingDto);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("RoutePaySettingController: saveRoutePaySetting Method End.");
		return mv;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/editRoutePaySetting.htm", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request, HttpServletResponse response) {

		logger.info("RoutePaySettingController: editRoutePaySetting Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("showAddRoutePaySetting");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer routePaySettingId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("routePaySettingId", routePaySettingId);
			resDtoObjects = masterServiceImpl.getRoutePaySettingById(flowData, reqDtoObjects, resDtoObjects);
			RoutePaySettingDto routePaySettingDto = (RoutePaySettingDto) resDtoObjects.get("routePaySettingDto");
			mv.addObject("routePaySettingDto", routePaySettingDto);
			reqDtoObjects.put("transId", routePaySettingDto.getTransportTypeId());
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in RoutePaySettingController: editRoutePaySetting", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error("Exception In RoutePaySettingController editRoutePaySetting Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransports", lTransports);
		List<TransportTypeDtlDto> lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);		
		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("RoutePaySettingController: editRoutePaySetting Method End.");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteRoutePaySetting.htm", method = RequestMethod.GET)
	public ModelAndView deleteRoutePaySetting(HttpServletRequest request, HttpServletResponse response) {

		logger.info("RoutePaySettingController: deleteRoutePaySetting Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllRoutePaySetting");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer routePaySettingId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("routePaySettingId", 1);
			reqDtoObjects.put("routePayId", routePaySettingId);
			resDtoObjects = masterServiceImpl.deleteRoutePaySetting(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE, WebAppConstants.LW_SUCESS_DELETE);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in RoutePaySettingController: deleteRoutePaySetting", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In RoutePaySettingController deleteRoutePaySetting Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<RoutePaySettingDto> lRoutePaySettingDto = (List<RoutePaySettingDto>) resDtoObjects.get("lRoutePaySettingDto");
		mv.addObject("lRoutePaySettingDto", lRoutePaySettingDto);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("RoutePaySettingController: deleteRoutePaySetting Method End.");
		return mv;
	}

}
