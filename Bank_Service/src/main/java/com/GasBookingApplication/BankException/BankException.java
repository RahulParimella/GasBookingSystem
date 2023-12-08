package com.GasBookingApplication.BankException;

import org.springframework.http.HttpStatus;

public class BankException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpstatus;
	public BankException(String message, Throwable throwable, HttpStatus httpstatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
	}
	public String getMessage() {
		return message;
	}
	public Throwable getThrowable() {
		return throwable;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
}
