package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.addHeader("Access-Control-Allow-Origin", "*");
		Employee curEmp = (Employee) request.getSession().getAttribute("curEmployee");
		ObjectMapper om = new ObjectMapper();
		String empString = om.writeValueAsString(curEmp);
		empString = "{\"employee\":"+empString+"}";
		System.out.println(empString);

		PrintWriter pw = response.getWriter();
		pw.write(empString);
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
		if(requestBodyText.contains("username")) {
			String[] strings = requestBodyText.split("&");
		emp.setName(strings[0].substring(5));
		emp.setUsername(strings[1].substring(9));
		emp.setPassword(strings[2].substring(9));
		if(strings.length>3) emp.setManager("on".equals(strings[3].substring(5)));
		else emp.setManager(false);
		emp.setManagerId(curEmp.getEmployeeId());
				
		edi.createEmployee(emp);
		
		response.sendRedirect("managerHome.html");
		} else {
			//update employee
			System.out.println("Updating");
			String[] strings = requestBodyText.split("&");
			curEmp.setName(strings[0].substring(5));
			curEmp.setUsername(strings[1].substring(6));
			curEmp.setPassword(strings[2].substring(6));
			edi.updateEmployee(curEmp);
			if(curEmp.isManager()) {
				//send to manager home
				response.sendRedirect("managerHome.html");
			} else {
				//send to employee home
				response.sendRedirect("employeeHome.html");
			}
		}
		
		
	}

}
