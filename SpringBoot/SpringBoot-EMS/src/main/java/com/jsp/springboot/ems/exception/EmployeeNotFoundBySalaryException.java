package com.jsp.springboot.ems.exception;

public class EmployeeNotFoundBySalaryException extends RuntimeException {

	private String message;

	public EmployeeNotFoundBySalaryException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
