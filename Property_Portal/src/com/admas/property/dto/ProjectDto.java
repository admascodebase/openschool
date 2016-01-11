/**
 * 
 */
package com.admas.property.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ajinkya
 *
 */
public class ProjectDto {

	
	public ProjectDto() {
	}
	
	private Integer id;
	private String popertyName;
	private String companyName;
	private Integer builderId;
	private Integer stateId;
	private Integer cityId;
	private Integer areaId;
	private String contactPerson;
	private String siteAddress;
	private String siteContactDetails;
	private String email;
	private String website;
	private String status;
	private String catagory;
	private String type;
	private String imageUrl;
	private String panoramaImage;
	private String aboutUs;
	
	
	private Double cost;
	private Character delFlg;
	private Date createdOn;
	private Date updatedOn;
	private Integer createdBy;
	private Integer updatedBy;
	
	List<ProjectSpecificationDto> specificationList = new ArrayList<ProjectSpecificationDto>();
	List<ProjectSpecificationDto> amenitiesList = new ArrayList<ProjectSpecificationDto>();
	List<String> galleryImages = new ArrayList<>();
	List<String> floorImages = new ArrayList<>();
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the popertyName
	 */
	public String getPopertyName() {
		return popertyName;
	}
	/**
	 * @param popertyName the popertyName to set
	 */
	public void setPopertyName(String popertyName) {
		this.popertyName = popertyName;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the builderId
	 */
	public Integer getBuilderId() {
		return builderId;
	}
	/**
	 * @param builderId the builderId to set
	 */
	public void setBuilderId(Integer builderId) {
		this.builderId = builderId;
	}
	/**
	 * @return the stateId
	 */
	public Integer getStateId() {
		return stateId;
	}
	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the areaId
	 */
	public Integer getAreaId() {
		return areaId;
	}
	/**
	 * @param areaId the areaId to set
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * @return the siteAddress
	 */
	public String getSiteAddress() {
		return siteAddress;
	}
	/**
	 * @param siteAddress the siteAddress to set
	 */
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	/**
	 * @return the siteContactDetails
	 */
	public String getSiteContactDetails() {
		return siteContactDetails;
	}
	/**
	 * @param siteContactDetails the siteContactDetails to set
	 */
	public void setSiteContactDetails(String siteContactDetails) {
		this.siteContactDetails = siteContactDetails;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the catagory
	 */
	public String getCatagory() {
		return catagory;
	}
	/**
	 * @param catagory the catagory to set
	 */
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	/**
	 * @return the delFlg
	 */
	public Character getDelFlg() {
		return delFlg;
	}
	/**
	 * @return the amenitiesList
	 */
	public List<ProjectSpecificationDto> getAmenitiesList() {
		return amenitiesList;
	}
	/**
	 * @param amenitiesList the amenitiesList to set
	 */
	public void setAmenitiesList(List<ProjectSpecificationDto> amenitiesList) {
		this.amenitiesList = amenitiesList;
	}
	/**
	 * @return the specificationList
	 */
	public List<ProjectSpecificationDto> getSpecificationList() {
		return specificationList;
	}
	/**
	 * @param specificationList the specificationList to set
	 */
	public void setSpecificationList(List<ProjectSpecificationDto> specificationList) {
		this.specificationList = specificationList;
	}
	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(Character delFlg) {
		this.delFlg = delFlg;
	}
	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}
	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the panoramaImage
	 */
	public String getPanoramaImage() {
		return panoramaImage;
	}
	/**
	 * @param panoramaImage the panoramaImage to set
	 */
	public void setPanoramaImage(String panoramaImage) {
		this.panoramaImage = panoramaImage;
	}
	/**
	 * @return the galleryImages
	 */
	public List<String> getGalleryImages() {
		return galleryImages;
	}
	/**
	 * @param galleryImages the galleryImages to set
	 */
	public void setGalleryImages(List<String> galleryImages) {
		this.galleryImages = galleryImages;
	}
	/**
	 * @return the floorImages
	 */
	public List<String> getFloorImages() {
		return floorImages;
	}
	/**
	 * @param floorImages the floorImages to set
	 */
	public void setFloorImages(List<String> floorImages) {
		this.floorImages = floorImages;
	}
	/**
	 * @return the aboutUs
	 */
	public String getAboutUs() {
		return aboutUs;
	}
	/**
	 * @param aboutUs the aboutUs to set
	 */
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	
	
	
	
}
