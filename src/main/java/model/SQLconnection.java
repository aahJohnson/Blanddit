package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import view.userBean;

public class SQLconnection {
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	static ResultSet result = null;
	static String query = null;
	
	public static Connection connectSQL() { // Connect to login database
		
		final String dbUrl = "jdbc:mysql://localhost:3306/blandditlogin";
		final String dbUsername = "root";
		final String dbPassword = "";
		
		try { // Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		}
		
		catch (SQLException e) { // error handling
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		
		catch (Exception e) { // error handling
			System.out.println("Driver error: " + e);
		}
		
		return connection;
	}
	
	public static userBean checkLogin(String username, String password) { // Check if login values exist in the database
		
		userBean userInfo = null;
		
		try {
			
			query = "SELECT * FROM login WHERE Username = ? and Password = ?";
			
			connection = connectSQL();

			statement = connection.prepareStatement(query);

			statement.setString(1, username);
			statement.setString(2, password);

			result = statement.executeQuery();
			
			while (result.next()) {
				userInfo = new userBean();
				userInfo.setUsername(result.getString("username"));
				userInfo.setPassword(result.getString("password"));
			}
			
			connection.endRequest();
			connection.close();

		} catch (SQLException ex) { // error handling
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return userInfo;
	}
}