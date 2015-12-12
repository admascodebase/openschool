/**
 * 
 */
package com.admas.logiware.controller.master;

import java.util.Date;
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
import com.admas.logiware.dto.CompanyLoadToTransDto;
import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.LoweryOwnerDto;
import com.admas.logiware.dto.TransportDetailsDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.CompLoadToTransServiceImpl;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;

/**
 * @author Ajinkya
 *
 */
public class CompLoadToTransController extends BaseController {

	/**
	 * 
	 */
	public CompLoadToTransController() {
	}

	Logger logger = LoggerFactory.getLogger(CompLoadToTransController.class);

	@Autowired
	@Qualifier("compLoadToTransServiceImpl")
	private CompLoadToTransServiceImpl compLoadToTransServiceImpl;

	@Autowired
	@Qualifier("masterServiceImpl")
	private MasterServiceImpl masterServiceImpl;

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @RequestMapping(value = "/getAllCompLoadToTrans.htm", method =
	 * RequestMethod.GET) public ModelAndView getAllCompLoadToTrans(
	 * 
	 * @ModelAttribute("companyLoadToTransDto") CompanyLoadToTransDto
	 * companyLoadToTransDto, HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * logger.info(
	 * "CompLoadToTransController: getAllCompLoadToTrans Method Start.");
	 * FlowData flowData = null;
	 * 
	 * super.handleRequestInternal(request, response); if
	 * (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
	 * flowData = (FlowData)
	 * request.getSession().getAttribute(WebAppConstants.FLOWDATA); } if
	 * (!flowData.isLoggedIn()) return super.loginPage(flowData, request);
	 * 
	 * ModelAndView mv = new ModelAndView("getAllCompanyLoadToTrans");
	 * HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
	 * Map<String, Object> resDtoObjects = new HashMap<String, Object>();
	 * List<CompanyLoadToTransDto> lCompanyLoadToTransDto = null;
	 * List<ContractCompDto> lContractCompanies = null; CompanyLoadToTransDto
	 * companyLoadToTransDto2 = new CompanyLoadToTransDto(); Integer
	 * companyLoadDtlId = 0; try { if
	 * (companyLoadToTransDto.getCompanyLoadDetail().getId() == null) {
	 * companyLoadDtlId =
	 * Integer.parseInt(request.getParameter("contractCompId")); } else {
	 * companyLoadDtlId = companyLoadToTransDto.getCompanyLoadDetail().getId();
	 * } companyLoadDtlId =
	 * Integer.parseInt(request.getParameter("companyLoadDetail.id"));
	 * CompanyLoadDetailDto companyLoadDetail = new CompanyLoadDetailDto();
	 * companyLoadDetail.setId(companyLoadDtlId);
	 * companyLoadToTransDto2.setCompanyLoadDetail(companyLoadDetail);
	 * 
	 * reqDtoObjects.put("companyLoadDtlId", companyLoadDtlId);
	 * mv.addObject("companyLoadDtlId", companyLoadDtlId);
	 * reqDtoObjects.put("compId", 11);
	 * 
	 * resDtoObjects = masterServiceImpl.getAllContractCompany(flowData,
	 * reqDtoObjects, resDtoObjects); resDtoObjects =
	 * masterServiceImpl.getAllLoadEntry(flowData, reqDtoObjects,
	 * resDtoObjects); resDtoObjects =
	 * compLoadToTransServiceImpl.getAllCompLoadToTrans(flowData, reqDtoObjects,
	 * resDtoObjects);
	 * 
	 * } catch (LogiwareBaseException _be) { logger.error(
	 * "Exception in CompLoadToTransController: getAllCompLoadToTrans", _be);
	 * mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());
	 * 
	 * } catch (Exception e) { logger.error(
	 * "Exception In CompLoadToTransController getAllCompLoadToTrans Method--",
	 * e); mv.addObject(WebAppConstants.ERROR_CODE,
	 * LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode()); }
	 * lCompanyLoadToTransDto = (List<CompanyLoadToTransDto>)
	 * resDtoObjects.get("lcompanyLoadToTransDto");
	 * mv.addObject("lCompanyLoadToTransDto", lCompanyLoadToTransDto);
	 * 
	 * mv.addObject("companyLoadToTransDto", companyLoadToTransDto2);
	 * 
	 * List<CompanyLoadDetailDto> lLoadDto = (List<CompanyLoadDetailDto>)
	 * resDtoObjects.get("lLoadDto"); mv.addObject("lLoadDto", lLoadDto);
	 * 
	 * lContractCompanies = (List<ContractCompDto>)
	 * resDtoObjects.get("lContractCompanies");
	 * mv.addObject("lContractCompanies", lContractCompanies);
	 * 
	 * 
	 * flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
	 * mv.addObject("userName", flowData.getSessionData("userName"));
	 * logger.info(
	 * "CompLoadToTransController: getAllCompLoadToTrans Method End."); return
	 * mv;
	 * 
	 * }
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllCompLoadToTrans.htm", method = RequestMethod.GET)
	public ModelAndView getAllCompLoadToTrans(@ModelAttribute("LoadEntry") CompanyLoadDetailDto loadDto,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("CompLoadToTransController: getAllCompLoadToTrans Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllCompanyLoadToTrans");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		List<ContractCompDto> lContractCompanies = null;
		CompanyLoadDetailDto loadDto2 = new CompanyLoadDetailDto();
		Integer contractCompId = 0;
		try {
			if (loadDto.getCompId() == null) {
				contractCompId = Integer.parseInt(request.getParameter("contractCompId"));
			} else {
				contractCompId = loadDto.getContractCompId();
			}
			loadDto2.setContractCompId(contractCompId);
			reqDtoObjects.put("compId", contractCompId);
			mv.addObject("contractCompId", contractCompId);

			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllLoadEntry(flowData, reqDtoObjects, resDtoObjects);

		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompLoadToTransController: getAllCompLoadToTrans", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In CompLoadToTransController getAllCompLoadToTrans Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		lContractCompanies = (List<ContractCompDto>) resDtoObjects.get("lContractCompanies");
		mv.addObject("lContractCompanies", lContractCompanies);
		mv.addObject("LoadEntry", loadDto2);
		List<CompanyLoadDetailDto> lLoadDto = (List<CompanyLoadDetailDto>) resDtoObjects.get("lLoadDto");
		mv.addObject("lLoadDto", lLoadDto);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CompLoadToTransController: getAllCompLoadToTrans Method End.");
		return mv;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/showAddCompLoadToTrans.htm", method = RequestMethod.GET)
	public ModelAndView showAddCompLoadToTrans(
			@ModelAttribute("companyLoadToTransDto") CompanyLoadToTransDto companyLoadToTransDto,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("CompLoadToTransController: showAddCompLoadToTrans Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("showAddCompLoadToTrans");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		Integer companyLoadDetailId = Integer.parseInt(request.getParameter("companyLoadDetailId")); // loadDto.getCompId();
		List<LoweryOwnerDto> lLoweryOwnerDto = null;
		CompanyLoadDetailDto companyLoadDetail = null;
		CompanyLoadToTransDto companyLoadToTransDto2 = new CompanyLoadToTransDto();

		try {
			reqDtoObjects.put("companyLoadDetailId", companyLoadDetailId);
			reqDtoObjects.put("loadDtoId", companyLoadDetailId);

			resDtoObjects = masterServiceImpl.getLoadEntryById(flowData, reqDtoObjects, resDtoObjects);
			companyLoadDetail = (CompanyLoadDetailDto) resDtoObjects.get("loadDto");

			companyLoadToTransDto2.setCompanyLoadDetail(companyLoadDetail);// setSessionData(WebAppConstants.COMPID,);
			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);

			// resDtoObjects =
			// masterServiceImpl.getAllTransportDetails(flowData, reqDtoObjects,
			// resDtoObjects);

		} catch (Exception e) {
			logger.error("Exception In LoadController: showAddloadEntry Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}

		lLoweryOwnerDto = (List<LoweryOwnerDto>) resDtoObjects.get("lTransportOwners");
		mv.addObject("lLoweryOwnerDto", lLoweryOwnerDto);

		// mv.addObject("", companyLoadDetail.getStatus());
		mv.addObject("companyLoadToTransDto", companyLoadToTransDto2);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		logger.info("CompLoadToTransController: showAddCompLoadToTrans Method End.");
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAllOwnerTransports.htm", method = RequestMethod.GET)
	public ModelAndView getAllOwnerTransports(
			/*
			 * @ModelAttribute("companyLoadToTransDto") CompanyLoadToTransDto
			 * companyLoadToTransDto,
			 */
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("fff: showAddCompLoadToTrans Method Start.");

		// String s= request.getQueryString();
		Integer transportOwnerId = Integer.parseInt(request.getParameter("transortOwnerId"));
		logger.info("id=" + transportOwnerId);
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("showAddCompLoadToTrans");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		CompanyLoadToTransDto companyLoadToTransDto2 = new CompanyLoadToTransDto();
		List<TransportDetailsDto> lTransportDetailsDto = null;
		List<LoweryOwnerDto> lLoweryOwnerDto = null;
		try {
			// if (loadDto.getCompId() == null) {
			// contractCompId =
			// Integer.parseInt(request.getParameter("contractCompId"));
			// } else {
			// contractCompId = loadDto.getContractCompId();
			// }
			companyLoadToTransDto2.setTransortOwnerId(transportOwnerId);
			reqDtoObjects.put("ownId", transportOwnerId);

			resDtoObjects = masterServiceImpl.getAllTransportOwners(flowData, reqDtoObjects, resDtoObjects);
			resDtoObjects = masterServiceImpl.getAllTransportDetails(flowData, reqDtoObjects, resDtoObjects);

		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompLoadToTransController: getAllCompLoadToTrans", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In CompLoadToTransController getAllCompLoadToTrans Method--", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}

		lLoweryOwnerDto = (List<LoweryOwnerDto>) resDtoObjects.get("lTransportOwners");
		mv.addObject("lLoweryOwnerDto", lLoweryOwnerDto);

		lTransportDetailsDto = (List<TransportDetailsDto>) resDtoObjects.get("lTransportDetails");
		mv.addObject("lTransportDetailsDto", lTransportDetailsDto);
		mv.addObject("companyLoadToTransDto", companyLoadToTransDto2);
		return mv;
	}

	@RequestMapping(value = "/saveCompLoadToTrans.htm", method = RequestMethod.POST)
	public ModelAndView saveCompLoadToTrans(@ModelAttribute("companyLoadToTransDto") CompanyLoadToTransDto companyLoadToTransDto,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("CompLoadToTransController: saveCompLoadToTrans() Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		companyLoadToTransDto.setCreatedOn(new Date());
		companyLoadToTransDto.setUpdatedOn(new Date());
		
		ModelAndView mv = new ModelAndView("getAllCompanyLoadToTrans");
		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		String sucessMessage = "";
		CompanyLoadToTransDto companyLoadToTransDto2 = new CompanyLoadToTransDto();
		try {
			reqDtoObjects.put("companyLoadToTransDto", companyLoadToTransDto);
			companyLoadToTransDto2.setTransportDtlId(companyLoadToTransDto.getTransportDtlId());
			companyLoadToTransDto2.setTransortOwnerId(companyLoadToTransDto.getTransortOwnerId());
			
			if (companyLoadToTransDto.getId() != null && companyLoadToTransDto.getId() > 0) {
				resDtoObjects = masterServiceImpl.saveEditLoadEntry(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage = WebAppConstants.LW_SUCESS_EDIT;
			} else {
//				loadDto.setCompId(Integer.parseInt(flowData.getSessionData(WebAppConstants.COMPID)));
				companyLoadToTransDto.setDelFlag('N');
				companyLoadToTransDto.setStatus("Assigned");
				companyLoadToTransDto.setCreatedBy(1);
				companyLoadToTransDto.setUpdatedBy(1);

				resDtoObjects = compLoadToTransServiceImpl.saveCompanyLoadToTransDto(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage = WebAppConstants.LW_SUCESS_ADD;
			}
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData, reqDtoObjects, resDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE, sucessMessage);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in CompLoadToTransController: saveCompLoadToTrans", _be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In CompLoadToTransController saveCompLoadToTrans --", e);
			mv.addObject(WebAppConstants.ERROR_CODE, LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}

		
		mv.addObject("companyLoadToTransDto", companyLoadToTransDto2);
		logger.info("CompLoadToTransController: saveCompLoadToTrans() Method End.");
		return mv;
	}

}
