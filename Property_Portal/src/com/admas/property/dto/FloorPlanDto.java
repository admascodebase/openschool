package com.admas.property.dto;

public class FloorPlanDto {
	
	public FloorPlanDto(){
		
	}
	
	public String flatType;
	public float areaSqFt;
	public Integer price;
	public String description;
	
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public float getAreaSqFt() {
		return areaSqFt;
	}
	public void setAreaSqFt(float areaSqFt) {
		this.areaSqFt = areaSqFt;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
