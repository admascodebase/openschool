package com.admas.logiware.dto.response;

import java.util.List;

import com.admas.logiware.dto.ProductDto;

public class ProductResponse extends BaseLogiwareResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ProductDto> lProductDto;
	private ProductDto productDto;
	private Boolean result;
	/**
	 * @return the lProductDto
	 */
	public List<ProductDto> getlProductDto() {
		return lProductDto;
	}
	/**
	 * @return the productDto
	 */
	public ProductDto getProductDto() {
		return productDto;
	}
	/**
	 * @param lProductDto the lProductDto to set
	 */
	public void setlProductDto(List<ProductDto> lProductDto) {
		this.lProductDto = lProductDto;
	}
	/**
	 * @param productDto the productDto to set
	 */
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	/**
	 * @return the result
	 */
	public Boolean getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(Boolean result) {
		this.result = result;
	}
	

}
