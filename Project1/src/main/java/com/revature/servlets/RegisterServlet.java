package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Register.html").forward(request, response);
		//System.out.println("Get called");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post called");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		
		if(!(user == "") && !(pass == "")) {
			if(edi.getEmployeeByUsername(user)==null){
				edi.createEmployee(new Employee(0, user, pass, fname, lname, address, city, state, zipcode, 0));
				response.sendRedirect("login");
				System.out.println("Registration Successful");
			}
		}else {
			System.out.println("Plese enter all required information.");
			doGet(request, response);
		}
	}

}
