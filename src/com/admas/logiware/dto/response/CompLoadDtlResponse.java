package com.admas.logiware.dto.response;

import java.util.List;

import com.admas.logiware.dto.CompProductDto;
import com.admas.logiware.dto.CompanyLoadDetailDto;

public class CompLoadDtlResponse extends BaseLogiwareResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CompanyLoadDetailDto> lCompanyLoadDetailDtos;
	private CompanyLoadDetailDto companyLoadDetailDto;
	private Boolean result;


	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	/**
	 * @return the lCompanyLoadDetailDtos
	 */
	public List<CompanyLoadDetailDto> getlCompanyLoadDetailDtos() {
		return lCompanyLoadDetailDtos;
	}

	/**
	 * @param lCompanyLoadDetailDtos the lCompanyLoadDetailDtos to set
	 */
	public void setlCompanyLoadDetailDtos(List<CompanyLoadDetailDto> lCompanyLoadDetailDtos) {
		this.lCompanyLoadDetailDtos = lCompanyLoadDetailDtos;
	}

	/**
	 * @return the companyLoadDetailDto
	 */
	public CompanyLoadDetailDto getCompanyLoadDetailDto() {
		return companyLoadDetailDto;
	}

	/**
	 * @param companyLoadDetailDto the companyLoadDetailDto to set
	 */
	public void setCompanyLoadDetailDto(CompanyLoadDetailDto companyLoadDetailDto) {
		this.companyLoadDetailDto = companyLoadDetailDto;
	}

}
