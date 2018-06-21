package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Employee;
import data.EmployeeDao;
import util.ConnectionUtil;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
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
		String name = request.getParameter("nameForm");
		String username = request.getParameter("usernameForm");
		String password = request.getParameter("passwordForm");
		String confirmPassword = request.getParameter("confirmPasswordForm");
		HttpSession session = request.getSession();
		long employeeId = Long.parseLong(session.getAttribute("employeeId").toString());
		Connection connection;
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee;
		
		
		if (name.equals("") || name == null || username.equals("") || username == null || password.equals("") || password == null || confirmPassword.equals("") || confirmPassword == null) {
			System.out.println("Something is empty");
			response.sendRedirect("UpdateFailed.html");
		} else if(!password.equals(confirmPassword)) {
			System.out.println("Passwords don't match");
			response.sendRedirect("UpdateFailed.html");
		} else {
			try {
				connection = ConnectionUtil.getConnection();
				if(employeeDao.checkEmployee(connection, username)) {
					employee = employeeDao.getEmployeeById(ConnectionUtil.getConnection(), employeeId);
					if(employee.getUsername().equals(username)) {
						employeeDao.updateEmployee(ConnectionUtil.getConnection(), employeeId, username, password, name);
						session.setAttribute("username", username);
						session.setAttribute("name", name);
						response.sendRedirect("homepage.html");
					} else {
						System.out.println("Username exists.");
						response.sendRedirect("UpdateFailed.html");
					}
				} else {
					employeeDao.updateEmployee(ConnectionUtil.getConnection(), employeeId, username, password, name);
					session.setAttribute("username", username);
					session.setAttribute("name", name);
					response.sendRedirect("homepage.html");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
