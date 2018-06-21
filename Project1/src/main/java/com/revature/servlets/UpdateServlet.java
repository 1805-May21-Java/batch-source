package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }
    
    String user = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("get");
		HttpSession session = request.getSession(false);
		user = (String) session.getAttribute("username");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();

		if(fname=="") {
			fname = edi.getEmployeeByUsername(user).getfName();
		}if(lname=="") {
			lname = edi.getEmployeeByUsername(user).getlName();
		}if(address=="") {
			address = edi.getEmployeeByUsername(user).getAddress();
		}if(city=="") {
			city = edi.getEmployeeByUsername(user).getCity();
		}if(state==null) {
			state = edi.getEmployeeByUsername(user).getState();
		}if(zipcode=="") {
			zipcode = edi.getEmployeeByUsername(user).getZipcode();
		}
//		System.out.println(fname);
//		System.out.println(lname);
//		System.out.println(address);
//		System.out.println(city);
//		System.out.println(state);
//		System.out.println(zipcode);
		edi.updateEmployee(fname, lname, address, city, state, zipcode, user);
		response.sendRedirect("EmpHome.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("post");
		request.getRequestDispatcher("Update.html").forward(request, response);
	}

}
