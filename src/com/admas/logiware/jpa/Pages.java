package com.admas.logiware.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pages")
public class Pages implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4729095249074751458L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME" ,nullable = false )
	private String name;
	
	@Column(name="INDEX_NO" ,nullable = false )
	private Integer indexNo;
	
	@Column(name="URI" ,nullable = false )
	private String uri;
	
	@Column(name="TAB_ID" ,nullable = false )
	private Integer tabId;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the indexNo
	 */
	public Integer getIndexNo() {
		return indexNo;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @return the tabId
	 */
	public Integer getTabId() {
		return tabId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param indexNo the indexNo to set
	 */
	public void setIndexNo(Integer indexNo) {
		this.indexNo = indexNo;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @param tabId the tabId to set
	 */
	public void setTabId(Integer tabId) {
		this.tabId = tabId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pages [id=" + id + ", name=" + name + ", indexNo=" + indexNo
				+ ", uri=" + uri + ", tabId=" + tabId + "]";
	}
	
	
}
