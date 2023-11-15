package com.example.applicationConfig.exceptions;

public class AlreadyExistsException  extends RuntimeException{
	private String message;

	public AlreadyExistsException(String message) {
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
