package info.sjd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ConnectionToDB {

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/amazon-data-scraper-db";
	
	private static final String DB_USER = "postgres";
	
	private static final String USER_PASSWORD = "248842";
	
	protected static Connection getConnection() {
				
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(DB_URL, DB_USER, USER_PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	protected static void closeConnection(PreparedStatement statement, Connection connection) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected static void closeConnection(ResultSet rSet, PreparedStatement statement, Connection connection) {
		try {
			rSet.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
