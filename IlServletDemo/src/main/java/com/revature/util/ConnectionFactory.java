package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("you have a connection");
			return DriverManager.getConnection("jdbc:postgresql://localhost/", "postgres","Junior15");
			//System.out.println("you have a connection");
		} catch(SQLException e) {
			e.printStackTrace();
			e.getCause();
			e.getSQLState();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
