package com.GasBookingApplication.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cylinder_microservice")
public class Cylinder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int cylinderid;
	
	@Column(name="cylindertype")
	private String type;
	
	@Column(name="cylinderweight")
	private float weight;
	
	@Column(name="cylindercolor")
	private String strapColor;
	
	@Column(name="cylinderprice")
	private float price;

	public Cylinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cylinder(int cylinderid, String type, float weight, String strapColor, float price) {
		super();
		this.cylinderid = cylinderid;
		this.type = type;
		this.weight = weight;
		this.strapColor = strapColor;
		this.price = price;
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
	
	
}
