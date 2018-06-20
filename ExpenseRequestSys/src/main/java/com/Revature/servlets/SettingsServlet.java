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
import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Pojo.Employee;
import com.Revature.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class SettingsServlet
 */
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SettingsServlet() {
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
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect("login");
		} else {
			EmployeeDao empDao = new EmployeeDaoImpl();
			try {
				Employee emp = empDao.getEmployee((String) session.getAttribute("username"));
				if (emp == null) {
					response.sendRedirect("login");
				} else if (empDao.isManager(emp)) {
					request.getRequestDispatcher("ManagerSettings.html").forward(request, response);
				} else {
					request.getRequestDispatcher("EmployeeSettings.html").forward(request, response);
				}
			} catch (SQLException e) {
				response.sendRedirect("login");
			} catch (NonExistentEmployee e) {
				response.sendRedirect("login");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Post will update your information

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} else {

			ObjectMapper om = new ObjectMapper();
			Employee chng = om.readValue(request.getReader().readLine(), Employee.class);
			EmployeeDao empDao = new EmployeeDaoImpl();
			try {
				Employee emp = empDao.getEmployee((String) session.getAttribute("username"));
				if (chng.getPwd() != null) {
					emp.setPwd(chng.getPwd());
				}

				if (chng.getFirstName() != null) {
					emp.setFirstName(chng.getFirstName());
				}

				if (chng.getLastName() != null) {
					emp.setLastName(chng.getLastName());
				}

				if (chng.getEmail() != null) {
					emp.setEmail(chng.getEmail());
				}

				empDao.updateEmployee(emp);
				ResponseUtil.setResponse(response, 200, "application/json", "{\"response\":\"Success\"}");
			} catch (SQLException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (IOException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (NonExistentManager e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			}
		}
	}

}
