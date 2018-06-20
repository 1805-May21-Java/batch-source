package com.Revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.Dao.EmployeeDao;
import com.Revature.Dao.EmployeeDaoImpl;
import com.Revature.Pojo.Employee;
import com.Revature.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			request.getRequestDispatcher("Login.html").forward(request, response);
		} else {
			response.sendRedirect("home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		// Only reads in username and password

		Employee emp = om.readValue(request.getReader().readLine(), Employee.class);
		emp.setUsername(emp.getUsername().toUpperCase());
		if (checkCredentials(emp)) { // If the credentials are correct
			HttpSession session = request.getSession();
			session.setAttribute("username", emp.getUsername());

			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"home\"}");
		} else {
			// Signals invalid credentials
			ResponseUtil.setResponse(response, 401, "application/json", "{\"error\":\"Invalid Credentials\"}");
		}
	}

	private boolean checkCredentials(Employee emp) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		try {
			Employee tmp = empDao.getEmployee(emp.getUsername());
			if (tmp == null) {
				return false;
			}

			if (emp.getPwd() == null && tmp.getPwd() == null) {
				return true;
			}

			if (emp.getPwd() != null && emp.getPwd().equals(tmp.getPwd())) {
				return true;
			}
		} catch (SQLException e) {

		} catch (IOException e) {

		}

		return false;
	}
}
