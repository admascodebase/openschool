/*Copyright Currencies Direct Ltd 2015-2016. All rights reserved
worldwide. Currencies Direct Ltd PROPRIETARY/CONFIDENTIAL.*/
package com.admas.logiware.dto;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Sonal M.
 * 
 *         The Class RestResponse. Copyright Currencies Direct Ltd 2015-2016.
 */
public class RestResponse implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The status description. */
	private String status;

	/** The status code. */
	private ResponseStatusHeader responseStatusHeader;
	
	private List<String> headers;

	private Object data;

	private Integer totalPages;
	
	private String errorCode;
	
	private ResponseDto responseDto;
	
	private Integer listPageSize;
	
	private Long balanceId;
	
	private Map<String, Map<String, String>> RolesMap;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the responseStatusHeader
	 */
	public ResponseStatusHeader getResponseStatusHeader() {
		return responseStatusHeader;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param responseStatusHeader
	 *            the responseStatusHeader to set
	 */
	public void setResponseStatusHeader(
			ResponseStatusHeader responseStatusHeader) {
		this.responseStatusHeader = responseStatusHeader;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the headers
	 */
	public List<String> getHeaders() {
		return headers;
	}

	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}
	public void setResponseDto(ResponseDto responseDto) {
		this.responseDto = responseDto;
	}

	/**
	 * @return the listPageSize
	 */
	public Integer getListPageSize() {
		return listPageSize;
	}

	/**
	 * @param listPageSize the listPageSize to set
	 */
	public void setListPageSize(Integer listPageSize) {
		this.listPageSize = listPageSize;
	}

	/**
	 * @return the rolesMap
	 */
	public Map<String, Map<String, String>> getRolesMap() {
		return RolesMap;
	}

	/**
	 * @param rolesMap the rolesMap to set
	 */
	public void setRolesMap(Map<String, Map<String, String>> rolesMap) {
		RolesMap = rolesMap;
	}

	/**
	 * @return the balanceId
	 */
	public Long getBalanceId() {
		return balanceId;
	}

	/**
	 * @param balanceId the balanceId to set
	 */
	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

	
	
}
