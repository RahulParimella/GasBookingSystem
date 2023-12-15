package com.GasBookingApplication.Dto;

import java.util.List;

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

	
	private CylinderDto cylinderDto;

	private BankDto bankDto;
	
	private SurrenderCylinderDto surrenderDto;
	
	private List<GasBookingDto> gasbookingDto;
	
	

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(int customerId, @Positive(message = "Account number must be a positive integer") int accountNo,
			@NotEmpty @Size(min = 2, message = "ifsc should have at least 2 characters") String ifscNo,
			@NotEmpty @Size(min = 2, message = "pan number should have at least 2 characters") String pan
			) {
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

	public CylinderDto getCylinderDto() {
		return cylinderDto;
	}

	public void setCylinderDto(CylinderDto cylinderDto) {
		this.cylinderDto = cylinderDto;
	}

	public BankDto getBankDto() {
		return bankDto;
	}

	public void setBankDto(BankDto bankDto) {
		this.bankDto = bankDto;
	}

	public SurrenderCylinderDto getSurrenderDto() {
		return surrenderDto;
	}

	public void setSurrenderDto(SurrenderCylinderDto surrenderDto) {
		this.surrenderDto = surrenderDto;
	}

	public List<GasBookingDto> getGasbookingDto() {
		return gasbookingDto;
	}

	public void setGasbookingDto(List<GasBookingDto> gasbookingDto) {
		this.gasbookingDto = gasbookingDto;
	}

	

}
