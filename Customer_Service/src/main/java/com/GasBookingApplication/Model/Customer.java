package com.GasBookingApplication.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Customer_microservice")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int customerId;
	
	private int cylinderid;
	
	private int bankId;
	 @NotEmpty
		@Size(min = 3, message = "bankid should have at least 3 numbers")
		@Column(name="bankname")
	private int accountNo;
	
	private String ifscNo;
	
	private String pan;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, int cylinderid, int bankId, int accountNo, String ifscNo, String pan) {
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
	
	
}
