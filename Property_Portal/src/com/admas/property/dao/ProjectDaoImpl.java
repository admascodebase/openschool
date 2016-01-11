package com.admas.property.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.admas.property.constant.HomeSqlConstants;
import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.NewsDto;
import com.admas.property.dto.ProjectDto;
import com.admas.property.dto.ProjectSpecificationDto;

public class ProjectDaoImpl extends AbstractDao implements IProjectDao {

	public ProjectDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	Logger logger = LoggerFactory.getLogger(HomeDaoImpl.class);

	@Override
	public List<ProjectDto> getProjectsByFilter(FilterDto filterDto) {

		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultSet = null;
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		ProjectDto projectDto = new ProjectDto();
		try {
			conn = getConnection();
			query.setLength(0);

			query.append(HomeSqlConstants.GET_PROJECTS_BY_FILTER);

			stmt = conn.prepareStatement(query.toString());
			/*
			 * if(filterDto !=null){ if (filterDto.getLocation() != null ||
			 * filterDto.getLocation().equals("")) { stmt.setString(1,
			 * filterDto.getLocation()); } if (filterDto.getCategory() != null
			 * || filterDto.getCategory().equals("")) { stmt.setString(2,
			 * filterDto.getCategory()); } if (filterDto.getType() != null ||
			 * filterDto.getType().equals("")) { stmt.setString(3,
			 * filterDto.getType()); } if (filterDto.getPriceRange() != null ||
			 * filterDto.getPriceRange() == 0) { stmt.setDouble(3,
			 * filterDto.getPriceRange()); } }
			 */
			// stmt.setString(1, searchKey);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				projectDto.setAreaId(resultSet.getInt("area_id"));
				projectDto.setBuilderId(resultSet.getInt("builder_Id"));
				// projectDto.setCatagory(resultSet.getString(""));
				projectDto.setCityId(resultSet.getInt("city_Id"));
				projectDto.setCompanyName(resultSet.getString("companyName"));
				projectDto.setContactPerson(resultSet.getString("contact_person"));
				projectDto.setEmail(resultSet.getString("site_email"));
				projectDto.setWebsite(resultSet.getString("site_website"));
				projectDto.setPopertyName(resultSet.getString("propertyName"));
				projectDto.setSiteAddress(resultSet.getString("site_address"));
				projectDto.setSiteContactDetails(resultSet.getString("site_contact_detail"));
				projectDto.setStateId(resultSet.getInt("state_id"));
				projectDto.setStatus(resultSet.getString("co_status"));

				projectList.add(projectDto);
			}

			return projectList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectList;

	}

	@Override
	public ProjectDto getProjectsDetails(Integer projectId) {

		ProjectDto projectDto = new ProjectDto();

		try {

			Connection conn = null;
			PreparedStatement stmt = null;
			StringBuilder query = new StringBuilder();
			ResultSet resultSet = null;
			List<ProjectSpecificationDto> specificationList = new ArrayList<ProjectSpecificationDto>();
			List<ProjectSpecificationDto> amenitiesList = new ArrayList<ProjectSpecificationDto>();
			try {
				conn = getConnection();
				query.setLength(0);

				query.append(HomeSqlConstants.GET_PROJECT_DETAILS);

				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, projectId);
				resultSet = stmt.executeQuery();

				while (resultSet.next()) {
					projectDto.setAreaId(resultSet.getInt("area_id"));
					projectDto.setBuilderId(resultSet.getInt("builder_Id"));
					// projectDto.setCatagory(resultSet.getString(""));
					projectDto.setCityId(resultSet.getInt("city_Id"));
					projectDto.setCompanyName(resultSet.getString("companyName"));
					projectDto.setContactPerson(resultSet.getString("contact_person"));
					projectDto.setEmail(resultSet.getString("site_email"));
					projectDto.setWebsite(resultSet.getString("site_website"));
					projectDto.setPopertyName(resultSet.getString("propertyName"));
					projectDto.setSiteAddress(resultSet.getString("site_address"));
					projectDto.setSiteContactDetails(resultSet.getString("site_contact_detail"));
					projectDto.setStateId(resultSet.getInt("state_id"));
					projectDto.setStatus(resultSet.getString("co_status"));

					ProjectSpecificationDto specificationDto = new ProjectSpecificationDto();
					specificationDto.setId(resultSet.getInt("PROJ_SPEC_ID"));
					specificationDto.setSpecificationTypeId(resultSet.getInt("SPCIFY_ID"));
					specificationDto.setProjectId(resultSet.getInt("PROJ_ID"));
					specificationDto.setSpecificationValue(resultSet.getString("VALUE"));
					specificationDto.setDescription(resultSet.getString("DESCRIPTION"));
					specificationDto.setStatusFlag(resultSet.getString("STATUS_FLAG").charAt(0));
					specificationList.add(specificationDto);

					projectDto.setSpecificationList(specificationList);

				}
				resultSet = null;
				query = new StringBuilder();
				query.append(HomeSqlConstants.GET_AMENITIES);

				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, projectId);
				resultSet = stmt.executeQuery();

				while (resultSet.next()) {

					ProjectSpecificationDto amenitiesDto = new ProjectSpecificationDto();
					amenitiesDto.setId(resultSet.getInt("PROJ_SPEC_ID"));
					amenitiesDto.setSpecificationTypeId(resultSet.getInt("SPCIFY_ID"));
					amenitiesDto.setProjectId(resultSet.getInt("PROJ_ID"));
					amenitiesDto.setSpecificationValue(resultSet.getString("VALUE"));
					amenitiesDto.setDescription(resultSet.getString("DESCRIPTION"));
					amenitiesDto.setStatusFlag(resultSet.getString("STATUS_FLAG").charAt(0));

					amenitiesList.add(amenitiesDto);
					projectDto.setAmenitiesList(amenitiesList);
				}

			} catch (Exception e) {
				logger.error("Exception Occured in dao" + e);
			} finally {

			}
			// return projectDto;

		} catch (Exception e) {

		}
		return projectDto;
	}

	@Override
	public List<ProjectDto> getRecentProjectsByFilter(FilterDto filterDto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultSet = null;
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		try {
			conn = getConnection();
			query.setLength(0);

			query.append(HomeSqlConstants.GET_PROJECTS_BY_FILTER);

			stmt = conn.prepareStatement(query.toString());

			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
			}

			return projectList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectList;

	}

/*	@Override
	public Boolean saveInquiryDto(InquiryDto inquiryDto) {

		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
//		ResultSet resultSet = null;
		Boolean result = false;

		try {
			conn = getConnection();
			query.setLength(0);

			query.append(HomeSqlConstants.SAVE_INQUIRY);

			stmt = conn.prepareStatement(query.toString());

			if (inquiryDto.getBuilderId() != null || inquiryDto.getBuilderId() != 0) {
				stmt.setInt(1, inquiryDto.getBuilderId());
			}

			if (inquiryDto.getBuilder_proj_id() != null || inquiryDto.getBuilder_proj_id() != 0) {
				stmt.setInt(2, inquiryDto.getBuilder_proj_id());
			}

			if (inquiryDto.getName() != null || inquiryDto.getName().equals("")) {
				stmt.setString(3, inquiryDto.getName());
			}

			if (inquiryDto.getMobileNumber() != null || inquiryDto.getMobileNumber().equals("")) {
				stmt.setString(4, inquiryDto.getMobileNumber());
			}

			if (inquiryDto.getEmailId() != null || inquiryDto.getEmailId().equals("")) {
				stmt.setString(5, inquiryDto.getEmailId());
			}

			if (inquiryDto.getCity() != null || inquiryDto.getCity().equals("")) {
				stmt.setString(6, inquiryDto.getCity());
			}
			if (inquiryDto.getState() != null || inquiryDto.getState().equals("")) {
				stmt.setString(7, inquiryDto.getState());
			}

			if (inquiryDto.getCountry() != null || inquiryDto.getCountry().equals("")) {
				stmt.setString(8, inquiryDto.getCountry());
			}

			if (inquiryDto.getProperty_message() != null || inquiryDto.getProperty_message().equals("")) {
				stmt.setString(9, inquiryDto.getProperty_message());
			}

			if (inquiryDto.getAddress() != null || inquiryDto.getAddress().equals("")) {
				stmt.setString(10, inquiryDto.getAddress());
			}

			if (inquiryDto.getInquiryFlag() != null || inquiryDto.getInquiryFlag().equals("")) {
				stmt.setString(11, inquiryDto.getInquiryFlag());
			}

			if (inquiryDto.getCreated_on() != null || inquiryDto.getCreated_on().equals("")) {
				stmt.setString(12, inquiryDto.getName());
			}

			Integer i = stmt.executeUpdate();

			if (i != 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
*/

	@Override
	public List<BuilderDto> getAllBuilders() {

		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultset = null;
		List<BuilderDto> builderList = new ArrayList<BuilderDto>();
		try {
			conn = getConnection();
			query.setLength(0);
			query.append(HomeSqlConstants.GETBUILDERS);
			stmt = conn.prepareStatement(query.toString());
			resultset = stmt.executeQuery();

			while (resultset.next()) {

				BuilderDto builderDto =new BuilderDto();
				builderDto.setAddress2(resultset.getString("ADDRESS2"));
				builderDto.setAdress1(resultset.getString("ADRESS1"));
				builderDto.setBuilderId(resultset.getInt("BUILDER_ID"));
				builderDto.setBuilderName(resultset.getString("BUILDER_NAME"));
				builderDto.setCompCity(resultset.getInt("COMP_CITY"));
				builderDto.setCompanyLandline(resultset.getString("COMPANY_LANDLINE"));
				builderDto.setContactNo1(resultset.getString("CONTACT_NO1"));
				builderDto.setContactNo2(resultset.getString("CONTACT_NO2"));
				builderDto.setCreatedBy(resultset.getInt("CREATED_BY"));
				builderDto.setCreatedOn(resultset.getDate("CREATED_ON"));
				builderDto.setDelflg(resultset.getString("DELFLG"));
				builderDto.setEmailId(resultset.getString("EMAIL_ID"));
				builderDto.setEmailId2(resultset.getString("EMAIL_ID2"));
				builderDto.setEnableGoogleMap(resultset.getString("ENABLE_GOOGLE_MAP"));
				builderDto.setImageUrl(resultset.getString("IMAGEURL"));
				builderDto.setIsAgent(resultset.getString("ISAGENT"));
				builderDto.setLatitude(resultset.getDouble("Latitude"));
				builderDto.setLongitude(resultset.getDouble("Longitude"));
				builderDto.setOffCity(resultset.getInt("OFF_CITY"));
				builderDto.setSlogan(resultset.getString("Slogan"));
				builderDto.setUpdatedBy(resultset.getInt("UPDATED_BY"));
				builderDto.setUpdatedOn(resultset.getDate("UPDATED_ON"));
				builderDto.setWebsite(resultset.getString("WEBSITE"));

				
			builderList.add(builderDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return builderList;
	}

	@Override
	public List<BuilderDto> getAllAgents() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultset = null;
		List<BuilderDto> agentList = new ArrayList<BuilderDto>();
		try {
			conn = getConnection();
			query.setLength(0);
			query.append(HomeSqlConstants.GETBUILDERS);
			stmt = conn.prepareStatement(query.toString());
			resultset = stmt.executeQuery();

			while (resultset.next()) {

				BuilderDto builderDto =new BuilderDto();
				builderDto.setAddress2(resultset.getString("ADDRESS2"));
				builderDto.setAdress1(resultset.getString("ADRESS1"));
				builderDto.setBuilderId(resultset.getInt("BUILDER_ID"));
				builderDto.setBuilderName(resultset.getString("BUILDER_NAME"));
				builderDto.setCompCity(resultset.getInt("COMP_CITY"));
				builderDto.setCompanyLandline(resultset.getString("COMPANY_LANDLINE"));
				builderDto.setContactNo1(resultset.getString("CONTACT_NO1"));
				builderDto.setContactNo2(resultset.getString("CONTACT_NO2"));
				builderDto.setCreatedBy(resultset.getInt("CREATED_BY"));
				builderDto.setCreatedOn(resultset.getDate("CREATED_ON"));
				builderDto.setDelflg(resultset.getString("DELFLG"));
				builderDto.setEmailId(resultset.getString("EMAIL_ID"));
				builderDto.setEmailId2(resultset.getString("EMAIL_ID2"));
				builderDto.setEnableGoogleMap(resultset.getString("ENABLE_GOOGLE_MAP"));
				builderDto.setImageUrl(resultset.getString("IMAGEURL"));
				builderDto.setIsAgent(resultset.getString("ISAGENT"));
				builderDto.setLatitude(resultset.getDouble("Latitude"));
				builderDto.setLongitude(resultset.getDouble("Longitude"));
				builderDto.setOffCity(resultset.getInt("OFF_CITY"));
				builderDto.setSlogan(resultset.getString("Slogan"));
				builderDto.setUpdatedBy(resultset.getInt("UPDATED_BY"));
				builderDto.setUpdatedOn(resultset.getDate("UPDATED_ON"));
				builderDto.setWebsite(resultset.getString("WEBSITE"));

				
				agentList.add(builderDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return agentList;
	
	
	}

	@Override
	public List<BlogDto> getAllBlogs() {
		Connection conn=null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultSet = null;
		List<BlogDto> blogList = new ArrayList<BlogDto>();
		try{
			
			conn = getConnection();
			query.setLength(0);
			query.append(HomeSqlConstants.GETBLOG);
			stmt = conn.prepareStatement(query.toString());
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				
				BlogDto blogDto = new BlogDto();
				blogDto.setAuthorName(resultSet.getString("AUTHOR_NAME"));
				blogDto.setBlog(resultSet.getString("BLOG"));
				blogDto.setBlogDate(resultSet.getDate("BLOG_DATE"));
				blogDto.setBlogId(resultSet.getInt("BLOG_ID"));
				blogDto.setBlogTitle(resultSet.getString("BLOG_TITLE"));
				blogDto.setBuilderId(resultSet.getInt("BUILDER_ID"));
				blogDto.setProjId(resultSet.getInt("PROJ_ID"));
				
				blogList.add(blogDto);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		return blogList;
	}

	@Override
	public List<NewsDto> getAllNews() {
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultSet = null;
		List<NewsDto> newsList =new ArrayList<NewsDto>();
		try{
			
			conn= getConnection();
			query.setLength(0);
			query.append(HomeSqlConstants.GETNEWS);
			stmt = conn.prepareStatement(query.toString());
			resultSet = stmt.executeQuery();
			
			while(resultSet.next()){
				
				NewsDto newsDto = new NewsDto();
				newsDto.setBuilderId(resultSet.getInt("BuilderId"));
				newsDto.setCreated_by(resultSet.getInt("Created_by"));
				newsDto.setCreated_on(resultSet.getDate("Created_on"));
				newsDto.setDescription(resultSet.getString("Description"));
				newsDto.setHeading(resultSet.getString("Heading"));
				newsDto.setId(resultSet.getInt("Id"));
				newsDto.setImagePath(resultSet.getString("ImagePath"));
				newsDto.setNews_date(resultSet.getString("News_date"));
				newsDto.setUpdated_by(resultSet.getInt("Updated_by"));
				newsDto.setUpdated_on(resultSet.getDate("Updated_on"));
			
				newsList.add(newsDto);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public Boolean saveInquiryDto(InquiryDto inquiryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
