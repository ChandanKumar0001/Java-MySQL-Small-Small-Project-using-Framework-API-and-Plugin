package com.jsp.springboot.ems.exception;

public class EmployeeNotFoundByGreaterThanException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	

	public EmployeeNotFoundByGreaterThanException(String message) {
		super();
		this.message = message;
	}

}
