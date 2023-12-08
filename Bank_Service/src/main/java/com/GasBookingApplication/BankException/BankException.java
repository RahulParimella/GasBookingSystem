package com.GasBookingApplication.BankException;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class BankException {
	private Date timestamp;

	private String message;

	private String details;

	public BankException(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}	
}
