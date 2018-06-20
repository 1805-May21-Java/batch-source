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
import com.Revature.Pojo.ExpenseRequest;
import com.Revature.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class NewExpenseRequest
 */
public class NewExpenseRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewExpenseRequestServlet() {
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
					request.getRequestDispatcher("NewManagerExpense.html").forward(request, response);
				} else {
					request.getRequestDispatcher("NewEmployeeExpense.html").forward(request, response);
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
		// For creating a new expense request
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} else {
			ObjectMapper om = new ObjectMapper();
			ExpenseRequest er = om.readValue(request.getReader().readLine(), ExpenseRequest.class);
			
			er.setSubmitter((String) session.getAttribute("username"));

			ExpenseRequestDao erDao = new ExpenseRequestDaoImpl();
			try {
				if (er.getAmount() > 0 && er.getExpense() != null) {
					erDao.createExpenseRequest(er);
					ResponseUtil.setResponse(response, 200, "application/json", "{\"response\":\"Success\"}");
				} else {
					ResponseUtil.setResponse(response, 401, "application/json", "{\"err\":\"Invalid Input\"}");
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

}
