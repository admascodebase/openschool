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
import com.admas.logiware.dto.CompanyDto;
import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.LogiwareRespnse;
import com.admas.logiware.dto.SettingsDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

public class CompanyController extends BaseController {

	public CompanyController() {
	}

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	@RequestMapping(value = "/getAllCompany.htm", method = RequestMethod.GET)
	public ModelAndView getAllCompany(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("CityController: getAllCompany Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = masterServiceImpl.getAllCompany(flowData,
					reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<CompanyDto> lCompanies = (List<CompanyDto>) resDtoObjects
					.get("lCompanies");
			mv.addObject("lCompanies", lCompanies);

		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: getAllCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In CompanyController  --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CityController: getAllCompany Method End.");
		return mv;

	}

	
	
	@RequestMapping(value = "/showAddCompany.htm", method = RequestMethod.GET)
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("CompanyController: addCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			
			resDtoObjects=masterServiceImpl.showAddCompany(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			mv.addObject("company",new CompanyDto());
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: getAllCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController addCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CompanyController: addCompany Method End.");
		return mv;
	}
	
	
	
	@RequestMapping(value="/saveCompany.htm", method=RequestMethod.POST)
	public ModelAndView saveCompany(@ModelAttribute("company") CompanyDto companyDto, HttpServletRequest request, HttpServletResponse response){
		
		logger.info("CompanyController: saveCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage = null;
		try {	
			reqDtoObjects.put("company", companyDto);
			if(companyDto.getId()!=null && companyDto.getId()>0){
					resDtoObjects = masterServiceImpl.saveEditCompany(flowData, reqDtoObjects, resDtoObjects);
					sucessMessage = WebAppConstants.LW_SUCESS_EDIT;
			}
			else{
			resDtoObjects=masterServiceImpl.saveCompany(flowData, reqDtoObjects, resDtoObjects);
			sucessMessage = WebAppConstants.LW_SUCESS_ADD;
			}
			
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			resDtoObjects=masterServiceImpl.getAllCompany(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<CompanyDto> lCompanies = (List<CompanyDto>) resDtoObjects.get("lCompanies");
			mv=new ModelAndView(viewName);	
			mv.addObject("lCompanies", lCompanies);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: saveCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController saveCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CompanyController: saveCompany Method End.");
		return mv;
		
		
	}
	
	
	@RequestMapping(value = "/showEditCompany.htm", method = RequestMethod.GET)
	public ModelAndView EditCompany(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("CompanyController: EditCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer companyId=Integer.parseInt(request.getParameter("id"));
		CompanyDto companyDto=new CompanyDto();
		try {			
			reqDtoObjects.put("companyId", companyId);
			resDtoObjects=masterServiceImpl.showEditCompany(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			resDtoObjects=masterServiceImpl.getCompanyById(flowData, reqDtoObjects, resDtoObjects);
			companyDto = (CompanyDto)resDtoObjects.get("companyDto");
			mv.addObject("company", companyDto);
			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: EditCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In EmployeeController showEditEmployee Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CompanyController: EditCompany Method End.");
		return mv;
}
	
	
	@RequestMapping(value = "/deleteCompany.htm", method = RequestMethod.GET)
	public ModelAndView deleteCompany(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("CompanyController: deleteCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("getAllCompany") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer companyId=Integer.parseInt(request.getParameter("id"));
		String sucessMessage = null;
		try {			
			reqDtoObjects.put("companyId", companyId);
			resDtoObjects = masterServiceImpl.deleteCompany(flowData, reqDtoObjects, resDtoObjects);
			sucessMessage = WebAppConstants.LW_SUCESS_DELETE;			
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: deleteCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController deleteCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		
		@SuppressWarnings("unchecked")
		List<CompanyDto> lCompanies = (List<CompanyDto>) resDtoObjects
				.get("lCompanies");
		mv.addObject("lCompanies", lCompanies);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CompanyController: deleteCompany Method End.");
		return mv;
}
	
/*
 * Contract Company Actions
 */	
	
	
	@RequestMapping(value = "/showAddContractCompany.htm", method = RequestMethod.GET)
	public ModelAndView addContractCompany(HttpServletRequest request, HttpServletResponse response) {		
		logger.info("CompanyController: addContractCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {			
			resDtoObjects=masterServiceImpl.addContractCompany(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			mv.addObject("contractCompany",new ContractCompDto());
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: addContractCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController addContractCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("CompanyController: addContractCompany Method End.");
		return mv;
	}
	
	
	
	@RequestMapping(value="/saveContractCompany.htm", method=RequestMethod.POST)
	public ModelAndView saveContractCompany(@ModelAttribute("contractCompany")ContractCompDto contractCompDto  , HttpServletRequest request, HttpServletResponse response){
		
		logger.info("CompanyController: saveContractCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView("getAllContractCompany") ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage= "";
		try {
			contractCompDto.setCompId(Integer.parseInt(flowData
					.getSessionData(WebAppConstants.COMPID)));
			reqDtoObjects.put("contractCompDto", contractCompDto);

			if (contractCompDto.getId() != null && contractCompDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditContractCompany(
						flowData, reqDtoObjects, resDtoObjects);
				sucessMessage = WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = masterServiceImpl.saveCOntractCompany(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage = WebAppConstants.LW_SUCESS_ADD;
				resDtoObjects = masterServiceImpl.getSettingByType(flowData,
						reqDtoObjects, resDtoObjects);
				SettingsDto settingsDto = (SettingsDto) resDtoObjects
						.get("settingDto");
				if (settingsDto.getValue().equals("Y")) {
					// send sms logic
					masterServiceImpl.sendSmsToContractCompany(flowData,
							reqDtoObjects, resDtoObjects);
				}

			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE, sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: saveContractCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController saveContractCompany() ", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		
		@SuppressWarnings("unchecked")
		List<ContractCompDto> lContractCompanies = (List<ContractCompDto>) resDtoObjects
				.get("lContractCompanies");
		mv.addObject("lContractCompanies", lContractCompanies);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("CompanyController: saveContractCompany Method End.");
		return mv;
		
		
	}
	
	@RequestMapping(value = "/getAllContractCompany.htm", method = RequestMethod.GET)
	public ModelAndView getAllContractCompany(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("CompanyController: getAllContractCompany Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData,
					reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<ContractCompDto> lContractCompanies = (List<ContractCompDto>) resDtoObjects
					.get("lContractCompanies");
			mv.addObject("lContractCompanies", lContractCompanies);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: getAllCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In CompanyController  --", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("CompanyController: getAllContractCompany Method End.");
		return mv;

	}
	
	@RequestMapping(value = "/showEditContractCompany.htm", method = RequestMethod.GET)
	public ModelAndView editContractCompany(HttpServletRequest request, HttpServletResponse response) {		
		
		logger.info("CompanyController: EditContractCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer contractCompanyId=Integer.parseInt(request.getParameter("id"));
		try {			
			reqDtoObjects.put("contractCompanyId", contractCompanyId);
			resDtoObjects=masterServiceImpl.showEditContractCompany(flowData, reqDtoObjects, resDtoObjects);
			String viewName=(String)resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv=new ModelAndView(viewName);	
			resDtoObjects=masterServiceImpl.getContractCompanyById(flowData, reqDtoObjects, resDtoObjects);
			LogiwareRespnse logiwareRespnse = (LogiwareRespnse) resDtoObjects.get("userResponse");
			mv.addObject("contractCompany", logiwareRespnse.getContractCompDto());
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: EditContractCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In EmployeeController EditContractCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		
		logger.info("CompanyController: EditContractCompany Method End.");
		return mv;
}
	
	@RequestMapping(value = "/deleteContractCompany.htm", method = RequestMethod.GET)
	public ModelAndView deleteContractCompany(HttpServletRequest request, HttpServletResponse response) {		
		logger.info("CompanyController: deleteContractCompany Method Start.");
		FlowData flowData = null;
		
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		
		ModelAndView mv = new ModelAndView() ;
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer ContractcompanyId=Integer.parseInt(request.getParameter("id"));
		String sucessMessage= "";
		try {			
			reqDtoObjects.put("ContractcompanyId", ContractcompanyId);
			resDtoObjects = masterServiceImpl.deleteContractCompany(flowData,
					reqDtoObjects, resDtoObjects);
			sucessMessage= WebAppConstants.LW_SUCESS_DELETE;
			String viewName = (String) resDtoObjects
					.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData,
					reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompanyController: deleteContractCompany",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In CompanyController deleteContractCompany Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<ContractCompDto> lContractCompanies = (List<ContractCompDto>) resDtoObjects
				.get("lContractCompanies");
		mv.addObject("lContractCompanies", lContractCompanies);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("CompanyController: deleteContractCompany Method End.");
		return mv;
}
	
}
