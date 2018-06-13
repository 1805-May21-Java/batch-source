package com.revature.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.actors.GateKeeper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		if(GateKeeper.validLogin(email, password)) {
			//System.out.println("login was successful - correct credentials");
			session.setAttribute("email", email);
			response.sendRedirect("./Profile");
		} else {
			//System.out.println("login was not successful - please try again");
			response.sendRedirect("./Login");
		}
		
	}

}
