package com.jsp.servlet_productManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-products")
public class AddProduct extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId=Integer.parseInt(req.getParameter("productId"));
		String productName=req.getParameter("productName");
		String productBrand=req.getParameter("productBrand");
		int productQuantity=Integer.parseInt(req.getParameter("productQuantity"));
		
		//JDBC LOGIC
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/porduct_management?user=root&password=Chandan1a@");
			
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");
			pst.setInt(1, productId);
			pst.setString(2, productName);
			pst.setString(3, productBrand);
			pst.setInt(4, productQuantity);
			
			pst.executeUpdate();
			
			
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
		
		resp.sendRedirect("index.jsp");
	}

}
