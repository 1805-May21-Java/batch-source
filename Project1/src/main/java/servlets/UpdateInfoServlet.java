package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDAOImpl;


public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		
		String email = request.getParameter("employeeEmail");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String phone = request.getParameter("employeePhone");
		
		HttpSession session = request.getSession();
		String empemail = session.getAttribute("email").toString();
		int id = edi.getEmployeeIdByEmail(empemail);
		
		edi.updateEmployee(id, email, firstname, lastname, phone);
		response.sendRedirect("employeeprofile.html");
		
	}

}
