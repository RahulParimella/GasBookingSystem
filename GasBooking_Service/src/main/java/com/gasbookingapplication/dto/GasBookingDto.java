package com.gasbookingapplication.dto;

import java.time.LocalDate;

public class GasBookingDto {
	private int gasbookingId;

	private LocalDate bookingDate;

	private boolean status;

	private float bill;
	
	private CustomerDto customerDto;
	

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public int getGasbookingId() {
		return gasbookingId;
	}

	public void setGasbookingId(int gasbookingId) {
		this.gasbookingId = gasbookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	

	
	
}