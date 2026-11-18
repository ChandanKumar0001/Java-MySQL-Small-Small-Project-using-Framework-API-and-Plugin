package com.jsp.springboot.ems.exception;

public class EmployeeNotFoundByNameException extends RuntimeException {
	
	private String Messsage;

	public String getMesssage() {
		return Messsage;
	}

	public EmployeeNotFoundByNameException(String messsage) {
		super();
		Messsage = messsage;
	}


}
