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
import com.admas.logiware.dto.CompanyLoadDetailDto;
import com.admas.logiware.dto.CompanyRouteDto;
import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.TransportTypeDtlDto;
import com.admas.logiware.dto.TransportTypeDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

/**
 * @author Ajinkya
 *
 */
public class LoadController extends BaseController{
	
	Logger logger = LoggerFactory.getLogger(LoadController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllLoadEntry.htm", method = RequestMethod.GET)
	public ModelAndView getAllLoadEntry(@ModelAttribute("LoadEntry")CompanyLoadDetailDto loadDto, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("LoadController: getAllLoadEntry Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		 
		ModelAndView mv = new ModelAndView("getAllLoadEntry");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		List<ContractCompDto> lContractCompanies =null;
		CompanyLoadDetailDto loadDto2 = new CompanyLoadDetailDto();
		Integer compId = 0;
		try {
			if(loadDto.getCompId()==null){
				compId=Integer.parseInt(request.getParameter("compId"));
			}
			else{
				compId = loadDto.getCompId();
			}
			loadDto2.setCompId(compId);
			reqDtoObjects.put("compId", compId);
			mv.addObject("compId", compId);
			
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllLoadEntry(flowData,	reqDtoObjects, resDtoObjects);
				
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in LoadController: getAllLoadEntry", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In LoadController getAllLoadEntry Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		lContractCompanies = (List<ContractCompDto>) resDtoObjects.get("lContractCompanies");
		mv.addObject("lContractCompanies", lContractCompanies);
		mv.addObject("LoadEntry", loadDto2);
		List<CompanyLoadDetailDto> lLoadDto = (List<CompanyLoadDetailDto>) resDtoObjects.get("lLoadDto");
		mv.addObject("lLoadDto", lLoadDto);		
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("LoadController: getAllLoadEntry Method End.");
		return mv;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/showAddloadEntry.htm", method = RequestMethod.GET)
	public ModelAndView showAddloadEntry(@ModelAttribute("LoadEntry")CompanyLoadDetailDto loadDto, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("LoadController: showAddloadEntry Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("showAddAllLoadEntry");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer compId=Integer.parseInt(request.getParameter("compId")); //loadDto.getCompId();
		List<CompanyRouteDto> lCompanyRouteDtos =null;
		List<TransportTypeDto> lTransports = null;
		List<TransportTypeDtlDto> lTransportTypeDtls =null;
		List<CompanyRouteDto> lCompanyRouteDtos2 =new ArrayList<CompanyRouteDto>();
		CompanyLoadDetailDto LoadEntry =new CompanyLoadDetailDto();
		try {
			reqDtoObjects.put("contractCompId", compId);
			LoadEntry.setCompId(compId);
//			mv.addObject("compId", compId);
			resDtoObjects = masterServiceImpl.getAllContractCompRoutes(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			reqDtoObjects.put("transId", 1);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
		} catch (Exception e) {
			logger.error(
					"Exception In LoadController: showAddloadEntry Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		
		lCompanyRouteDtos =(List<CompanyRouteDto>) resDtoObjects.get("lCompanyRouteDtos");
		for (CompanyRouteDto companyRouteDto2 : lCompanyRouteDtos) {
			String routeName = companyRouteDto2.getStartCityId().getName() + " - " +companyRouteDto2.getEndCityId().getName();
			companyRouteDto2.setRouteName(routeName);
			lCompanyRouteDtos2.add(companyRouteDto2);
		}
		mv.addObject("lCompanyRouteDto", lCompanyRouteDtos2);
		
		mv.addObject("lCompanyRouteDtos", lCompanyRouteDtos);
		lTransports = (List<TransportTypeDto>) resDtoObjects.get("lTransports");
		mv.addObject("lTransports", lTransports);
		lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);
		mv.addObject("LoadEntry", LoadEntry);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("LoadController: showAddloadEntry Method End.");
		return mv;
	}

	
	@RequestMapping(value = "/saveLoadEntry.htm", method = RequestMethod.POST)
	public ModelAndView saveLoadEntry(
			@ModelAttribute("LoadEntry") CompanyLoadDetailDto loadDto,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("LoadController: saveLoadEntry() Method Start.");		
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);		
		
		ModelAndView mv = new ModelAndView("getAllLoadEntry");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();		
		String sucessMessage= "";
		try {			
			reqDtoObjects.put("loadDto", loadDto);
			if (loadDto.getId() != null && loadDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditLoadEntry(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
//				loadDto.setCompId(Integer.parseInt(flowData
//						.getSessionData(WebAppConstants.COMPID)));
				loadDto.setDelFlag('N');
				resDtoObjects = masterServiceImpl.saveLoadEntry(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		}catch (LogiwareBaseException _be) {
				logger.error("Exception in LoadController: saveLoadEntry",
						_be);
				mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
			
		} catch (Exception e) {
			logger.error(
					"Exception In LoadController saveTransportType --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<CompanyLoadDetailDto> lLoadDto = (List<CompanyLoadDetailDto>) resDtoObjects.get("lLoadDto");
		mv.addObject("lLoadDto", lLoadDto);
		logger.info("LoadController: saveLoadEntry() Method End.");
		return mv;
	}

	@RequestMapping(value = "/editLoadEntry.htm", method = RequestMethod.GET)
	public ModelAndView editLoadEntry(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("LoadController: editLoadEntry Method Start.");
		FlowData flowData = null;
		ModelAndView mv = new ModelAndView("showAddAllLoadEntry") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		CompanyLoadDetailDto loadDto = null;
		Integer loadDtoId=Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("loadDtoId", loadDtoId);
			resDtoObjects=masterServiceImpl.getLoadEntryById(flowData, reqDtoObjects, resDtoObjects);
			loadDto=(CompanyLoadDetailDto) resDtoObjects.get("loadDto");
			mv.addObject("LoadEntry",loadDto);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in LoadController: editLoadEntry",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In LoadController editLoadEntry Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		logger.info("LoadController: editLoadEntry Method End.");
		return mv;
	}
	
	
	@RequestMapping(value="/deleteLoadEntry.htm",method=RequestMethod.GET)
	public ModelAndView deleteTransportType(HttpServletRequest request,HttpServletResponse response){
		
		logger.info("LoadController: deleteLoadEntry Method Start.");

		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("getAllLoadEntry") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer transportTypeId=Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("transportTypeId", transportTypeId);
			resDtoObjects = masterServiceImpl.deleteLoadEntry(flowData, reqDtoObjects, resDtoObjects);			
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in LoadController: deleteLoadEntry",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In LoadController deleteLoadEntry Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<CompanyLoadDetailDto> lLoadDto = (List<CompanyLoadDetailDto>) resDtoObjects
				.get("lLoadDto");
		mv.addObject("lLoadDto", lLoadDto);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("LoadController: deleteLoadEntry Method End.");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllTransportTypeDetailListForLoad.htm", method = RequestMethod.GET)
	public ModelAndView getAllTransportTypeDetailListForLoad(HttpServletRequest request, HttpServletResponse response) throws LogiwareBaseException {

		logger.info("TransportTypeController: getAllTransportTypeDetailsList() Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("showAddAllLoadEntry");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		CompanyLoadDetailDto loadDto = new CompanyLoadDetailDto();
		Integer transportTypeId = Integer.parseInt(request.getParameter("transportTypeId"));
		Integer compId=Integer.parseInt(request.getParameter("compId")); 
		List<CompanyRouteDto> lCompanyRouteDtos = null;
		List<CompanyRouteDto> lCompanyRouteDtos2 = new ArrayList<CompanyRouteDto>();
		try {
			loadDto.setTransportTypeId(transportTypeId);
			loadDto.setCompId(compId);
			reqDtoObjects.put("transId", transportTypeId);
			reqDtoObjects.put("contractCompId", compId);
			resDtoObjects = masterServiceImpl.getAllContractCompRoutes(flowData, reqDtoObjects, resDtoObjects);
			
			mv.addObject("transId", transportTypeId);
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportTypeDetails(flowData, reqDtoObjects, resDtoObjects);
			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in LoadController: getAllTransportTypeDetailsList", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error("Exception In LoadController getAllTransportTypeDetails Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
			resDtoObjects = masterServiceImpl.getAllTransportTypes(flowData, reqDtoObjects, resDtoObjects);
		}
		
		lCompanyRouteDtos =(List<CompanyRouteDto>) resDtoObjects.get("lCompanyRouteDtos");
		for (CompanyRouteDto companyRouteDto2 : lCompanyRouteDtos) {
			String routeName = companyRouteDto2.getStartCityId().getName() + " - " +companyRouteDto2.getEndCityId().getName();
			companyRouteDto2.setRouteName(routeName);
			lCompanyRouteDtos2.add(companyRouteDto2);
		}
		mv.addObject("lCompanyRouteDtos", lCompanyRouteDtos2);
	
		List<TransportTypeDto> lTransports = (List<TransportTypeDto>) resDtoObjects
				.get("lTransports");
		mv.addObject("lTransports", lTransports);
		List<TransportTypeDtlDto> lTransportTypeDtls = (List<TransportTypeDtlDto>) resDtoObjects
				.get("lTransportTypeDtls");
		mv.addObject("lTransportTypeDtls", lTransportTypeDtls);
		
		mv.addObject("LoadEntry", loadDto);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		return mv;


	}
	
}