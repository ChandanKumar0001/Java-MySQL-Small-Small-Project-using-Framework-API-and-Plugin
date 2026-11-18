package com.jsp.springboot.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springboot.ems.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	@Query("SELECT e FROM Employee e WHERE e.employeeName=?1")
	public List<Employee> findByEmployeeNames(String employeeName);

	
	@Query("SELECT e FROM Employee e WHERE e.mail=?1")
	public Optional<Employee> findByEmails(String mail);

     @Query(  value ="SELECT * FROM employee WHERE salary=?1",nativeQuery = true)
	public List<Employee> findBySalaryes(int salary);


	public List<Employee> findBySalaryGreaterThan(int salary);
	
	
	
	

}
