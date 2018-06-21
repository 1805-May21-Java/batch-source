package com.revature.servlets;



import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
		String fullName = request.getParameter("firstName")+" "+request.getParameter("lastName");
		String user = request.getParameter("userName");
		String pwd = request.getParameter("userPassword");
		Date birthdate = Date.valueOf(request.getParameter("birthdate"));
		int managerId = Integer.parseInt(request.getParameter("userManagerId"));
		String userUrl="https://randomuser.me/api/portraits/men/77.jpg";
		EmployeeDao dao = new EmployeeDaoImpl();
		
		Employee employee = new Employee(fullName, user, pwd, managerId, birthdate, userUrl);
		dao.createEmployee(employee);
		response.sendRedirect("login");
	}

}
