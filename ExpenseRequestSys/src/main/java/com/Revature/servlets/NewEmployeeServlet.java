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
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Exceptions.UsernameTaken;
import com.Revature.Pojo.Employee;
import com.Revature.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class NewEmployeeServlet
 */
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("NewEmployee.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		Employee emp = om.readValue(request.getReader().readLine(), Employee.class);
		emp.setActive(true);
		if (emp.getUsername() != null) {
			emp.setUsername(emp.getUsername().toUpperCase());
		}

		if (emp.getReportsTo() != null) {
			emp.setReportsTo(emp.getReportsTo().toUpperCase());
		}

		EmployeeDao empDao = new EmployeeDaoImpl();

		try {
			if (emp.getUsername() == null || emp.getReportsTo() == null || emp.getFirstName() == null
					|| emp.getLastName() == null || emp.getEmail() == null) {
				ResponseUtil.setResponse(response, 401, "application/json", "{\"error\":\"Missing Information\",\"location\":\"err\"}");
			} else if (!empDao.checkUsernameAvailable(emp.getUsername())) {
				ResponseUtil.setResponse(response, 401, "application/json", "{\"error\":\"Username Taken\",\"location\":\"usernameerr\"}");
			} else if (empDao.checkUsernameAvailable(emp.getReportsTo())) {
				ResponseUtil.setResponse(response, 401, "appliction/json", "{\"error\":\"Invalid Manager\",\"location\":\"reportserr\"}");
			} else {
				empDao.createEmployee(emp);

				HttpSession session = request.getSession();
				session.setAttribute("username", emp.getUsername());

				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"home\"}");
			}
		} catch (SQLException e) {
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} catch (IOException e) {
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} catch (UsernameTaken e) {
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} catch (NonExistentManager e) {
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		}
	}

}
