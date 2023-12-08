package com.GasBookingApplication.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class BankDto {

    private int bankId;
    @NotEmpty
	@Size(min = 2, message = "bankname should have at least 2 characters")
	@Column(name="bankname")
	private String bankName;

	@NotEmpty
	@Size(min = 2, message = "bankname should have at least 2 characters")
	@Column(name = "bankaddress")
	private String address;

//	public BankDto() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

//	public BankDto(String bankName, String address) {
//		super();
//		this.bankName = bankName;
//		this.address = address;
//	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	


	
}
