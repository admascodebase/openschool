package com.admas.property.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.admas.property.constant.HomeSqlConstants;
import com.admas.property.constant.PropertyPortalConstants;
import com.admas.property.dto.BlogDto;
import com.admas.property.dto.BuilderDto;
import com.admas.property.dto.FilterDto;
import com.admas.property.dto.InquiryDto;
import com.admas.property.dto.ProjectDto;
import com.admas.property.dto.ProjectSpecificationDto;
import com.admas.property.exception.PropertyBaseException;
import com.admas.property.exception.PropertyErrors;

@Component
@Qualifier("homeDaoImpl")
public class HomeDaoImpl extends AbstractDao implements IHomeDao {

	Logger logger = LoggerFactory.getLogger(HomeDaoImpl.class);

	@Override
	public List<ProjectDto> getRecentProjectsByFilter() {
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultSet = null;
		List<ProjectDto> projectList = new ArrayList<ProjectDto>();
		try {
			conn = getConnection();
			query.setLength(0);

			query.append(HomeSqlConstants.GET_RECENT_PROJECTS);

			stmt = conn.prepareStatement(query.toString());

			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				ProjectDto projectDto = new ProjectDto();
				projectDto.setId(resultSet.getInt("builder_prop_Id"));

				ResultSet rs = null;
				query = new StringBuilder();
				query.append(HomeSqlConstants.GET_BUILDER_IMAGE_URL);

				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, resultSet.getInt("builder_prop_Id"));
				rs = stmt.executeQuery();

				if (rs.next()) {
					
					String imageUrl = PropertyPortalConstants.preurl.concat(rs.getString("image_type"));
					System.out.println("" + imageUrl);
					projectDto.setImageUrl(imageUrl);
				} else {
					System.out.println("Data");

				}

				// if(!rs.getString("image_type").equals("")){
				//
				// }

				projectDto.setAreaId(resultSet.getInt("area_id"));
				projectDto.setBuilderId(resultSet.getInt("builder_Id"));
				projectDto.setCatagory(resultSet.getString("category"));
				projectDto.setType(resultSet.getString("type"));
				projectDto.setCost(resultSet.getDouble("cost"));
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
				// projectDto.setImageUrl(resultSet.getString("image_type"));
				projectList.add(projectDto);
			}
			return projectList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return projectList;
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
			query.append(HomeSqlConstants.GETAGENTS);
			stmt = conn.prepareStatement(query.toString());
			resultset = stmt.executeQuery();

			while (resultset.next()) {

				BuilderDto builderDto = new BuilderDto();
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
				
				ResultSet rs = null;
				query = new StringBuilder();
				query.append(HomeSqlConstants.GET_AGENT_IMAGE_URL);

				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, resultset.getInt("BUILDER_ID"));
				rs = stmt.executeQuery();

				String imageUrl = null;
				if (rs.next()) {
					
					imageUrl = PropertyPortalConstants.preurl.concat(rs.getString("image_type"));
					System.out.println("" + imageUrl);
					builderDto.setImageUrl(imageUrl);
					
				}else{
					builderDto.setImageUrl(imageUrl);
				}
				
				
				//builderDto.setImageUrl(PropertyPortalConstants.preurl.concat(resultset.getString("IMAGEURL")));
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
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return agentList;

	}

	@Override
	public List<ProjectDto> getProjectsByFilter(FilterDto filterDto) {

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

			stmt.setString(1, "%"+filterDto.getCity()+"%");
			
			/*if (filterDto != null) {
				if (filterDto.getCity() != null || filterDto.getCity().equals("")) {
					stmt.setString(1, filterDto.getCity());
				}
				if (filterDto.getCategory() != null || filterDto.getCategory().equals("")) {
					stmt.setString(2, filterDto.getCategory());
				}
				if (filterDto.getType() != null || filterDto.getType().equals("")) {
					stmt.setString(3, filterDto.getType());
				}
				if (filterDto.getMinPrice() != null || filterDto.getMinPrice() == 0) {
					stmt.setDouble(4, filterDto.getMinPrice());
				}
				if (filterDto.getMaxPrice() != null || filterDto.getMaxPrice() == 0) {
					stmt.setDouble(5, filterDto.getMaxPrice());
				}
			}*/
			// stmt.setString(1, searchKey);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				ProjectDto projectDto = new ProjectDto();
				projectDto.setId(resultSet.getInt("builder_prop_Id"));

				ResultSet rs = null;
				query = new StringBuilder();
				query.append(HomeSqlConstants.GET_BUILDER_IMAGE_URL);

				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, resultSet.getInt("builder_prop_Id"));
				rs = stmt.executeQuery();

				if (rs.next()) {
					System.out.println("No data");

					String imageUrl = PropertyPortalConstants.preurl.concat(rs.getString("image_type"));
					System.out.println("search result project image url" + imageUrl);
					projectDto.setImageUrl(imageUrl);
				} else {
					System.out.println("Data");

				}

				projectDto.setAreaId(resultSet.getInt("area_id"));
				projectDto.setBuilderId(resultSet.getInt("builder_Id"));
				// projectDto.setCatagory(resultSet.getString(""));
				projectDto.setCost(resultSet.getDouble("cost"));
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
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return projectList;

	}

	@Override
	public List<BlogDto> getAllBlogs() {
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultSet = null;
		List<BlogDto> blogList = new ArrayList<BlogDto>();
		try {

			conn = getConnection();
			query.setLength(0);
			query.append(HomeSqlConstants.GETBLOG);
			stmt = conn.prepareStatement(query.toString());
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				BlogDto blogDto = new BlogDto();
				blogDto.setAuthorName(resultSet.getString("AUTHOR_NAME"));
				blogDto.setBlog(resultSet.getString("BLOG"));
				blogDto.setBlogDate(resultSet.getDate("BLOG_DATE"));
				blogDto.setBlogId(resultSet.getInt("BLOG_ID"));
				blogDto.setBlogTitle(resultSet.getString("BLOG_TITLE"));
				blogDto.setBuilderId(resultSet.getInt("BUILDER_ID"));
				blogDto.setProjId(resultSet.getInt("PROJ_ID"));
				blogDto.setImageUrl("/resources/PropertyPortal/images/blogImage.jpg");
				
				blogList.add(blogDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
		return blogList;
	}
	
	
	@Override
	public List<String> getLocation(String searchKey) throws PropertyBaseException {
		logger.info("Class HomeDaoImpl : getBooks() START");
		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		ResultSet resultSet = null;
		List<String> locationList = new ArrayList<String>();
		try {
			conn = getConnection();
			query.setLength(0);

			query.append(HomeSqlConstants.GET_LOCATION_DETAILS);

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, searchKey);
			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				locationList.add(resultSet.getString("NAME"));
			}

		} catch (Exception e) {
			logger.error(" Got exception in class HomeDaoImpl: getBooks() method -->	", e);
			throw new PropertyBaseException(PropertyErrors.DATABASE_GENERIC_ERROR);
		} finally {

			try {
				if (stmt != null) {
					closePrepareStatement(stmt);
				}
				if (resultSet != null) {
					closeResultset(resultSet);
				}
				closeConnection(conn);
			} catch (Exception _Ex) {
			}
		}
		logger.info("Class HomeDaoImpl : getBooks() END");
		return locationList;
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
			List<String> galleryImages = new ArrayList<>();
			List<String> floorImages = new ArrayList<>();

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
					projectDto.setAboutUs(resultSet.getString("about_us"));
					
					// For Panorama Image Start
					ResultSet rsPanorama = null;
					query = new StringBuilder();
					query.append(HomeSqlConstants.GET_PANORAMA_IMAGE);
					stmt = conn.prepareStatement(query.toString());
					stmt.setInt(1, projectId);
					rsPanorama = stmt.executeQuery();
					rsPanorama.next();
					String panoramaImage = rsPanorama.getString("image_type");
					panoramaImage = PropertyPortalConstants.preurl.concat(panoramaImage);
					System.out.println("" + panoramaImage);
					projectDto.setPanoramaImage(panoramaImage);
					// For Panorama Image End

					// For Gallery Image Start
					ResultSet rsGallery = null;
					query = new StringBuilder();
					query.append(HomeSqlConstants.GET_GALLERY_IMAGES);
					stmt = conn.prepareStatement(query.toString());
					stmt.setInt(1, projectId);
					rsGallery = stmt.executeQuery();

					while (rsGallery.next()) {
						String GalleryImage = PropertyPortalConstants.preurl.concat(rsGallery.getString("image_type"));
						System.out.println("" + panoramaImage);
						galleryImages.add(GalleryImage);						
					}
					projectDto.setGalleryImages(galleryImages);

					// For Gallery Image End

					// For floor Image Start
					ResultSet rsfloor = null;
					query = new StringBuilder();
					query.append(HomeSqlConstants.GET_FLOOR_IMAGES);
					stmt = conn.prepareStatement(query.toString());
					stmt.setInt(1, projectId);
					rsfloor = stmt.executeQuery();

					while (rsfloor.next()) {
						String FloorImage = PropertyPortalConstants.preurl.concat(rsfloor.getString("image_type"));
						System.out.println("" + FloorImage);
						floorImages.add(FloorImage);
						
					}
					projectDto.setFloorImages(floorImages);

					// For floor Image End

				}
				// for specification List Start

				ResultSet rsSpecification = null;
				query = new StringBuilder();
				query.append(HomeSqlConstants.GET_PROJECT_SPECIFICATION);
				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, projectId);
				rsSpecification = stmt.executeQuery();

				while (rsSpecification.next()) {
					ProjectSpecificationDto specificationDto = new ProjectSpecificationDto();
					specificationDto.setId(rsSpecification.getInt("PROJ_SPEC_ID"));
					specificationDto.setSpecificationTypeId(rsSpecification.getInt("SPCIFY_ID"));
					specificationDto.setProjectId(rsSpecification.getInt("PROJ_ID"));
					specificationDto.setSpecificationValue(rsSpecification.getString("VALUE"));
					specificationDto.setDescription(rsSpecification.getString("DESCRIPTION"));
					specificationDto.setStatusFlag(rsSpecification.getString("STATUS_FLAG").charAt(0));
					specificationList.add(specificationDto);

					
	
				}
				
				projectDto.setSpecificationList(specificationList);
				// for specification List End

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
					
				}

				projectDto.setAmenitiesList(amenitiesList);
				
			} catch (Exception e) {
				logger.error("Exception Occured in dao" + e);
			} finally {
				conn.close();
			}
			// return projectDto;

		} catch (Exception e) {

		}
		return projectDto;
	}

	@Override
	public Boolean saveInquiryDto(InquiryDto inquiryDto) {

		Connection conn = null;
		PreparedStatement stmt = null;
		StringBuilder query = new StringBuilder();
		// ResultSet resultSet = null;
		Boolean result = false;

		try {
			conn = getConnection();
			query.setLength(0);

			query.append(HomeSqlConstants.SAVE_INQUIRY);

			stmt = conn.prepareStatement(query.toString());

			if (inquiryDto.getName() != null || inquiryDto.getName().equals("")) {
				stmt.setString(1, inquiryDto.getName());
			}

			if (inquiryDto.getEmailId() != null || inquiryDto.getEmailId().equals("")) {
				stmt.setString(2, inquiryDto.getEmailId());
			}

			if (inquiryDto.getPropertyMessage() != null || inquiryDto.getPropertyMessage().equals("")) {
				stmt.setString(3, inquiryDto.getPropertyMessage());
			}
			if (inquiryDto.getSubject() != null || inquiryDto.getSubject().equals("")) {
				stmt.setString(4, inquiryDto.getSubject());
			}

			Integer i = stmt.executeUpdate();

			if (i != 0)
				result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
