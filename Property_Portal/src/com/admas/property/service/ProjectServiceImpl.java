package com.admas.property.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.property.dao.IProjectDao;
import com.admas.property.dao.ProjectDaoImpl;
import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.NewsDto;
import com.admas.property.dto.ProjectDto;

public class ProjectServiceImpl implements IProjectService {

	public ProjectServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

	/*
	 * @Autowired
	 * 
	 * @Qualifier("homeDaoImpl")
	 */
	private IProjectDao projectDaoImpl = new ProjectDaoImpl();

	@Override
	public List<ProjectDto> getProjectsByFilter(FilterDto filterDto) {

		List<ProjectDto> projectList = new ArrayList<ProjectDto>();

		projectList = projectDaoImpl.getProjectsByFilter(filterDto);

		return projectList;
	}

	@Override
	public ProjectDto getProjectsDetails(Integer projectId) {

		ProjectDto projectDto = new ProjectDto();
		try {
			projectDto = projectDaoImpl.getProjectsDetails(projectId);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return projectDto;

	}

	@Override
	public List<ProjectDto> getRecentProjectsByFilter(FilterDto filterDto) {

		List<ProjectDto> projectList = new ArrayList<ProjectDto>();

		projectList = projectDaoImpl.getRecentProjectsByFilter(filterDto);

		return projectList;

	}
	
	
	@Override
	public Boolean saveInquiryDto(InquiryDto inquiryDto) {
		
		
		Boolean result = false;
		result = projectDaoImpl.saveInquiryDto(inquiryDto);
		return result;
		
	}
	

	@Override
	public List<BuilderDto> getAllBuilders() {
		
		List<BuilderDto> builderList =new ArrayList<BuilderDto>();
		builderList = projectDaoImpl.getAllBuilders();
		return builderList;
	}

	@Override
	public List<BuilderDto> getAllAgents() {
		
		List<BuilderDto> agentList =new ArrayList<BuilderDto>();
		agentList = projectDaoImpl.getAllAgents();
		return agentList;
	}

	@Override
	public List<BlogDto> getAllBlogs() {
		List<BlogDto> blogList = new ArrayList<BlogDto>();
		blogList = projectDaoImpl.getAllBlogs();
		return blogList;
	}

	@Override
	public List<NewsDto> getAllNews() {
		
		List<NewsDto> newsList = new ArrayList<NewsDto>();
		newsList = projectDaoImpl.getAllNews();
		return newsList;
	}

	
}