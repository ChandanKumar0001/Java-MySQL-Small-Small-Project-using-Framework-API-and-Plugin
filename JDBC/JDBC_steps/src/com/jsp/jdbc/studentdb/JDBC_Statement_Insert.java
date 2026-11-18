package com.jsp.jdbc.studentdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class JDBC_Statement_Insert {

	public static void main(String[] args) {
		
		try {
			//Step-1: Load and Register the Driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			//Step-2 Establish the connection
			Connection conn = DriverManager.getConnection("jdbc:mySql://localhost:3306","root","Chandan1a@");
			
			//Step-3 Create Statement
			Statement st = conn.createStatement();
			
			//Step-4: Execute the query
			int rowsInserted = st.executeUpdate("INSERT INTO jdbc_studentdb.student VALUES(107,'Rohit','r@gmail.com',49)");
			
			//Step-5 Process the result
			if(rowsInserted>0) {
				System.out.println(rowsInserted+"Data inserted!!");
			}
			else {
				System.out.println("Data not inserted!!");
			}
			//Step-6:close the connection
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
