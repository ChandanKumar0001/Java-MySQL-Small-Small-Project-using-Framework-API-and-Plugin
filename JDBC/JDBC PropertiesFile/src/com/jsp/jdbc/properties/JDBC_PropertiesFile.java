package com.jsp.jdbc.properties;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC_PropertiesFile {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			FileReader fr = new FileReader("DB_Connection.properties");
			Properties p = new Properties();
			p.load(fr);
			String dbUrl=p.getProperty("dbUrl");
			
			conn = DriverManager.getConnection(dbUrl,p);
			
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM student");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
