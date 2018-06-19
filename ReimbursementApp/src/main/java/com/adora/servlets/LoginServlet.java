package com.adora.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adora.access.CredentialDaoImpl;
import com.adora.managers.SessionManager;
import com.adora.pojos.Credential;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");	
		String password = request.getParameter("password" );
		System.out.println(username);
		System.out.println(password);
		
		// check the credentials
		Credential credential = new Credential(username, password);
		CredentialDaoImpl cdi = new CredentialDaoImpl();
		Credential validCredential = cdi.checkCredentials(credential);

		
		if(validCredential.getEmployee_id() != 0) {
			System.out.println("I have the employee");
			SessionManager.logIn(request, validCredential);
			response.sendRedirect("home");
		} 
		else {
			response.sendRedirect("login");
		}
		
		
	}

}
