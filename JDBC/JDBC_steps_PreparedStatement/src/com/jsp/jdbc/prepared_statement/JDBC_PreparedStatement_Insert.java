package com.jsp.jdbc.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_PreparedStatement_Insert {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_studentdb?user=root&password=Chandan1a@");
			
			PreparedStatement pst = conn.prepareStatement("INSERT INTO student VALUES(?,?,?,?)");
			System.out.println("Enter the StudentId: ");
			pst.setInt(1, scan.nextInt());
			System.out.println("Enter StudentName: ");
			pst.setString(2, scan.next());
			System.out.println("Enter StudentEmail: ");
			pst.setString(3,scan.next());
			System.out.println("Enter StudentMarks: ");
			pst.setInt(4, scan.nextInt());
			
			int rowsInserted = pst.executeUpdate();
			
			if(rowsInserted>0) {
				System.out.println(rowsInserted+"Data Inserted!!");
			}
			else {
				System.out.println("Data not Inserted");
			}
		}
		 catch (Exception e) {
			 e.printStackTrace(); 
		}
		
	}
}
