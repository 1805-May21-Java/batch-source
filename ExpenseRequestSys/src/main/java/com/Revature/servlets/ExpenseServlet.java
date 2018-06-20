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
import com.Revature.Pojo.Employee;

/**
 * Servlet implementation class ExpenseServlet
 */
public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExpenseServlet() {
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
			response.sendRedirect("login");
		} else {
			EmployeeDao empDao = new EmployeeDaoImpl();
			try {
				Employee emp = empDao.getEmployee((String) session.getAttribute("username"));
				if (emp == null) {
					response.sendRedirect("login");
				} else if (empDao.isManager(emp)) {
					request.getRequestDispatcher("ManagerExpenseRequests.html").include(request, response);
				} else {
					request.getRequestDispatcher("EmployeeExpenseRequests.html").include(request, response);
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
		doGet(request, response);
	}

}
