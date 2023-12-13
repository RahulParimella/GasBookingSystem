package com.GasBookingApplication.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CylinderDto {

	private int cylinderid;

	@NotEmpty
	@Size(min = 2, message = "Type should have at least 2 characters")
	private String type;

	@NotEmpty
	private float weight;

	@NotEmpty
	@Size(min = 2, message = "strapcolor should have at least 2 characters")

	private String strapColor;

	@NotEmpty
	private float price;

	
	
	public CylinderDto(int cylinderid,
			@NotEmpty @Size(min = 2, message = "Type should have at least 2 characters") String type,
			@NotEmpty float weight,
			@NotEmpty @Size(min = 2, message = "strapcolor should have at least 2 characters") String strapColor,
			@NotEmpty float price) {
		super();
		this.cylinderid = cylinderid;
		this.type = type;
		this.weight = weight;
		this.strapColor = strapColor;
		this.price = price;
	}

	public CylinderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCylinderid() {
		return cylinderid;
	}

	public void setCylinderid(int cylinderid) {
		this.cylinderid = cylinderid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getStrapColor() {
		return strapColor;
	}

	public void setStrapColor(String strapColor) {
		this.strapColor = strapColor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	

	@Override
	public String toString() {
		return "CylinderDto [cylinderid=" + cylinderid + ", type=" + type + ", weight=" + weight + ", strapColor="
				+ strapColor + ", price=" + price + "]";
	}

}
