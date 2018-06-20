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
 * Servlet implementation class InfoServlet
 */
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoServlet() {
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
		String resp = "{\"error\":\"Nonexistent User\"}";
		if (session == null || session.getAttribute("username") == null) {
			// Could send a redirect instead
			ResponseUtil.setResponse(response, 401, "application/json", resp);
		} else {
			EmployeeDao empDao = new EmployeeDaoImpl();
			try {
				Employee emp = empDao.getEmployee((String) session.getAttribute("username"));
				if (emp != null) {
					ObjectMapper om = new ObjectMapper();
					resp = "{\"result\":" + om.writeValueAsString(emp) + "}";
					ResponseUtil.setResponse(response, 200, "application/json", resp);
				} else {
					ResponseUtil.setResponse(response, 401, "application/json", resp);
				}
			} catch (SQLException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (IOException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
