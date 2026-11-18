package com.jsp.hibernate.employeedb.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.employeedb.entity.Employee;

public class EmployeeDao {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Scanner scan = new Scanner(System.in);
	
	public void addEmployee() {
		Employee employee = new Employee();
		System.out.println("Enter EmployeeId: ");
		employee.setEmployeeId(scan.nextInt());
		System.out.println("Enter the Name: ");
		employee.setEmployeeName(scan.next());
		System.out.println("Enter the Email: ");
		employee.setEmployeeEmail(scan.next());
		System.out.println("Enter the Designation: ");
		employee.setEmployeeDesignation(scan.next());
		System.out.println("Enter the Salary: ");
		employee.setEmployeeSalary(scan.nextInt());
		
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		session.save(employee);
		
		tran.commit();
		session.close();
		System.out.println("Data Inserted Successfully!!");
	}
	
	public void findEmployeeById() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		System.out.println("Enter the  Employee Id: ");
		Employee employee = session.get(Employee.class, scan.nextInt());
		
		if(employee != null)
			System.out.println(employee);
		else
			System.err.println("Employee not found by id");
		
		tran.commit();
		session.close();
	}
	
	public void updateEmployeeDescAndSalaryById() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		System.out.println("Enter the  Employee Id: ");
		Employee employee = session.get(Employee.class, scan.nextInt());
		
		if(employee != null) {
			System.out.println("Enter Updated Designation: ");
			employee.setEmployeeDesignation(scan.next());
			System.out.println("Enter Updated Salary: ");
			employee.setEmployeeSalary(scan.nextInt());
			
			session.update(employee);
			
			tran.commit();
			session.close();
			System.out.println("Data Updated Successfully!!");
		}
		else
			System.err.println("Employee not found by id");
	}
	
	public void deleteEmployeeById() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		System.out.println("Enter the  Employee Id: ");
		Employee employee = session.get(Employee.class, scan.nextInt());
		
		if(employee != null) {
			session.delete(employee);
			
			tran.commit();
			session.close();
			System.out.println("Data deleted Successfully!!");
		}
		else {
			System.err.println("Employee not found by id");
		}
	}
}
