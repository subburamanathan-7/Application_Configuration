package com.example.applicationConfig.exceptions;

public class DataMisMatchException  extends RuntimeException {

	private String message;

	public DataMisMatchException(String message) {
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
