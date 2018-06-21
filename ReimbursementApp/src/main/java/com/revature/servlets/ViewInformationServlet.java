package com.revature.servlets;
//url is: /viewInformation
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class ViewInformationServlet
 */
public class ViewInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("ViewInformation.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String userData;
		HttpSession session = request.getSession(false);
		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
		String username = session.getAttribute("username").toString();
		Employee currentUser = ed1.getEmployeeByUsername(username);
		ObjectMapper om = new ObjectMapper();
		if(password.length() != 0){
			currentUser.setPassword(password);
		}
		currentUser.setAddress(address);
		currentUser.setEmail(email);
		currentUser.setPhone(phone);
		ed1.updateEmployee(currentUser);
		userData = om.writeValueAsString(currentUser);
		session.setAttribute("user", userData);
		response.sendRedirect("viewInformation");
	}

}
