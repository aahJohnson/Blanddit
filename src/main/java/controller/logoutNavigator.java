package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutNavigator")
public class logoutNavigator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public logoutNavigator() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		if (session != null) { // If there is a session, end it
			session.removeAttribute("userInfo");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		else { // If there is no session, show error message
			String errorMessage = "Invalid logout";
			request.setAttribute("invalidPost", errorMessage);
		}
		
	}

}
