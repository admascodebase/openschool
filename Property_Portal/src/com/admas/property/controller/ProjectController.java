/**
 * 
 */
package com.admas.property.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.NewsDto;
import com.admas.property.dto.ProjectDto;
import com.admas.property.service.IProjectService;

/**
 * @author Ajinkya
 *
 */

@Controller
public class ProjectController {

	public ProjectController() {
	}

	Logger logger = LoggerFactory.getLogger(ProjectController.class);

	private IProjectService ProjectServiceImpl;// = new com.admas.property.project.service.ProjectServiceImpl();

	@RequestMapping(value = "/getProjectsByFilter.htm", method = RequestMethod.GET)
	public ModelAndView getProjectsByFilter(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("filterDto") FilterDto filterDto) {

		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		logger.info("HomeController: searchBook Method Start.");
		ModelAndView mv = new ModelAndView("Allprojects");
		projectList = ProjectServiceImpl.getProjectsByFilter(filterDto);
		mv.addObject("projectList", projectList);
		return mv;

	}

	@RequestMapping(value = "/getProjectsDetails.htm", method = RequestMethod.GET)
	public ModelAndView getProjectsDetails(HttpServletRequest request, HttpServletResponse response) {

		logger.info("ProjectController: getProjectsDetails Method Start.");
		ModelAndView mv = new ModelAndView("ShowProjectDetails");
		Integer projectId = 4;
		ProjectDto projectDto = null;

		try {
			projectDto = ProjectServiceImpl.getProjectsDetails(projectId);
		} catch (Exception e) {
			// TODO: handle exception
		}

		mv.addObject("projectDto", projectDto);
		logger.info("ProjectController: getProjectsDetails Method End.");
		return mv;

	}

	@RequestMapping(value = "/getRecentProjectsByFilter.htm", method = RequestMethod.GET)
	public ModelAndView getRecentProjectsByFilter(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("filterDto") FilterDto filterDto) {
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		logger.info("HomeController: searchBook Method Start.");
		ModelAndView mv1 = new ModelAndView("Dashboard");
		projectList = ProjectServiceImpl.getRecentProjectsByFilter(filterDto);
		mv1.addObject("locationList", projectList);
		return mv1;
	}

	@RequestMapping(value = "/saveInquiryDto.htm", method = RequestMethod.GET)
	public ModelAndView saveInquiryDto(@ModelAttribute("inquiryDto") InquiryDto inquiryDto, HttpServletRequest request,
			HttpServletResponse response) {

		List<String> locationList = new ArrayList<String>();
		logger.info("HomeController: saveBook Method Start.");
		Boolean result = false;
		ModelAndView mv = new ModelAndView("saveInquiry");

		/*inquiryDto.setAddress("Pune");
		inquiryDto.setBuilder_proj_id(4);
		inquiryDto.setBuilderId(1);
		inquiryDto.setCity("Pune");
		inquiryDto.setCountry("India");
		inquiryDto.setCreated_on("12/12/2012");
		inquiryDto.setEmailId("ajinkya7997");
		inquiryDto.setInquiryFlag("C");
		inquiryDto.setMobileNumber("9028341164");
		inquiryDto.setName("asdasd");
		inquiryDto.setProperty_message("asdasdas");
		inquiryDto.setState("MH");
		*/
		
		result = ProjectServiceImpl.saveInquiryDto(inquiryDto);

		mv.addObject("result", result);
		mv.addObject("locationList", locationList);
		return mv;

	}

	
	@RequestMapping(value = "/showInquiryForm.htm", method = RequestMethod.GET)
	public ModelAndView showInquiryForm(@ModelAttribute("inquiryDto") InquiryDto inquiryDto, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("HomeController: saveBook Method Start.");
		ModelAndView mv = new ModelAndView("showInquiryForm");

//		ProjectServiceImpl.showInquiryForm(inquiryDto);

		mv.addObject("inquiryDto", new InquiryDto());
		return mv;

	}

	@RequestMapping(value="/getAllBuilders.htm", method=RequestMethod.GET)
	public ModelAndView getAllBuilders( HttpServletRequest request, HttpServletResponse response) 
	{
		
		logger.info("HomeController: getAllBuilders method start.");
		
		List<BuilderDto> builderList =new ArrayList<BuilderDto>();
		ModelAndView mv = new ModelAndView("getAllBuilders");
		
		builderList = ProjectServiceImpl.getAllBuilders();
		
		mv.addObject("builderList", builderList);
		
		return mv;
	}
	
	@RequestMapping(value="/getAllAgents.htm", method=RequestMethod.GET)
	public ModelAndView getAllAgents( HttpServletRequest request, HttpServletResponse response) 
	{
		
		logger.info("HomeController: getAllBuilders method start.");
		
		List<BuilderDto> agentList =new ArrayList<BuilderDto>();
		ModelAndView mv = new ModelAndView("getAllAgents");
		
		agentList = ProjectServiceImpl.getAllAgents();
		
		mv.addObject("agentList", agentList);
		
		return mv;
	}
	
	@RequestMapping(value="/getAllBlogs.htm" , method=RequestMethod.GET)
	public ModelAndView getAllBlogs(HttpServletRequest request,HttpServletResponse response)
	{
		logger.info("HomeController:getAllBlogs method start.");
		List<BlogDto> blogList =new ArrayList<BlogDto>();
		ModelAndView mv = new ModelAndView("getAllBlogs");
		blogList = ProjectServiceImpl.getAllBlogs();
		
		mv.addObject("blogList",blogList);
		
		return mv;
		
	}
	
	@RequestMapping(value="/getAllNews.htm" , method = RequestMethod.GET)
	public ModelAndView getAllNews(HttpServletRequest request, HttpServletResponse response)
	{
		
		logger.info("HomeController:getAllNews method start");
		List<NewsDto> newsList = new ArrayList<NewsDto>();
		ModelAndView mv = new ModelAndView("getAllNews");
		newsList = ProjectServiceImpl.getAllNews();
		 mv.addObject("newsList", newsList);
		 
		 return mv;
	}

	
}
