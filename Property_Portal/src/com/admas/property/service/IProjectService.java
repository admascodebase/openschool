package com.admas.property.service;

import java.util.List;

import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.NewsDto;
import com.admas.property.dto.ProjectDto;

public interface IProjectService {

	List<ProjectDto> getProjectsByFilter(FilterDto filterDto);

	ProjectDto getProjectsDetails(Integer projectId);
	
	List<ProjectDto> getRecentProjectsByFilter(FilterDto filterDto);
	
	Boolean saveInquiryDto(InquiryDto inquiryDto);
	
	List<BuilderDto> getAllBuilders();

	List<BuilderDto> getAllAgents();

	List<BlogDto> getAllBlogs();

	List<NewsDto> getAllNews();

}