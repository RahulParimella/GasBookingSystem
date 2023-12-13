package com.GasBookingApplication.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class SurrenderCylinderException {

	private Date timestamp;
	
	private String message;
	
	private String details;

	

	public SurrenderCylinderException(Date timestamp, String message, String details) {
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
