package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

public class ProfileServlet extends HttpServlet {
	private static final long 	serialVersionUID = 1L;

    public ProfileServlet() {
        super();
    }
    
    String username = "";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("username") != null) {
			username = (String) session.getAttribute("username");
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			Employee employee = edi.getEmployeeByUsername((String) session.getAttribute("username"));
			ObjectMapper om = new ObjectMapper();
			String employeeStr = om.writeValueAsString(employee);
			employeeStr = "{\"employee\":"+employeeStr+"}";
			PrintWriter pw = response.getWriter();
			pw.println(employeeStr);
			//request.getRequestDispatcher("Profile.html").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
			
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Profile post called");
//		doGet(request, response);
	}

}
