package com.revature.servlets;
//url is: /login
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Gets the values at Login.html's parameter names
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String loginType = request.getParameter("loginType");
		String userData;
		//creates a new HTTPSession
		HttpSession session = request.getSession();
		//Used EmploteeDaoImpl to create an Employee Object
		//based on user's login input.
		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		Employee current = ed1.getEmployeeByUsername(user);
		//If user is not null and password matches, servlet
		//redirects to the HomepageServlet (/homepage)
		//else it redirects back to login
		if(current != null && 
				current.getPassword().equals(pass)) {
			userData = om.writeValueAsString(current);
			//session attributes are set using Employee object data.
			session.setAttribute("user", userData);
			session.setAttribute("id", current.getEmployee_id());
			session.setAttribute("isManager", current.getIsManager());
			session.setAttribute("username", user);
			session.setAttribute("loginType", loginType);
			response.sendRedirect("homepage");
		}else {
			System.out.println("No successful login");
			response.sendRedirect("login");
		}
	}

}
