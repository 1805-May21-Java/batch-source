package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class InfoUpdateServlet
 */
public class InfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		HttpSession session = request.getSession();
		int id = (Integer)session.getAttribute("id");
		Employee loggedIn = edi.getEmployeeById(id);
		
		loggedIn.setFirstName(request.getParameter("firstname"));
		loggedIn.setLastName(request.getParameter("lastname"));
		loggedIn.setEmail(request.getParameter("email"));
		loggedIn.setPassword(request.getParameter("password"));
		
		edi.updateEmployee(loggedIn);
		
		response.sendRedirect("home");
	}

}
