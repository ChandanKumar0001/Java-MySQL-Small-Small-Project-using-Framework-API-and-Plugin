package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FindEmployeServlet extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int employeeId=Integer.parseInt(req.getParameter("employeeId"));

		//JDBC LOGIC
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb?user=root&password=Chandan1a@");

			PreparedStatement pst=conn.prepareStatement("SELECT * FROM employeedb  WHERE employeeId=? ");
			pst.setInt(1, employeeId);

			ResultSet rs= pst.executeQuery();
			PrintWriter pw=res.getWriter();

			while(rs.next()) {
				int empId=rs.getInt(1);
				String empName=rs.getString(2);
				String empEmail=rs.getString(3);
				int empSalary=rs.getInt(4);
				pw.print("<h1>EmployeeID : </h1> <h2>"+ empId+"</h2> <h1> EmployeeName :</h1><h2> "+ empName+"</h2> <h1> EmployeeEmail :</h1><h2> "+empEmail+"</h2> <h1> EmployeeSalary :</h1><h2> "+empSalary+" </h2>");
			}

		} 
		catch (ClassNotFoundException | SQLException e) {
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
