package com.qsp.employee_managment_system.exception;

public class IncorrectPasswordException extends RuntimeException{
	private String message;

	public IncorrectPasswordException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
