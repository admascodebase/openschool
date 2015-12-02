package com.admas.logiware.dto.response;

import java.util.List;

import com.admas.logiware.dto.CompProductDto;

public class CompProductResponse extends BaseLogiwareResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CompProductDto> lProductDto;
	private CompProductDto compProductDto;
	private Boolean result;

	public List<CompProductDto> getlProductDto() {
		return lProductDto;
	}

	public void setlProductDto(List<CompProductDto> lProductDto) {
		this.lProductDto = lProductDto;
	}

	public CompProductDto getCompProductDto() {
		return compProductDto;
	}

	public void setCompProductDto(CompProductDto compProductDto) {
		this.compProductDto = compProductDto;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

}
