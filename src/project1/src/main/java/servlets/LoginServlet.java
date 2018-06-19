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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Enter doGet");
		HttpSession session = request.getSession(false);
		session.invalidate();
		request.getRequestDispatcher("index.html").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Enter doPost");
		String user = request.getParameter("usernameForm");
		String pass = request.getParameter("passwordForm");

		System.out.println(user + " " + pass);

		HttpSession session = request.getSession();
		if (user.equals("") || user == null || pass.equals("") || pass == null) {
			response.sendRedirect("LoginFailed.html");
		} else {
			try {
				Connection connection = ConnectionUtil.getConnection();
				EmployeeDao employeeDao = new EmployeeDao();

				if (employeeDao.checkEmployee(connection, user)) {
					Employee employee = employeeDao.getEmployeeByName(connection, user);
					if (pass.equals(employee.getPassword())) {
						// System.out.println("login was successful - correct credentials");
						session.setAttribute("username", "admin");
						response.sendRedirect("homepage.html");
					} else {
						// System.out.println("login was not successful - please try again");
						response.sendRedirect("LoginFailed.html");
					}
				} else {
					response.sendRedirect("LoginFailed.html");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
