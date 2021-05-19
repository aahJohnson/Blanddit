package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.postBean;
import view.userBean;

@WebServlet("/postHandler")
public class postHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Connection connection = null;
	static PreparedStatement statement = null;
	static ResultSet resultset = null;
	static String query = null;

	public postHandler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // Run these when create post is clicked

		newPost(request, response);
		listAllPosts(request, response);

		request.setAttribute("userName", userBean.getUsername());

		RequestDispatcher rd = request.getRequestDispatcher("feed.jsp");
		rd.forward(request, response);

	}

	public static Connection connect() { // Connects to the posts database

		final String dbUrl = "jdbc:mysql://localhost:3306/blandditposts";
		final String dbUsername = "root";
		final String dbPassword = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception ex) {
			System.out.println("Exception Driver: " + ex);
		}

		return connection;
	}

	public static void newPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // Reads what to add to a new post and checks so it's not empty

		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String tag = request.getParameter("tag");

		if (title != "" && text != "" && tag != "") {

			addPost(title, text, tag);
		}
		else {
			String invalidPost = "Invalid post, try again";
			request.setAttribute("invalidPost", invalidPost);
		}
	}

	public static boolean addPost(String title, String text, String tag) { // Adds a new post to the database

		try {

			query = "INSERT INTO `posts` (`title`, `text`, `tag`) VALUES (?, ?, ?)";
			connection = connect();
			statement = connection.prepareStatement(query);

			statement.setString(1, title);
			statement.setString(2, text);
			statement.setString(3, tag);

			statement.executeUpdate();

			connection.close();

			return true;

		}

		catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		return false;
	}

	public static void listAllPosts(HttpServletRequest request, HttpServletResponse response) // Show all posts
			throws ServletException, IOException {

		ArrayList<postBean> postItems = new ArrayList<postBean>();

		postBean post = null;

		try {

			query = "SELECT * FROM posts"; // Get all posts from database
			connection = connect();
			statement = connection.prepareStatement(query);
			resultset = statement.executeQuery();

			while (resultset.next()) {
				post = new postBean(); // Put info from database in a post bean
				post.setTitle(resultset.getString("Title"));
				post.setText(resultset.getString("Text"));
				post.setTag(resultset.getString("Tag"));
				postItems.add(post);
			}

			resultset.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		request.setAttribute("postList", postItems); // Send values of post bean to jsp
	}

//	public void deleteAllPosts() throws ServletException, IOException { // Delete all posts
//
//		try {
//			query = "DELETE FROM posts";
//			connection = connect();
//			statement = connection.prepareStatement(query);
//			statement.executeUpdate();
//
//			resultset.close();
//			connection.close();
//
//		} catch (SQLException e) {
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
//			System.out.println("VendorError: " + e.getErrorCode());
//		}
//	}
}