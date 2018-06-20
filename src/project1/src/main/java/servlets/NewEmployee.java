package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.EmployeeDao;
import util.ConnectionUtil;

/**
 * Servlet implementation class NewEmployee
 */
public class NewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployee() {
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
		System.out.println("Enter newEmployee doPost");
		String name = request.getParameter("nameForm");
		String username = request.getParameter("usernameForm");
		String password = request.getParameter("passwordForm");
		String confirmPassword = request.getParameter("confirmPasswordForm");
		String managerId = request.getParameter("managerSelect");
		HttpSession session = request.getSession();
		Connection connection;
		EmployeeDao employeeDao = new EmployeeDao();
		
		
		if (name.equals("") || name == null || username.equals("") || username == null || password.equals("") || password == null || confirmPassword.equals("") || confirmPassword == null) {
			response.sendRedirect("createEmployeeFailed.html");
		} else if(!password.equals(confirmPassword)) {
			response.sendRedirect("createEmployeeFailed.html");
		} else {
			try {
				connection = ConnectionUtil.getConnection();
				if(employeeDao.checkEmployee(connection, username)) {
					response.sendRedirect("createEmployeeFailed.html");
				} else {
					employeeDao.createEmployee(connection, Long.parseLong(managerId), name, confirmPassword, username);
					response.sendRedirect("index.html");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
