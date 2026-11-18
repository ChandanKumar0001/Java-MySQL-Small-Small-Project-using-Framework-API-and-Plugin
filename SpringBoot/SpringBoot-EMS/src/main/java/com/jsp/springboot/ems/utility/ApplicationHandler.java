package com.jsp.springboot.ems.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.ems.exception.EmployeeNotFoundByEmailException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundByGreaterThanException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundByIdException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundByNameException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundBySalaryException;
import com.jsp.springboot.ems.exception.NoEmployeeFoundException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handlerNoEmployeeFound(NoEmployeeFoundException ex){
		
		ErrorStructure<String> es= new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError(" Employees are not Found in Database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handlerEmployeeNotFoundById(EmployeeNotFoundByIdException ex){
		
		ErrorStructure<String> es= new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError(" The Requested Employee Id Not Present in Database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handlerEmployeeNotFoundByName(EmployeeNotFoundByNameException ex){
		
		ErrorStructure<String> es= new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError(" The Requested Employee name Not Present in Database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handlerEmployeeNotFoundByEmail(EmployeeNotFoundByEmailException ex){
		
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError("Requested Email employee not Present in DataBase ");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handlerEmployeeNotFoundBySalary(EmployeeNotFoundBySalaryException ex){
		
		
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError("The requested Salary Employee Not Present in Database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handlerEmployeeNotFoundByGreaterThan(EmployeeNotFoundByGreaterThanException ex){
		
		
		ErrorStructure<String> es = new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(ex.getMessage());
		es.setError("The requested Greater Than Salary Employee Not Present in Database");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}

}
