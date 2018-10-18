package com.devcenter.person.MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final DBConnection only_one = new DBConnection();
	private static Connection con;
	private static String JDBCdriver = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/person_records";
	private static String USER = "root";
	private static String PASSWORD = "root";
	static {
		try {
			Class.forName(JDBCdriver);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getDbSingletone() {
		return only_one;
	}

	public Connection getConnection() {
		return con;
	}

}