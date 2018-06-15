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
 * Servlet implementation class Home
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		int id = (int)request.getSession().getAttribute("id");
		Employee loggedIn = edi.getEmployeeById(id);
				
		if(!loggedIn.isManager()) {
			request.getRequestDispatcher(" Views/EmployeeHome.html").forward(request, response);
		}
		else if(!loggedIn.isHeadHoncho()) {
			request.getRequestDispatcher("http://localhost:8082/ProjectOne/Views/ManagerHome.html").forward(request, response);
		}
		else {
			request.getRequestDispatcher("http://localhost:8082/ProjectOne/Views/HeadHome.html").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside post");
		doGet(request, response);
	}

}
