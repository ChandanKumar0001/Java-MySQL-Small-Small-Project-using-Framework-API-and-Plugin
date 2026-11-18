package com.jsp.springboot.ems.exception;


public class NoEmployeeFoundException extends RuntimeException {
	
	private String Messsage;

	public String getMesssage() {
		return Messsage;
	}

	public NoEmployeeFoundException(String messsage) {
		super();
		Messsage = messsage;
	}

	
	

}
