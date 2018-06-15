package com.revature.servlets;

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
		//Change int isManager to Integer isManager
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String userData;
		HttpSession session = request.getSession();
		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
		HashMap<String, Employee> employeeList = ed1.getEmployees();
		ObjectMapper om = new ObjectMapper();
		
		if(employeeList.containsKey(user) && 
				employeeList.get(user).getPassword().equals(pass)) {
			Employee current = ed1.getEmployeeByUsername(user);
			userData = om.writeValueAsString(current);
			session.setAttribute("user", userData);
			session.setAttribute("isManager", current.getIsManager());
			session.setAttribute("username", user);
			response.sendRedirect("homepage");
		}else {
			System.out.println("No successful login");
			response.sendRedirect("login");
		}
	}

}
