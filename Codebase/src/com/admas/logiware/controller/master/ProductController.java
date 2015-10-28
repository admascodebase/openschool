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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.logiware.constant.WebAppConstants;
import com.admas.logiware.controller.core.BaseController;
import com.admas.logiware.dto.ContractCompDto;
import com.admas.logiware.dto.FlowData;
import com.admas.logiware.dto.ProductDto;
import com.admas.logiware.exception.LogiwareBaseException;
import com.admas.logiware.exception.LogiwarePortalErrors;
import com.admas.logiware.usrmgt.service.MasterServiceImpl;
import com.admas.logiware.usrmgt.service.ProductService;

public class ProductController extends BaseController {

	public ProductController() {
	}
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ProductService productService;
	@Autowired
	MasterServiceImpl masterServiceImpl;
	
	public MasterServiceImpl getMasterServiceImpl() {
		return masterServiceImpl;
	}
	public void setMasterServiceImpl(MasterServiceImpl masterServiceImpl) {
		this.masterServiceImpl = masterServiceImpl;
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@RequestMapping(value = "/getAllProduct.htm", method = RequestMethod.GET)
	public ModelAndView getAllProduct(HttpServletRequest request, HttpServletResponse response) {

		logger.info("ProductController: Product Method Start.");
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);

		ModelAndView mv = new ModelAndView("getAllProduct");
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		try {
			resDtoObjects = productService.getAllProduct(flowData, reqDtoObjects, resDtoObjects);
			@SuppressWarnings("unchecked")
			List<ProductDto> lProducts = (List<ProductDto>) resDtoObjects.get("lProducts");
			mv.addObject("lProducts", lProducts);

		} catch (LogiwareBaseException _be) {
			logger.error("Exception in ProductController: getAllProduct",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error("Exception In ProductController: getAllProduct", e);
			mv.addObject(
					WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION
							.getErrorCode());
		}
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));

		return mv;

	}
	
	@RequestMapping(value="/showAddProduct.htm", method=RequestMethod.GET)
	public ModelAndView getProductView(@ModelAttribute("product")ProductDto product, HttpServletRequest request,
			HttpServletResponse response) {
		
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv = new ModelAndView("addProduct");
/*		HashMap<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();*/
		/*try {
			resDtoObjects = masterServiceImpl.getAllContractCompany(flowData,
					reqDtoObjects, resDtoObjects);
		} catch (LogiwareBaseException e) {
			e.printStackTrace();
		}*/
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
/*		Map<String, Object> res = new HashMap<String, Object>();
		for(ContractCompDto c :(List<ContractCompDto>)resDtoObjects.get("lContractCompanies")){
			res.put(c.getId().toString(), c.getName());
		}
		mv.addObject("lconrtactCo", resDtoObjects.get("lContractCompanies"));*/
		logger.info("ProductController: AddProduct Method End.");
		return mv;
	}
	//saveProduct.htm
	
	@RequestMapping(value="/saveProduct.htm", method=RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("product")ProductDto product, HttpServletRequest request,
			HttpServletResponse response) {
		
		FlowData flowData = null;

		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		Map<String ,Object>reqDtoObjects = new HashMap<String, Object>();
		Map<String ,Object>resDtoObjects = new HashMap<String, Object>();
		ModelAndView mv = new ModelAndView("getAllProduct");
		product.setDelFlag('N');
		product.setId(product.getId());
		//product.setId(WebAppConstants.COMPID);
		String sucessMessage = "";
		try{
			reqDtoObjects.put("product", product);
			if (product.getId() != null && product.getId() > 0) {
				resDtoObjects = productService.editProduct(flowData, reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_EDIT;
			} else {
				resDtoObjects = productService.saveProduct(flowData,
						reqDtoObjects, resDtoObjects);
				sucessMessage= WebAppConstants.LW_SUCESS_ADD;
				resDtoObjects = productService.getAllProduct(flowData, reqDtoObjects, resDtoObjects);
			}
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,sucessMessage);
			
		}
		catch(LogiwareBaseException lbe){
			
		}
		@SuppressWarnings("unchecked")
		List<ProductDto> lProducts = (List<ProductDto>) resDtoObjects.get("lProducts");
		mv.addObject("lProducts", lProducts);
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));
		
		return mv;
		
	}
	//editProduct.htm
	@RequestMapping(value="/editProduct.htm", method=RequestMethod.GET)
	public ModelAndView editProduct(HttpServletRequest request, HttpServletResponse response){
		FlowData flowData = null;
		logger.info("ProductController: editProduct Method Start.");
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		ModelAndView mv=new ModelAndView("getAllProduct");
		Map<String, Object>reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object>resDtoObjects = new HashMap<String, Object>();
		Integer productId = Integer.parseInt(request.getParameter("id"));
		reqDtoObjects.put("productId", productId);

		try{
			resDtoObjects = productService.getProductById(flowData, reqDtoObjects, resDtoObjects);
			mv = new ModelAndView((String) resDtoObjects.get(WebAppConstants.VIEW_NAME));
			mv.addObject("product", resDtoObjects.get("productResponse"));
		}
		catch(LogiwareBaseException baseException){
			logger.error("Exception in ProductController: showEditEmployee", baseException);
			mv.addObject(WebAppConstants.ERROR_CODE, baseException.getErrorCode());
		}
		 catch (Exception e) {
				logger.error(
						"Exception In EmployeeController showEditEmployee Method--",
						e);
				mv.addObject(WebAppConstants.ERROR_CODE,
						LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
			}
		
		return mv;
		
	}
	
	@RequestMapping(value="/deleteProduct.htm", method=RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest request, HttpServletResponse response){
		FlowData flowData=null;
		super.handleRequestInternal(request, response);
		if(request.getSession().getAttribute(WebAppConstants.FLOWDATA)!=null){
			flowData = (FlowData) request.getSession().getAttribute(WebAppConstants.FLOWDATA);
		}
		if(!flowData.isLoggedIn()){
			super.loginPage(flowData, request);
		}
		ModelAndView mv=new ModelAndView("getAllProduct");
		Map<String, Object>requestDtoObjects = new HashMap<String, Object>();
		
		Map<String, Object>responseDtoObjects = new HashMap<String, Object>();
		Integer productId = Integer.parseInt(request.getParameter("id"));
		requestDtoObjects.put("productId", productId);
		try{
			responseDtoObjects = productService.deleteProduct(flowData, requestDtoObjects, responseDtoObjects);
			mv.addObject(WebAppConstants.SUCESS_MESSAGE,WebAppConstants.LW_SUCESS_DELETE);
			responseDtoObjects = productService.getAllProduct(flowData, requestDtoObjects, responseDtoObjects);
		} catch (LogiwareBaseException _be) {
			logger.error("Exception in ProductController: showEditEmployee",
					_be);
			mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode());

		} catch (Exception e) {
			logger.error(
					"Exception In ProductController deleteEmployee Method--",
					e);
			mv.addObject(WebAppConstants.ERROR_CODE,
					LogiwarePortalErrors.GENERIC_EXCEPTION.getErrorCode());
		}
		@SuppressWarnings("unchecked")
		List<ProductDto> lProducts = (List<ProductDto>) responseDtoObjects
				.get("lProducts");		
		mv.addObject("lProducts", lProducts);	
		flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
		mv.addObject("userName", flowData.getSessionData("userName"));	
		return mv;

	}
	
	@RequestMapping(value="/getAddedProduct.htm", method = RequestMethod.GET)
	public ModelAndView getAddedProduct(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("productComapany")ContractCompDto compDto){
		
		logger.info("ProductController: getAddedProduct Method Start.");
		FlowData flowData = null;
		super.handleRequestInternal(request, response);
		if (request.getSession().getAttribute(WebAppConstants.FLOWDATA) != null) {
			flowData = (FlowData) request.getSession().getAttribute(
					WebAppConstants.FLOWDATA);
		}
		if (!flowData.isLoggedIn())
			return super.loginPage(flowData, request);
		HashMap<String, Object> reqDtoObject = new HashMap<String, Object>();
		Map<String, Object> resDtoObject = new HashMap<String, Object>();
		ModelAndView mv=new ModelAndView("getAddedProduct");
		List<ContractCompDto>compDtos = new ArrayList<ContractCompDto>();
		Integer contractCompId = 0;
		try {
			if(compDto.getCompId()==null){
				 contractCompId = 1;
			}else{
			contractCompId = compDto.getCompId();/*Integer.parseInt(request.getParameter("id"));*/
			}
			resDtoObject.put("contractCompId", contractCompId);
			mv.addObject("contractCompId", contractCompId);
			resDtoObject = masterServiceImpl.getAllContractCompany(flowData,
					reqDtoObject, resDtoObject);
			compDtos = (List<ContractCompDto>) resDtoObject.get("lContractCompanies");
		} catch (LogiwareBaseException e) {
			e.printStackTrace();
		}
			mv.addObject("lContractCompanies", compDtos);
			flowData.setSessionData(WebAppConstants.ISLOGEDIN, "true");
			mv.addObject("userName", flowData.getSessionData("userName"));	
			logger.info("MasterController: getAllProduct Method End.");
			return mv;
	}


}
