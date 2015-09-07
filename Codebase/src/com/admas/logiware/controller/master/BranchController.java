package com.admas.logiware.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.EmployeeDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.BranchService;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;
public class BranchController extends BaseController {
	
	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BranchController.class);
	
	@Autowired
	private BranchService branchService;

	public BranchController() {
	}

	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	
	@RequestMapping(value = "/getAllBranch.htm", method = RequestMethod.GET)
	public ModelAndView getAllBranch(HttpServletRequest request, HttpServletResponse response) {

		logger.info("BranchController: Branch Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView();
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = branchService.getAllBranch(flowData, reqDtoObjects, resDtoObjects);
			String viewName = (String) resDtoObjects.get(WebAppConstants.VIEW_NAME);
			mv = new ModelAndView(viewName);
			@SuppressWarnings("unchecked")
			List<CompanyBranchDto> lBranches = (List<CompanyBranchDto>) resDtoObjects.get("lBranches");
			mv.addObject("lBranches", lBranches);

		} catch (Exception e) {
			logger.error("Exception In BranchController  --", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}

		return mv;

	}

	
	@RequestMapping(value = "/showAddCompanyBranch.htm", method = RequestMethod.GET)
	public ModelAndView showAddCompanyBranch(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("BranchController: showAddCompanyBranch Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("showAddCompanyBranch");
		try {
			mv.addObject("companyBranch", new CompanyBranchDto());			
		} catch (Exception e) {
			logger.error(
					"Exception In BranchController: showAddCompanyBranch Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("BranchController: showAddCompanyBranch Method End.");
		return mv;
	}

	
	@RequestMapping(value = "/saveCompanyBranch.htm", method = RequestMethod.POST)
	public ModelAndView saveEmployee(
			@ModelAttribute("companyBranch") CompanyBranchDto companyBranchDto,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("BranchController: CompanyBranchsave Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		companyBranchDto.setCompId(Integer.parseInt(flowData
				.getSessionData(WebAppConstants.COMPID)));
		companyBranchDto.setDelFlag('N');
		ModelAndView mv = new ModelAndView("getAllBranch");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage= "";
		try {
			reqDtoObjects.put("companyBranchDto", companyBranchDto);
			if (companyBranchDto.getId() != null && companyBranchDto.getId() > 0) {
				resDtoObjects = branchService.saveEditCompanyBranch(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = branchService.saveCompanyBranch(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
			}
			
			resDtoObjects = branchService.getAllBranch(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in BranchController: saveCompanyBranch", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In BranchController saveCompanyBranch Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
					
		@SuppressWarnings("unchecked")
		List<CompanyBranchDto> lBranches = (List<CompanyBranchDto>) resDtoObjects.get("lBranches");
		mv.addObject("lBranches", lBranches);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		
		return mv;

	}

	@RequestMapping(value = "/editCompanyBranch.htm", method = RequestMethod.GET)
	public ModelAndView editCompanyBranch(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("BranchController: editCompanyBranch Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllBranch");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer companyBranchId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("companyBranchId", companyBranchId);
			resDtoObjects = branchService.getCompanyBranchById(flowData, reqDtoObjects, resDtoObjects);
			mv = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));
			mv.addObject("companyBranch", resDtoObjects.get("companyBranch"));			
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in EmployeeController: editCompanyBranch Method",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
		} catch (Exception e) {
			logger.error(
					"Exception In EmployeeController editCompanyBranch Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		logger.info("BranchController: editCompanyBranch Method End.");
		return mv;
		
	}

	@RequestMapping(value = "/deleteCompanyBranch.htm", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("BranchController: deleteCOmpanyBranch Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllBranch");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer companyBranchId = Integer.parseInt(request.getParameter("id"));
		try {
			reqDtoObjects.put("companyBranchId", companyBranchId);
			resDtoObjects = branchService.deleteCompanyBranch(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
			resDtoObjects = branchService.getAllBranch(flowData, reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in BranchController: deleteCOmpanyBranch",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In BranchController deleteCOmpanyBranch Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<CompanyBranchDto> lBranches = (List<CompanyBranchDto>) resDtoObjects.get("lBranches");
		mv.addObject("lBranches", lBranches);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		return mv;
	}

	
}
