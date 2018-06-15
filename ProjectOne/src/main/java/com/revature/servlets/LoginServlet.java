package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.LoginInfo;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	
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
		request.getRequestDispatcher("Views/LogIn.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Employee employee = edi.getEmployeeByCredentials(email, password);
		
		HttpSession session = request.getSession();
		
		if(employee != null) {
			session.setAttribute("id", employee.getId());
			response.sendRedirect("home");
		} else {
			//System.out.println("login was not successful - please try again");
			response.sendRedirect("login");
		}
	}

}
