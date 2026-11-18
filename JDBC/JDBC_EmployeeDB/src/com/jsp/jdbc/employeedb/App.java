package com.jsp.jdbc.employeedb;

import java.util.Scanner;

import com.jsp.jdbc.employee.dao.EmployeeDAO;


public class App {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO e=new EmployeeDAO();

		System.out.println("Enter the Operation to perform on database ");
		System.out.println("Enter 1<-- To Add Employee");
		System.out.println("Enter 2<-- To Find the Employee Details Based On Name");
		System.out.println("Enter 3<-- To Find the Employee Based on Salary Range ");
		System.out.println("Enter 4<-- To Update Employee Salary Based on Designation");
		System.out.println("Enter 5<-- To Delete Employee Based On ID");
		switch(sc.nextInt())
		{
		case 1: System.out.println("Enter the Employee Details to be Insert");
				System.out.println("Enter the EmployeeId: ");
				int employeeId=sc.nextInt();
				System.out.println("Enter the Employee Name: ");
				String employeeName=sc.next();
				System.out.println("Enter the Employee Email: ");
				String employeeEmail=sc.next();
				System.out.println("Enter the Employee Designation: ");
				String employeeDesc=sc.next();
				System.out.println("Enter the Employee Salary: ");
				int employeeSalary=sc.nextInt();
				e.addEmployee(EmployeeDAO.buildConnection(), employeeId, employeeName, employeeEmail, 
					  employeeDesc, employeeSalary);
				break;
		case 2: System.out.println("Enter the Employee Name to Fetch Details");
				String empName=sc.next();
				e.findEmployeeByName(EmployeeDAO.buildConnection(), empName);
				break;
		case 3:	System.out.println("Enter the Salaries ");
				System.out.println("Enter the LowSalary: ");
				int lowSalary=sc.nextInt();
				System.out.println("Enter the HighSalary");
				int highSalary=sc.nextInt();
				e.findEmployeeWithSalaryBetween(EmployeeDAO.buildConnection(), lowSalary, highSalary);
				break;
		case 4: System.out.println("Enter the Employee Designation to Update Salary");
				String employeeDesignation=sc.next();
				e.updateEmployeeSalaryByDesc(EmployeeDAO.buildConnection(), employeeDesignation);
		case 5: System.out.println("Enter the Employee Id to Delete Employee Details");
				int eId=sc.nextInt();
				e.deleteEmployeeById(EmployeeDAO.buildConnection(), eId);
				break;
		}

		sc.close();
	}


}
