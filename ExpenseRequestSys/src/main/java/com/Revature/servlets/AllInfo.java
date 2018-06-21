package com.Revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
import com.Revature.Exceptions.NonExistentManager;
import com.Revature.Pojo.Employee;
import com.Revature.Pojo.ExpenseRequest;
import com.Revature.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AllInfo
 */
public class AllInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllInfo() {
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
		String resp = null;
		if (session == null || session.getAttribute("username") == null) {
			// Could send a redirect instead
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} else {
			EmployeeDao empDao = new EmployeeDaoImpl();
			ExpenseRequestDao erDao = new ExpenseRequestDaoImpl();
			try {
				Employee emp = empDao.getEmployee((String) session.getAttribute("username"));
				if (emp == null || !empDao.isManager(emp)) {
					ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
				} else {
					ObjectMapper om = new ObjectMapper();
					List<Employee> empList = empDao.getAllEmployees();
					List<ExpenseRequest> erList = erDao.getAllExpenseRequests();
					resp = "{\"employees\":" + om.writeValueAsString(empList) + ",\"expenses\":"
							+ om.writeValueAsString(erList) + "}";
					ResponseUtil.setResponse(response, 200, "application/json", resp);
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
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			// Could send a redirect instead
			ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
		} else {
			EmployeeDao empDao = new EmployeeDaoImpl();
			ExpenseRequestDao erDao = new ExpenseRequestDaoImpl();
			try {
				Employee emp = empDao.getEmployee((String) session.getAttribute("username"));
				if (emp == null || !empDao.isManager(emp)) {
					ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
				} else {
					ObjectMapper om = new ObjectMapper();
					ExpenseRequest er = om.readValue(request.getReader().readLine(), ExpenseRequest.class);
					Employee submitter = empDao.getEmployee(er.getSubmitter());
					if (submitter == null || !empDao.isSubEmployee(emp, submitter)) {
						ResponseUtil.setResponse(response, 401, "application/json",
								"{\"error\":\"Permission Denied\"}");
					} else {
						er.setResolvingManager(emp.getUsername());
						erDao.updateExpenseRequest(er);
						ResponseUtil.setResponse(response, 200, "application/json", "{\"result\":\"Success\"}");
					}
				}
			} catch (SQLException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (IOException e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (NonExistentEmployee e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");
			} catch (NonExistentManager e) {
				ResponseUtil.setResponse(response, 300, "application/json", "{\"url\":\"login\"}");

			}
		}
	}

}
