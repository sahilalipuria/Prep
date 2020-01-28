package com.cisco.employeemamanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtils {
	private static String userName = "root";
	private static String password = "root";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/sys?useSSL=false";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
