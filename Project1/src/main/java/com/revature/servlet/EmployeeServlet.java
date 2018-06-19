package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EmployeeDaoImpl edi = new EmployeeDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get employees
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add employee
		response.addHeader("Access-Control-Allow-Origin", "*");
		String requestBodyText = request.getReader().readLine();
		Employee emp = new Employee();
		Employee curEmp = (Employee) request.getSession().getAttribute("curEmployee");
		String[] strings = requestBodyText.split("&");
		emp.setName(strings[0].substring(5));
		emp.setUsername(strings[1].substring(9));
		emp.setPassword(strings[2].substring(9));
		if(strings.length>3) emp.setManager("on".equals(strings[3].substring(5)));
		else emp.setManager(false);
		emp.setManagerId(curEmp.getEmployeeId());
				
		edi.createEmployee(emp);
		
		response.sendRedirect("managerHome.html");
		
	}

}
