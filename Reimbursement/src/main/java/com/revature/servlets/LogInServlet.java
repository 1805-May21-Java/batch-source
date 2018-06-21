package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.pojos.employee;

public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("usernamebox");
		String pass = request.getParameter("passwordbox");
		HttpSession session = request.getSession();
		EmployeeDAOImpl employ = new EmployeeDAOImpl();
		employee emp = employ.getEmployeeByUser(user);
		
		if(emp != null && pass.equals(emp.getuPass())) {
			session.setAttribute("username", user);
			session.setAttribute("empName", emp.getEmpName());
			session.setAttribute("id", emp.getE_Id());
			session.setAttribute("position", emp.getePosition());
			if (employ.etypeCheck(emp) == true) {
				response.sendRedirect("manager-page");
			}else{
				response.sendRedirect("employee-page");
			}
		}else {
			response.sendRedirect("login-page");
		}
	}
}


