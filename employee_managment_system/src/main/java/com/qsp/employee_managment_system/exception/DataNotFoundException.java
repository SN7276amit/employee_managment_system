package com.qsp.employee_managment_system.exception;

public class DataNotFoundException extends RuntimeException{
	private String message;

	public DataNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
