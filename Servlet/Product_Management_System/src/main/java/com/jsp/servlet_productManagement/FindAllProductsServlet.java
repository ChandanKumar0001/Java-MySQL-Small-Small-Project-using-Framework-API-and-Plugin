package com.jsp.servlet_productManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class FindAllProductsServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Map<String,Object>> products = this.fetchAllProducts();
		
		if(products != null) {
			req.setAttribute("list",products);
			req.getRequestDispatcher("display.jsp").forward(req, resp);
		}else {
			System.err.println("No products Found");
		}
	}
	
	private  List<Map<String,Object>> fetchAllProducts() {
		Connection connection=null;
		List<Map<String, Object>> products = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/porduct_management?user=root&password=Chandan1a@");
			String query = "SELECT * FROM product";
			Statement st = connection1.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				Map<String, Object> product = new HashMap<>();
				
				product.put("productId", resultSet.getInt(1));
				product.put("productName", resultSet.getString(2));
				product.put("productBrand", resultSet.getString(3));
				product.put("productQuantity", resultSet.getInt(4));
				
				products.add(product);
			}
			
			return products;
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
