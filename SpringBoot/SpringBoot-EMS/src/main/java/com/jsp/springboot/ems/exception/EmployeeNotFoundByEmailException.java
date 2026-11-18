package com.jsp.springboot.ems.exception;

public class EmployeeNotFoundByEmailException extends RuntimeException {
	
	private String message;

	public EmployeeNotFoundByEmailException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
