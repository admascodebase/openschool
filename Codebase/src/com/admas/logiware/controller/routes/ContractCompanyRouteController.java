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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.CityDto;
import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.dto.ContractCompDto;
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllContractCompRoutes.htm", method = RequestMethod.GET)
	public ModelAndView getAllContractCompRoutes(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("companyRoute")ContractCompDto contractCompDto) throws LogiwareBaseException {
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
		Integer contractCompId = 0;
		try {
			if(contractCompDto.getCompId()==null){
				 contractCompId = 1;
			}else{
			contractCompId = contractCompDto.getCompId();/*Integer.parseInt(request.getParameter("id"));*/
			}
			reqDtoObjects.put("contractCompId", contractCompId);
			mv.addObject("contractCompId", contractCompId);
			resDtoObjects = masterServiceImpl.getAllContractCompRoutes(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
			
			
			List<CompanyRouteDto> lCompanyRouteDtos = (List<CompanyRouteDto>) resDtoObjects.get("lCompanyRouteDtos");
			mv.addObject("lCompanyRouteDtos", lCompanyRouteDtos);
			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in TransportDetailsController: getAllContractCompRoutes", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);

		} catch (Exception e) {
			logger.error("Exception In TransportDetailsController getAllContractCompRoutes Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
		}
		
		List<CompanyRouteDto> lContractCompanies = (List<CompanyRouteDto>) resDtoObjects.get("lContractCompanies");
		mv.addObject("lContractCompanies", lContractCompanies);
		mv.addObject("companyRoute", new ContractCompDto() );
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
			Integer contractCompId = Integer.parseInt(request.getParameter("compId"));
			CompanyRouteDto companyRouteDto= new CompanyRouteDto();
			resDtoObjects=masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CityDto> lCityStart = (List<CityDto>) resDtoObjects.get("lCities");
			resDtoObjects = masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CityDto> lCityEnd = (List<CityDto>) resDtoObjects.get("lCities");
			
			mv.addObject("lCityStart", lCityStart);
			mv.addObject("lCityEnd", lCityEnd);
			mv.addObject("compId", contractCompId);
			mv.addObject("companyRoute", companyRouteDto);
			
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveContractCompRoute.htm", method = RequestMethod.POST)
	public ModelAndView saveContractCompRoute(
			@ModelAttribute("companyRouteDto")CompanyRouteDto companyRouteDto,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("ContractCompanyRouteController: saveContractCompRoute Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		companyRouteDto.setDelFlag('N');
		ModelAndView mv = new ModelAndView("getAllContractCompRoute");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage= "";
//		Integer transId = Integer.parseInt(request.getParameter("transId"));
		try {
			Integer contractCompanyId =1;// (Integer) Integer.parseInt(request.getParameter("compId"));
			companyRouteDto.setCompId(contractCompanyId);
			reqDtoObjects.put("companyRouteDto", companyRouteDto);
			
			reqDtoObjects.put("contractCompId", contractCompanyId);
			if (companyRouteDto.getId() != null && companyRouteDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditCompanyRoute(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = masterServiceImpl.saveCompanyRoute(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in ContractCompanyRouteController: saveContractCompRoute", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In ContractCompanyRouteController saveContractCompRoute Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<ContractCompDto> lContractCompanies = (List<ContractCompDto>) resDtoObjects.get("lContractCompanies");
		mv.addObject("lContractCompanies", lContractCompanies);
		List<CompanyRouteDto> lCompanyRouteDtos = (List<CompanyRouteDto>) resDtoObjects.get("lCompanyRouteDtos");		
		mv.addObject("lCompanyRouteDtos", lCompanyRouteDtos);		
		mv.addObject("companyRoute", new ContractCompDto() );
		mv.addObject("contractCompId", 1);
		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("ContractCompanyRouteController: saveContractCompRoute Method End.");
		return mv;

	}

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
		ModelAndView mv = new ModelAndView("showAddContractCompRoute");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer contractCompRouteId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("contractCompRouteId", contractCompRouteId);
			resDtoObjects = masterServiceImpl.getContractCompRouteById(flowData,
					reqDtoObjects, resDtoObjects);
			mv = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));
			mv.addObject("companyRoute", resDtoObjects.get("contractCompRouteDto"));
			
			resDtoObjects=masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CityDto> lCityStart = (List<CityDto>) resDtoObjects.get("lCities");
			resDtoObjects = masterServiceImpl.getAllCities(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CityDto> lCityEnd = (List<CityDto>) resDtoObjects.get("lCities");
			
			mv.addObject("lCityStart", lCityStart);
			mv.addObject("lCityEnd", lCityEnd);
			
			
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteContractCompanyRoute.htm", method = RequestMethod.GET)
	public ModelAndView deleteContractCompanyRoute(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("ContractCompanyRouteController: deleteContractCompanyRoute Method Start.");
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
		Integer companyRouteId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("companyRouteId", companyRouteId);
			Integer contractCompanyId = 1/* (Integer)request.getAttribute("contractCompanyId")*/;
			reqDtoObjects.put("contractCompId", contractCompanyId);
			
			resDtoObjects = masterServiceImpl.deleteContractCompanyRoute(flowData, reqDtoObjects, resDtoObjects);
			
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
			
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
			resDtoObjects = masterServiceImpl.getAllContractCompRoutes(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in ContractCompanyRouteController: deleteContractCompanyRoute",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In ContractCompanyRouteController deleteContractCompanyRoute Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		List<CompanyRouteDto> lCompanyRouteDtos = (List<CompanyRouteDto>) resDtoObjects.get("lCompanyRouteDtos");
		mv.addObject("lCompanyRouteDtos", lCompanyRouteDtos);
		List<CompanyRouteDto> lContractCompanies = (List<CompanyRouteDto>) resDtoObjects.get("lContractCompanies");
		mv.addObject("lContractCompanies", lContractCompanies);
		mv.addObject("companyRoute", new ContractCompDto() );
		mv.addObject("contractCompId", 1);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("ContractCompanyRouteController: deleteContractCompanyRoute Method End.");
		return mv;
	}

}
