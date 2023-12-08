package com.GasBookingApplication.BankException;


public class BankNotFoundException extends RuntimeException {



	public BankNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public BankNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}

}
