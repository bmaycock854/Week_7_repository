package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import project.exception.DbExceptions;

public class DbConnection {
	private static String HOST = "localhost";
	private static String PASSWORD = "project";
	private static int PORT = 3306;
	private static String SCHEMA = "project";
	private static String USER = "project";

	public static Connection getConnection() {
	String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", HOST, PORT, SCHEMA, USER, PASSWORD);
	
	try {
		Connection conn = DriverManager.getConnection(uri);
		System.out.println("Connection to schema ' " + SCHEMA + " ' is successful!");
		return conn;
	}catch (SQLException e) {
		System.out.println("Unable to get connection at " + uri);
		throw new DbExceptions(e);
	}
	}
}
