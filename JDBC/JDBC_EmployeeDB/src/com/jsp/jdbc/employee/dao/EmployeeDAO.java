package com.jsp.jdbc.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
	public static Connection buildConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb?user=root&password=Chandan1a@");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return conn;	
	}

	public  void addEmployee(Connection conn,int employeeId,String employeeName,String employeeEmail,
			String employeeDesignation,int employeeSalary) {
		try{
			PreparedStatement pst=conn.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?)");

			pst.setInt(1,employeeId);
			pst.setString(2,employeeName);
			pst.setString(3, employeeEmail);
			pst.setString(4, employeeDesignation);
			pst.setInt(5, employeeSalary);

			int rowsInserted= pst.executeUpdate();

			if(rowsInserted>0) {
				System.out.println(rowsInserted+" Data Inserted");
			}
			else {
				System.out.println("Data not Inserted");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public  void findEmployeeByName(Connection conn,String employeeName) {
		try{
			PreparedStatement pst=conn.prepareStatement("SELECT * FROM employee WHERE employeeName=?");

			pst.setString(1, employeeName);

			boolean employee=pst.execute();
			if(employee) {
				System.out.println("Employee is Present");
			}
			else {
				System.out.println("Employee not Found!!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public void findEmployeeWithSalaryBetween(Connection conn,int lowsalary,int highsalary) {
		try{
			PreparedStatement pst=conn.prepareStatement("SELECT * FROM employee WHERE employeeSalary BETWEEN ? AND ? ");
			pst.setInt(1, lowsalary);
			pst.setInt(2,highsalary);

			boolean employee=pst.execute();
			if(employee) {
				System.out.println("Employee are found");
			}
			else {
				System.out.println("Employee not found");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public void updateEmployeeSalaryByDesc(Connection conn ,String employeeDesc) {
		try{
			PreparedStatement pst=conn.prepareStatement("UPDATE employee SET employeeSalary=(employeeSalary+50000) WHERE employeeDesc=?");

			pst.setString(1,employeeDesc);

			int rowsUpdated=pst.executeUpdate();
			if(rowsUpdated>0) {
				System.out.println(rowsUpdated+" Data Updated");
			}
			else {
				System.out.println("Data not Updated!!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public void deleteEmployeeById(Connection conn,int employeeId) {
		try{
			PreparedStatement pst=conn.prepareStatement("DELETE FROM employee WHERE employeeId=?");

			pst.setInt(1, employeeId);
			int rowsDeleted=pst.executeUpdate();
			if(rowsDeleted>0) {
				System.out.println(rowsDeleted+" Data Deleted");
			}
			else {
				System.out.println("Data not Deleted");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

}
