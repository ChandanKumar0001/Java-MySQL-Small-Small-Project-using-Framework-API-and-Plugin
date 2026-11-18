package com.jsp.jdbc.studentdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Statement_Select {
public static void main(String[] args) {
	Connection conn = null;
		
		try {
			//Step-1: Load and Register the Driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			//Step-2 Establish the connection
			conn = DriverManager.getConnection("jdbc:mySql://localhost:3306/jdbc_studentdb","root","Chandan1a@");
			
			//Step-3 Create Statement
			Statement st = conn.createStatement();
			
			//Step-4: Execute the query
			ResultSet rs = st.executeQuery("SELECT * FROM student");//here fetch program
			
			//Step-5 Process the result
			System.out.println("StudentID\tStudentName\tStudentEmail\t\t\t\tStudentMarks");
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t\t");
				System.out.print(rs.getString(2)+"\t\t");
				System.out.print(rs.getString("studentEmail")+"\t\t\t");
				System.out.print(rs.getInt("studentMarks")+"\t\t\t");
				System.out.println();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		//Step-6:Close the connection
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
