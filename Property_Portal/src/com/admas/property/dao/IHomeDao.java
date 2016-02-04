package com.admas.property.dao;

import java.sql.SQLException;
import java.util.List;

import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.FloorPlanDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.PaymentStructureDto;
import com.admas.property.dto.ProjectDto;
import com.admas.property.dto.VideoDto;
import com.admas.property.exception.PropertyBaseException;

public interface IHomeDao {

	public List<String> getLocation(String searchKey) throws PropertyBaseException;

	List<ProjectDto> getRecentProjectsByFilter()throws PropertyBaseException;

	List<BuilderDto> getAllAgents()throws PropertyBaseException;

	List<ProjectDto> getProjectsByFilter(FilterDto filterDto)throws PropertyBaseException;

	ProjectDto getProjectsDetails(Integer projectId)throws PropertyBaseException;

	List<BlogDto> getAllBlogs() throws PropertyBaseException;

	Boolean saveInquiryDto(InquiryDto inquiryDto)throws PropertyBaseException;
	
	public List<FloorPlanDto> floorPlanDetails(Integer projectId);

	public List<VideoDto> videoGallery(Integer builderId, Integer priprojectId);

	public List<PaymentStructureDto> paymentStructure();

	
}
