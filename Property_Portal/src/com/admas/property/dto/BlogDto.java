package com.admas.property.dto;

import java.util.Date;

public class BlogDto {
	
	public BlogDto(){
		
	}
	
	private Integer blogId;
	private Integer builderId;
	private Integer projId;
	private String blogTitle;
	private Date blogDate;
	private String authorName;
	private String blog;
	/**
	 * @return the blogId
	 */
	public Integer getBlogId() {
		return blogId;
	}
	/**
	 * @param blogId the blogId to set
	 */
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
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
	 * @return the projId
	 */
	public Integer getProjId() {
		return projId;
	}
	/**
	 * @param projId the projId to set
	 */
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	/**
	 * @return the blogTitle
	 */
	public String getBlogTitle() {
		return blogTitle;
	}
	/**
	 * @param blogTitle the blogTitle to set
	 */
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	/**
	 * @return the blogDate
	 */
	public Date getBlogDate() {
		return blogDate;
	}
	/**
	 * @param blogDate the blogDate to set
	 */
	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the blog
	 */
	public String getBlog() {
		return blog;
	}
	/**
	 * @param blog the blog to set
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}


	
}
