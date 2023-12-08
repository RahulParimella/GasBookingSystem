package com.GasBookingApplication.Dto;

public class CustomerDto {

	private int customerId;
	
	private int cylinderid;
	
	private int bankId;
	
	private int accountNo;
	
	private String ifscNo;
	
	private String pan;
	
//	private BankDto bankDto;
//	
//	private CylinderDto cylinderDto;
//	
	
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(int customerId, int cylinderid, int bankId, int accountNo, String ifscNo, String pan) {
		super();
		this.customerId = customerId;
		this.cylinderid = cylinderid;
		this.bankId = bankId;
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

	public int getCylinderid() {
		return cylinderid;
	}

	public void setCylinderid(int cylinderid) {
		this.cylinderid = cylinderid;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
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

//	public BankDto getBankDto() {
//		return bankDto;
//	}
//
//	public void setBankDto(BankDto bankDto) {
//		this.bankDto = bankDto;
//	}
//
//	public CylinderDto getCylinderDto() {
//		return cylinderDto;
//	}
//
//	public void setCylinderDto(CylinderDto cylinderDto) {
//		this.cylinderDto = cylinderDto;
//	}
	
	
	

}
