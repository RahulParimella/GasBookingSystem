package com.GasBookingApplication.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Bank_microservice")
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bankid")
	private int bankId;
	
	@Column(name="bankname")
	private String bankName;
	
	@Column(name="bankaddress")
	private String address;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int bankId, String bankName, String address) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.address = address;
	}

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
