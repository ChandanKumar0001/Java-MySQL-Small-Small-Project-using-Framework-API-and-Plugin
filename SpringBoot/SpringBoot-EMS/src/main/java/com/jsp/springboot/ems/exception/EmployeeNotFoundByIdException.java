package com.jsp.springboot.ems.exception;

public class EmployeeNotFoundByIdException extends RuntimeException {
	

	private String Messsage;

	public String getMesssage() {
		return Messsage;
	}

	public EmployeeNotFoundByIdException(String messsage) {
		super();
		Messsage = messsage;
	}
	
	

}
