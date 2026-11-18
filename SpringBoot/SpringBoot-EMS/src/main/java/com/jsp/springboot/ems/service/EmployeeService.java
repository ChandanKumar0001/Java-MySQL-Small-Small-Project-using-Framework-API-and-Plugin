package com.jsp.springboot.ems.service;

import java.util.List;

import com.jsp.springboot.ems.entity.Employee;

public interface EmployeeService {

   public 	Employee addEmployee(Employee employee);
    
	List<Employee> findAll();

	public Employee findbyId(int employeeId);

	public Employee updateEmloyee(int employeeId, Employee upEmployee);

	public Employee deleteById(int employeeId);

	public List<Employee> findByEmployeeName(String employeeName);

	public Employee findByEmail(String mail);

	public List<Employee> findBySalary(int salary);

	public List<Employee> findBySalaryGreaterThan(int salary);
}
