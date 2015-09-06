package com.admas.logiware.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.CompanyBranchDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.BranchService;
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

}
