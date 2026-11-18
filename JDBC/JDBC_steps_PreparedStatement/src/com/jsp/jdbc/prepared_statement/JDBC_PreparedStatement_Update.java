package com.jsp.jdbc.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_PreparedStatement_Update {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_studentdb?user=root&password=Chandan1a@");
			
			PreparedStatement pst = conn.prepareStatement("UPDATE  student SET studentMarks=? WHERE studentId=?");
			System.out.println("Enter the StudentMarks: ");
			pst.setInt(1, scan.nextInt());
			System.out.println("Enter StudentId: ");
			pst.setInt(2, scan.nextInt());
			
			int rowsUpdated = pst.executeUpdate();
			
			if(rowsUpdated>0) {
				System.out.println(rowsUpdated+"Data Updated!!");
			}
			else {
				System.out.println("Data not Updated");
			}
		}
		 catch (Exception e) {
			 e.printStackTrace(); 
		}
		
	}
}
