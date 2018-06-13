package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.actors.GateKeeper;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Register.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String registration = request.getParameter("registration");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		GateKeeper.setWarning("");
		
		HttpSession session = request.getSession();
		if(GateKeeper.attemptRegistration(firstName, lastName, email, registration, password, confirmPassword)) {
			//System.out.println("login was successful - correct credentials");
			session.setAttribute("email", email);
			response.sendRedirect("./Profile");
		} else {
			//System.out.println("login was not successful - please try again");
			response.sendRedirect("./Register");
		}
	}

}
