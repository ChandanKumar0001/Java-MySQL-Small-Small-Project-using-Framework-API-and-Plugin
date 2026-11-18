package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DeleteEmployeeServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int employeeId=Integer.parseInt(req.getParameter("employeeId"));

		//JDBC LOGIC
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employeedb?user=root&password=Chandan1a@");

			PreparedStatement pst=conn.prepareStatement("DELETE FROM employeedb  WHERE employeeId=? ");
			pst.setInt(1, employeeId);
			int rowsDeleted=pst.executeUpdate();

			PrintWriter pw=res.getWriter();

			if(rowsDeleted>0) {
				pw.print("<h1>"+rowsDeleted+" data Deleted!! </h1>");
			}
			else {
				pw.print(" <h1>Data Not Deleted</h1>");
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
