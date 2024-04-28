package com.hotel.dao;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	
	private HttpStatus httpStatus;
	private String message;
	
	//constructor from superclass
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	//constructor using fields
	public ErrorMessage(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	// getters and setters
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
