package com.admas.logiware.dto.response;

import java.util.List;

import com.admas.logiware.dto.CompanyLoadToTransDto;

public class CompLoadToTransResponse extends BaseLogiwareResponse {

	private static final long serialVersionUID = 1L;

	private List<CompanyLoadToTransDto> lCompanyLoadToTransDtos;
	private CompanyLoadToTransDto companyLoadToTransDto;
	private Boolean result;


	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	/**
	 * @return the lCompanyLoadToTransDtos
	 */
	public List<CompanyLoadToTransDto> getlCompanyLoadToTransDtos() {
		return lCompanyLoadToTransDtos;
	}

	/**
	 * @param lCompanyLoadToTransDtos the lCompanyLoadToTransDtos to set
	 */
	public void setlCompanyLoadToTransDtos(
			List<CompanyLoadToTransDto> lCompanyLoadToTransDtos) {
		this.lCompanyLoadToTransDtos = lCompanyLoadToTransDtos;
	}

	/**
	 * @return the companyLoadToTransDto
	 */
	public CompanyLoadToTransDto getCompanyLoadToTransDto() {
		return companyLoadToTransDto;
	}

	/**
	 * @param companyLoadToTransDto the companyLoadToTransDto to set
	 */
	public void setCompanyLoadToTransDto(CompanyLoadToTransDto companyLoadToTransDto) {
		this.companyLoadToTransDto = companyLoadToTransDto;
	}

	

	
}
