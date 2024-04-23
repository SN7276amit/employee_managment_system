package com.qsp.employee_managment_system.exception;

public class PhoneNotFoundException extends RuntimeException {
	private String message;

	public PhoneNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
