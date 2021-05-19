package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.SQLconnection;
import view.userBean;

@WebServlet("/loginNavigator")
public class loginNavigator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginNavigator() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username"); // Get username and password from the login page
		String password = request.getParameter("password");
		String destination = "index.jsp";
		
		userBean loggerInner = SQLconnection.checkLogin(username, password); // Check login values against database

		HttpSession session = request.getSession(false);
		if (loggerInner != null) { // If login success

			destination = "feed.jsp";
			SQLconnection.connectSQL();
			session.setAttribute("userInfo", loggerInner);
		}
		else { // If login failure
			String errorMessage = "Invalid login, try again";
			request.setAttribute("errorMessage", errorMessage);
		}

		postHandler.listAllPosts(request, response); // Shows all existing posts

		request.getRequestDispatcher(destination).forward(request, response);
	}
}