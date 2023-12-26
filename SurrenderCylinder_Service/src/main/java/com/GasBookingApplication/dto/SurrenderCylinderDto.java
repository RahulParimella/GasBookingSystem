package com.GasBookingApplication.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class SurrenderCylinderDto {

	private int surrenderId;

	@NotNull(message = "Date cannot be null")
	private LocalDate surrenderDate;
	
//	
	private CustomerDto customerDto;
	
	private CylinderDto cylinderDto;

	public SurrenderCylinderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurrenderCylinderDto(@NotNull(message = "Date cannot be null") LocalDate surrenderDate) {
		super();
		this.surrenderDate = surrenderDate;
	}

	public int getSurrenderId() {
		return surrenderId;
	}

	public void setSurrenderId(int surrenderId) {
		this.surrenderId = surrenderId;
	}

	public LocalDate getSurrenderDate() {
		return surrenderDate;
	}

	public void setSurrenderDate(LocalDate surrenderDate) {
		this.surrenderDate = surrenderDate;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public CylinderDto getCylinderDto() {
		return cylinderDto;
	}

	public void setCylinderDto(CylinderDto cylinderDto) {
		this.cylinderDto = cylinderDto;
	}
	
	


	
	
}
