package com.gasbookingapplication.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CustomerDto {

	private int customerId;

	@Positive(message = "Account number must be a positive integer")

	private int accountNo;

	@NotEmpty
	@Size(min = 2, message = "ifsc should have at least 2 characters")

	private String ifscNo;

	@NotEmpty
	@Size(min = 2, message = "pan number should have at least 2 characters")

	private String pan;

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(int customerId, @Positive(message = "Account number must be a positive integer") int accountNo,
			@NotEmpty @Size(min = 2, message = "ifsc should have at least 2 characters") String ifscNo,
			@NotEmpty @Size(min = 2, message = "pan number should have at least 2 characters") String pan) {
		super();
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.ifscNo = ifscNo;
		this.pan = pan;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfscNo() {
		return ifscNo;
	}

	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

}