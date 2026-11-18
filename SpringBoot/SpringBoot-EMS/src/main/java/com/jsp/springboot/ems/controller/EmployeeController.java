package com.jsp.springboot.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.ems.entity.Employee;
import com.jsp.springboot.ems.service.EmployeeService;
import com.jsp.springboot.ems.utility.ResponseStructure;


@Controller
@ResponseBody
@RestController
@RequestMapping("/employees") // super annotation of above one and two annotation. it contain both.
public class EmployeeController {

	@Autowired
	private EmployeeService employeservice;

	@PostMapping
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee) {
		Employee employees = employeservice.addEmployee(employee);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Employee Object added successffully");
		structure.setData(employees);
		

		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);

	}

	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {

		List<Employee> employeelst = employeservice.findAll();

		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<List<Employee>>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Employee Objectes Fethed Sccessfully");
		responseStructure.setData(employeelst);

		return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure, HttpStatus.FOUND);
	}
	
	@GetMapping("/id")
	public ResponseEntity<ResponseStructure<Employee>>findbyId(int employeeId) {
		Employee employee = employeservice.findbyId(employeeId);

		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Employee Fetched By ID Successfully");
		responseStructure.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.FOUND);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int employeeId, @RequestBody Employee upEmployee) {
		Employee employee= employeservice.updateEmloyee(employeeId, upEmployee);

		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Employee Object Update Successfuly By Employee Id");
		responseStructure.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
	}
	
	

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Employee>>deleteById(int employeeId) {
		Employee employee=employeservice.deleteById(employeeId);

		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Employee Object Deleted Successfully By Employee ID");
		responseStructure.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
	}
	
	@GetMapping("/name")
    public ResponseEntity<ResponseStructure<List<Employee>>> findByEmpmloyeeName(String employeeName){
		
		List<Employee> emplst =employeservice.findByEmployeeName(employeeName);
		
		ResponseStructure<List<Employee>> responseStructure=new ResponseStructure<List<Employee>>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Employee founded By Name Successsfully");
		responseStructure.setData(emplst);
		
		return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure,HttpStatus.FOUND);
		
	}
    @GetMapping("/mail/{mail}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmail(@PathVariable String  mail){
		Employee employees = employeservice.findByEmail(mail);
		
		ResponseStructure<Employee> responseStructure =new ResponseStructure<Employee>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Employee Object fetched Successfully");
		responseStructure.setData(employees);
		
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.FOUND);
	}
    
    @GetMapping("/salary/{salary}")
    public ResponseEntity<ResponseStructure<List<Employee>>> findBySalary(@PathVariable int salary){
    	
    	List<Employee> emplst= employeservice.findBySalary(salary);
    	
    	ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<List<Employee>>();
    	responseStructure.setStatusCode(HttpStatus.FOUND.value());
    	responseStructure.setMessage("Employee Object fetched Sucessfully");
    	responseStructure.setData(emplst);
    	
    	return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure,HttpStatus.FOUND);
    }
    @GetMapping("/greater/{salary}")
    public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryGreaterThan(@PathVariable int  salary){
    	
    	List<Employee> emplst = employeservice.findBySalaryGreaterThan(salary);
    	
    	ResponseStructure<List<Employee>> responseStructre = new ResponseStructure<List<Employee>>();
    	responseStructre.setStatusCode(HttpStatus.FOUND.value());
    	responseStructre.setStatusCode(HttpStatus.FOUND.value());
    	responseStructre.setMessage("Employee Object fetched by greater than salary Successfully");
    	responseStructre.setData(emplst);
    	
    	return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructre,HttpStatus.FOUND);
 	
    }
}
