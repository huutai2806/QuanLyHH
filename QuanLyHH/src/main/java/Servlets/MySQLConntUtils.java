package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConntUtils {
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostname = "localhost";
		String dbName = "QuanLyHH";
		String username = "root";
		String password = "";

		return getMySQLConnection(hostname, dbName, username, password);
	}

	private static Connection getMySQLConnection(String hostname, String dbName, String username, String password)
			throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
