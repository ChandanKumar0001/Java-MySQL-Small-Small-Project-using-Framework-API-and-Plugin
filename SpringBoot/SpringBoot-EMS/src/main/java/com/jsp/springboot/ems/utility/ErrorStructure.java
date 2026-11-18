package com.jsp.springboot.ems.utility;

public class ErrorStructure<T> {
	
	private int errorCode;
	private String Message;
	private T error;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public T getError() {
		return error;
	}
	public void setError(T error) {
		this.error = error;
	}
	

}
