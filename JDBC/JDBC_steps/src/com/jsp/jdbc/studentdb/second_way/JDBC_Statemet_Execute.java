package com.jsp.jdbc.studentdb.second_way;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Statemet_Execute {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Step-1 Load & register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2: Establish the Connection
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_studentdb?user=root&password=Chandan1a@");

			// Step-3: Create Statement
			Statement st = conn.createStatement();

			// Step-4: Execute the Query
			boolean result = st.execute(" DELETE FROM student WHERE studentId=101");  //Delete the data from database

			// Step-5: Process the result
			System.out.println(result);
			if (result == false) {
				System.out.println("Data Deleted!!");
			} else {
				System.out.println("Data Not Deleted!!");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Step-6:Close the connection
		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
