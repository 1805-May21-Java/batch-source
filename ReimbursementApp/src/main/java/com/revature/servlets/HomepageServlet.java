package com.revature.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class HomepageServlet
 */
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Success, login works!
		//But make you pass the database table data to your session!
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginType") == null) {
			response.sendRedirect("login");
		}
		
		if(session!=null && session.getAttribute("username") != null && 
				(Integer)session.getAttribute("isManager") == 0) {
			//radio button at login
			if(session.getAttribute("loginType").equals("manager")) {
				response.sendRedirect("login");
			}else {
			request.getRequestDispatcher("EmployeeHomepage.html").forward(request, response);
			}
		}else if(session != null && session.getAttribute("username") != null &&
				(Integer)session.getAttribute("isManager") == 1){
			//added radio button at login
			if(session.getAttribute("loginType").equals("employee")) {
				request.getRequestDispatcher("EmployeeHomepage.html").forward(request, response);
			}else {
			
			ReimbursementDaoImpl rd1 = new ReimbursementDaoImpl();
			List<Reimbursement> allReimbursements = rd1.getReimbursements();
			ObjectMapper om = new ObjectMapper();
			String reimbursementData = om.writeValueAsString(allReimbursements);
			session.setAttribute("allReimbursements", reimbursementData);
			EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
			List<Employee> employeeData = ed1.getEmployees();
			//List<Employee> employeeList = new Ar
			String employeeList = om.writeValueAsString(employeeData);
			session.setAttribute("allEmployees", employeeList);
			request.getRequestDispatcher("ManagerHomepage.html").forward(request, response);
			}
		}else {
			response.sendRedirect("login");
		}
	}

	/*
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/

}
