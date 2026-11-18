package com.jsp.hibernate.employeedb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int EmployeeId;
	private String EmployeeName;
	private String EmployeeEmail;
	private String EmployeeDesignation;
	private int EmployeeSalary;
	
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.EmployeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.EmployeeEmail = employeeEmail;
	}
	public String getEmployeeDesignation() {
		return EmployeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.EmployeeDesignation = employeeDesignation;
	}
	public int getEmployeeSalary() {
		return EmployeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.EmployeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeEmail="
				+ EmployeeEmail + ", EmployeeDesignation=" + EmployeeDesignation + ", EmployeeSalary=" + EmployeeSalary
				+ "]";
	}
	
	
}
