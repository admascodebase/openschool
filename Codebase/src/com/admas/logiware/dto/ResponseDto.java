package com.admas.logiware.dto;

import java.util.List;

public class ResponseDto implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer total_rows = 0;
	private List<String> headers;
	private List<Integer> idsForRowsReturned;
	private String resultType;
	private String error;
	
	
	public Integer getTotal_rows() {
		return total_rows;
	}

	public void setTotal_rows(Integer total_rows) {
		this.total_rows = total_rows;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public List<Integer> getIdsForRowsReturned() {
		return idsForRowsReturned;
	}

	public void setIdsForRowsReturned(List<Integer> idsForRowsReturned) {
		this.idsForRowsReturned = idsForRowsReturned;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
	

}