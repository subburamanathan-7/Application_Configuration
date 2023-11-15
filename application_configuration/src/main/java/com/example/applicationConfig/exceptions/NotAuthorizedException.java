package com.example.applicationConfig.exceptions;

public class NotAuthorizedException extends RuntimeException {

	private String message;

	public NotAuthorizedException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
