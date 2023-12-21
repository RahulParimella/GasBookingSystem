package com.GasBookingApplication.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_microservice")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int customerId;

	@Column(name = "AccNo")
	private int accountNo;

	
	@Column(name = "IFSCNo")
	private String ifscNo;

	
	@Column(name = "PanNo")
	private String pan;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer( int accountNo, String ifscNo, String pan) {
		super();
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