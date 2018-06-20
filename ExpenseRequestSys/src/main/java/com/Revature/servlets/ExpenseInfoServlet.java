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
import com.Revature.Dao.ExpenseRequestDao;
import com.Revature.Dao.ExpenseRequestDaoImpl;
import com.Revature.Exceptions.NonExistentEmployee;
import com.Revature.Pojo.Employee;
import com.Revature.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ExpenseInfoServlet
 */
public class ExpenseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExpenseInfoServlet() {
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
		// Meant to send back httpsession.username's current expenses
		HttpSession session = request.getSession(false);
		String resp = null;
		if (session == null || session.getAttribute("username") == null) {
			// Could send a redirect instead
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} else {
			EmployeeDao empDao = new EmployeeDaoImpl();
			ExpenseRequestDao erDao = new ExpenseRequestDaoImpl();
			try {
				Employee emp = empDao.getEmployee((String) session.getAttribute("username"));
				if (emp != null) {
					ObjectMapper om = new ObjectMapper();
					resp = "{\"result\":" + om.writeValueAsString(erDao.getAllExpenseRequests(emp)) + "}";
					ResponseUtil.setResponse(response, 200, "application/json", resp);
				} else {
					ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
				}
			} catch (SQLException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (IOException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (NonExistentEmployee e) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
