package com.admas.property.dto;

import java.sql.Date;

public class VideoDto {
	
	public VideoDto(){
		
	}

	public Integer id;
	public Integer builderId;
	public Integer priprojectId;
	public String url;
	public Integer delFlg;
	public Date createdOn;
	public Integer createdBy;
	public Date updateOn;
	public Integer updatedBy;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuilderId() {
		return builderId;
	}
	public void setBuilderId(Integer builderId) {
		this.builderId = builderId;
	}
	public Integer getPriprojectId() {
		return priprojectId;
	}
	public void setPriprojectId(Integer priprojectId) {
		this.priprojectId = priprojectId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(Integer delFlg) {
		this.delFlg = delFlg;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

}
