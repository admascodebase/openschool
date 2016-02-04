package com.admas.property.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.FloorPlanDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.PaymentStructureDto;
import com.admas.property.dto.ProjectDto;
import com.admas.property.dto.VideoDto;
import com.admas.property.exception.PropertyBaseException;
import com.admas.property.service.IHomeService;

public class HomeController extends BaseController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	/** The controller service. */
	@Autowired
	@Qualifier("homeServiceImpl")
	private IHomeService homeServiceImpl;// = new HomeServiceImpl();

	/**
	 * @return the homeServiceImpl
	 */
	/*
	 * public IHomeService getHomeServiceImpl() { return homeServiceImpl; }
	 * 
	 *//**
		 * @param homeServiceImpl
		 *            the homeServiceImpl to set
		 * @throws PropertyBaseException
		 *//*
		 * public void setHomeServiceImpl(IHomeService homeServiceImpl) {
		 * this.homeServiceImpl = homeServiceImpl; }
		 */

	@RequestMapping(value = "/property-home.htm", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws PropertyBaseException {

		logger.info("HomeController: home Method Start.");
		ModelAndView mv = new ModelAndView("home");

		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		List<BuilderDto> agentList = new ArrayList<BuilderDto>();

		projectList = homeServiceImpl.getRecentProjectsByFilter();
		agentList = homeServiceImpl.getAllAgents();

		if (!agentList.isEmpty()) {
			mv.addObject("agentList", agentList);
		} else {
			mv.addObject("NOAGENTSFOUND", "No Agents Were Found In The System");
		}
		if (!projectList.isEmpty()) {
			mv.addObject("projectList", projectList);
		} else {
			mv.addObject("NOPROJECTSFOUND", "No Projects Were Found In The System");
		}

		// mv.addObject("agentList", agentList);
		// mv.addObject("projectList", projectList);

		logger.info("HomeController: home Method End.");
		return mv;

	}

	@RequestMapping(value = "/search-property.htm", method = RequestMethod.POST)
	public ModelAndView searchHome(HttpServletRequest request, HttpServletResponse response)
			throws PropertyBaseException {

		logger.info("BookController: searchBook Method Start.");
		ModelAndView mv = new ModelAndView("searchResult");
		// String search_city = request.getQueryString();

		System.out.println("city : " + request.getParameter("search_city"));
		String city = request.getParameter("search_city");

		System.out.println(request.getParameter("search_category"));
		String category = request.getParameter("search_category");

		// System.out.println("Parama : "+request.getParameter("search_lng"));

		System.out.println("search_type : " + request.getParameter("search_type"));
		String type = request.getParameter("search_type");

		System.out.println("search_max_price : " + request.getParameter("search_max_price"));
		String maxPrice = request.getParameter("search_max_price");

		System.out.println("search_max_price : " + request.getParameter("search_min_price"));
		String minPrice = request.getParameter("search_min_price");

		FilterDto filterDto = new FilterDto();
		filterDto.setCity(city);
		filterDto.setCategory(category);
		if(type.equals("0"))
			type = "";
		filterDto.setType(type);
		if(!minPrice.equals(""))
		/*filterDto.setMinPrice(Double.valueOf(minPrice));
		else
			filterDto.setMinPrice(0.0);
		if(!maxPrice.equals(""))
		filterDto.setMaxPrice(Double.valueOf(maxPrice));
		else
			filterDto.setMaxPrice(0.0);
		*/
			if(minPrice!=null && minPrice.length()>0){
				filterDto.setMinPrice(Double.valueOf(minPrice));
			}else{
				filterDto.setMinPrice(Double.valueOf(0.0));
			}
			
			if(maxPrice!=null && maxPrice.length()>0){
				filterDto.setMinPrice(Double.valueOf(maxPrice));
			}else{
				filterDto.setMinPrice(Double.valueOf(0.0));
			}
			
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		projectList = homeServiceImpl.getProjectsByFilter(filterDto);
		
		if (!projectList.isEmpty()) {
			mv.addObject("projectList", projectList);
		} else {
			mv.addObject("NOPROJECTSFOUND", "No Projects Were Found In The System");
		}

//		mv.addObject("projectList", projectList);
		return mv;

	}

	@RequestMapping(value = "/singleProperty.htm", method = RequestMethod.GET)
	public ModelAndView getPropertyById(HttpServletRequest request, HttpServletResponse response) {

		logger.info("BookController: searchBook Method Start.");
		ModelAndView mv = new ModelAndView("singleProperty");

		// Integer projectId = Integer.parseInt(request.getParameter("id"));

		String projectId = request.getParameter("id");

		ProjectDto projectDto = null;
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		List<BuilderDto> agentList = new ArrayList<BuilderDto>();

		try {
			projectDto = homeServiceImpl.getProjectsDetails(Integer.parseInt(projectId));
			projectList = homeServiceImpl.getRecentProjectsByFilter();
			agentList = homeServiceImpl.getAllAgents();

		} catch (Exception e) {
			// TODO: handle exception
		}
		mv.addObject("agentList", agentList);
		mv.addObject("projectList", projectList);
		mv.addObject("projectDto", projectDto);
		logger.info("ProjectController: getProjectsDetails Method End.");
		return mv;

	}

	@RequestMapping(value = "/blogs.htm", method = RequestMethod.GET)
	public ModelAndView blogs(HttpServletRequest request, HttpServletResponse response) throws PropertyBaseException {

		logger.info("BookController: searchBook Method Start.");
		ModelAndView mv = new ModelAndView("blog");

		List<BlogDto> blogList = new ArrayList<BlogDto>();
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		List<BuilderDto> agentList = new ArrayList<BuilderDto>();

		blogList = homeServiceImpl.getAllBlogs();
		projectList = homeServiceImpl.getRecentProjectsByFilter();
		agentList = homeServiceImpl.getAllAgents();

		if (!agentList.isEmpty()) {
			mv.addObject("agentList", agentList);
		} else {
			mv.addObject("NOAGENTSFOUND", "No Agents Were Found In The System");
		}
		if (!projectList.isEmpty()) {
			mv.addObject("projectList", projectList);
		} else {
			mv.addObject("NOPROJECTSFOUND", "No Projects Were Found In The System");
		}
		if (!blogList.isEmpty()) {
			mv.addObject("blogList", blogList);
		} else {
			mv.addObject("NOBLOGSFOUND", "No Blogs Were Found In The System");
		}

		return mv;

	}

	@RequestMapping(value = "/contactUs.htm", method = RequestMethod.GET)
	public ModelAndView contactUs(HttpServletRequest request, HttpServletResponse response) throws PropertyBaseException {

		logger.info("BookController: searchBook Method Start.");
		ModelAndView mv = new ModelAndView("contactUs");
		
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		List<BuilderDto> agentList = new ArrayList<BuilderDto>();

		projectList = homeServiceImpl.getRecentProjectsByFilter();
		agentList = homeServiceImpl.getAllAgents();

		if (!agentList.isEmpty()) {
			mv.addObject("agentList", agentList);
		} else {
			mv.addObject("NOAGENTSFOUND", "No Agents Were Found In The System");
		}
		if (!projectList.isEmpty()) {
			mv.addObject("projectList", projectList);
		} else {
			mv.addObject("NOPROJECTSFOUND", "No Projects Were Found In The System");
		}

		
		return mv;

	}

	@RequestMapping(value = "/saveContactUs.htm", method = RequestMethod.GET)
	public ModelAndView saveContactUs(HttpServletRequest request, HttpServletResponse response) throws PropertyBaseException {

		logger.info("BookController: searchBook Method Start.");
		ModelAndView mv = new ModelAndView("contactUs");
		InquiryDto inquiryDto = new InquiryDto();
		
		String name = request.getParameter("cp_name");
		String subject = request.getParameter("cp_subject");
		String propertyMessage = request.getParameter("cp_message");
		String emailId = request.getParameter("cp_email");
		
		inquiryDto.setName(name);
		inquiryDto.setSubject(subject);
		inquiryDto.setPropertyMessage(propertyMessage);
		inquiryDto.setEmailId(emailId);
		
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		List<BuilderDto> agentList = new ArrayList<BuilderDto>();

		projectList = homeServiceImpl.getRecentProjectsByFilter();
		agentList = homeServiceImpl.getAllAgents();
		Boolean result = homeServiceImpl.saveInquiryDto(inquiryDto);
		
		if (!agentList.isEmpty()) {
			mv.addObject("agentList", agentList);
		} else {
			mv.addObject("NOAGENTSFOUND", "No Agents Were Found In The System");
		}
		if (!projectList.isEmpty()) {
			mv.addObject("projectList", projectList);
		} else {
			mv.addObject("NOPROJECTSFOUND", "No Projects Were Found In The System");
		}

		
		mv.addObject("result", result);

		
		return mv;

	}

	
	@RequestMapping(value="/floorPlanDetails.htm", method = RequestMethod.GET)
	public ModelAndView floorPlanDetails(HttpServletRequest request , HttpServletResponse response) throws PropertyBaseException
	{
		
		logger.info("HomeController:floorPlanDetails metgod start");
		Integer projectId = 4;
		List<FloorPlanDto> floorplanList = new ArrayList<FloorPlanDto>();
		ModelAndView mv = new ModelAndView("FloorDetails");
		floorplanList = homeServiceImpl.floorPlanDetails(projectId);
		mv.addObject("floorplanList", floorplanList);
		return mv;
	}
	
	@RequestMapping(value="/videoGallery.htm", method = RequestMethod.GET)
	public ModelAndView videoGallery(HttpServletRequest request , HttpServletResponse response) throws PropertyBaseException
	{
		
		logger.info("HomeController:videoGallery metgod start");
		List<VideoDto> videoList = new ArrayList<VideoDto>();
		ModelAndView mv = new ModelAndView("videoDetails");
		Integer buliderId = 3;
		Integer priprojectId = 6;
		videoList = homeServiceImpl.videoGallery(buliderId , priprojectId);
		mv.addObject("videoList", videoList);
		return mv;
	}
	
	@RequestMapping(value="/paymentStructure.htm", method = RequestMethod.GET)
	public ModelAndView paymentStructure(HttpServletRequest request , HttpServletResponse response) throws PropertyBaseException
	{
		
		logger.info("HomeController:paymentStructure metgod start");
		List<PaymentStructureDto> paymentList = new ArrayList<PaymentStructureDto>();
		ModelAndView mv = new ModelAndView("PaymentStructureDto");
		
		paymentList = homeServiceImpl.paymentStructure();
		mv.addObject("paymentList", paymentList);
		return mv;
	}
	
	
	
	
	/*
	 * @RequestMapping(value = "/searchBook.htm", method = RequestMethod.GET)
	 * public ModelAndView searchBook(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * List<String> locationList = new ArrayList<String>(); logger.info(
	 * "HomeController: searchBook Method Start."); ModelAndView mv = new
	 * ModelAndView("Dashboard"); try { locationList =
	 * homeServiceImpl.getLocations("Pu"); } catch (PropertyBaseException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); }
	 * mv.addObject("locationList",locationList); return mv;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/showBook.htm", method = RequestMethod.GET)
	 * public ModelAndView showBook(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * logger.info("HomeController: showBook Method Start."); ModelAndView mv =
	 * new ModelAndView("showBooks"); HashMap<String, Object> reqDtoObjects =
	 * new HashMap<String, Object>(); List<String> locationList = new
	 * ArrayList<String>(); try { String searchKey =
	 * request.getParameter("searchKey"); reqDtoObjects.put("searchKey",
	 * searchKey); locationList = homeServiceImpl.getLocations(searchKey);
	 * mv.addObject("locationList",locationList); return mv; } catch
	 * (PropertyBaseException _be) { logger.error(
	 * "Exception in HomeController: searchBook", _be);
	 * mv.addObject(WebAppConstants.ERROR_CODE, _be.getErrorCode()); } catch
	 * (Exception e) { logger.error(
	 * "Exception In HomeController showBook Method--", e);
	 * mv.addObject(WebAppConstants.ERROR_CODE,
	 * PropertyErrors.GENERIC_EXCEPTION.getErrorCode()); } return mv;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/discoverBook.htm", method = RequestMethod.GET)
	 * public ModelAndView discoverBook(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * logger.info("HomeController: discoverBook Method Start."); ModelAndView
	 * mv = new ModelAndView("discoverBook"); return mv;
	 * 
	 * }
	 */}
