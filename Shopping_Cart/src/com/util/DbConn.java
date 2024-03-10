package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {
	public static Connection getConnection() {
		Connection conn = null;
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/riddhi_jdbc";
		final String USER = "root";
		final String PASSWORD = "root";
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			if(conn == null) {
				System.out.println("Database failed to connect!!!");
			} else {
				System.out.println("Database connected successfully...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
//	public static void main(String[] args) {
//		DbConn.getConnection();
//	}
}