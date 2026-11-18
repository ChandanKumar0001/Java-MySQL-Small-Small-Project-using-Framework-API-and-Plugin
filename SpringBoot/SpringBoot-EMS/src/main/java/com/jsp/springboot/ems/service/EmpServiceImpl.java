package com.jsp.springboot.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot.ems.entity.Employee;
import com.jsp.springboot.ems.exception.EmployeeNotFoundByEmailException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundByGreaterThanException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundByIdException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundByNameException;
import com.jsp.springboot.ems.exception.EmployeeNotFoundBySalaryException;
import com.jsp.springboot.ems.exception.NoEmployeeFoundException;

import com.jsp.springboot.ems.repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee employees = employeeRepository.save(employee);
		return employees;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> rs = employeeRepository.findAll();
		if (rs.isEmpty()) {
			throw new NoEmployeeFoundException(" No Employee Present in database");
		} else
			return rs;
	}

	@Override
	public Employee findbyId(int employeeId) {
		Optional<Employee> optionalemp = employeeRepository.findById(employeeId);

		if (optionalemp.isPresent()) {
			Employee employee = optionalemp.get();
			return employee;
		} else
			throw new EmployeeNotFoundByIdException(" Employee not found by this Id");
	}

	@Override
	public Employee updateEmloyee(int employeeId, Employee upEmployee) {
		Optional<Employee> optionalemp = employeeRepository.findById(employeeId);

		if (optionalemp.isPresent()) {
			Employee existingEmp = optionalemp.get();
			upEmployee.setEmployeeId(existingEmp.getEmployeeId());
			return employeeRepository.save(upEmployee);
		}else
		throw new EmployeeNotFoundByIdException(" Employee not found by this Id");
	}

	@Override
	public Employee deleteById(int employeeId) {
		Optional<Employee> optionalemp = employeeRepository.findById(employeeId);
		if (optionalemp.isPresent()) {
			Employee employee = optionalemp.get();
			employeeRepository.delete(employee);
			return employee;
		} else {
			throw new EmployeeNotFoundByIdException(" Employee not found by this Id");
		}
	}

	@Override
	public List<Employee> findByEmployeeName(String employeeName) {
	  List<Employee> optional = employeeRepository.findByEmployeeNames(employeeName);
	  
	  if(optional.isEmpty()) {
		throw new EmployeeNotFoundByNameException("Employees Not present in requested By name");
	  }else
		  return optional;
	}

	@Override
	public Employee findByEmail(String mail) {
		Optional<Employee> optional = employeeRepository.findByEmails(mail);
		
		if(optional.isPresent()) {
			Employee employee = optional.get();
			return employee;
		}else
			throw new EmployeeNotFoundByEmailException("Employee not presented by this email");
	}

	@Override
	public List<Employee> findBySalary(int salary) {
       List<Employee> emplst  = employeeRepository.findBySalaryes(salary);
       if(emplst.isEmpty()) {
		throw new EmployeeNotFoundBySalaryException("There is no employee on this Salary");
       }
       else {
    	   return emplst;
    	   
       }
	}

	@Override
	public List<Employee> findBySalaryGreaterThan(int salary) {
		List<Employee> emplst = employeeRepository.findBySalaryGreaterThan(salary);
		
		if(emplst.isEmpty()) {
		throw new EmployeeNotFoundByGreaterThanException("No Employees Found on this greater then salary");
		}else
			return emplst;
	}
	

}
