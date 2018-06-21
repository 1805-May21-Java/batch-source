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
import data.ReimbursementDao;
import util.ConnectionUtil;

/**
 * Servlet implementation class NewReimbursement
 */
public class NewReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewReimbursement() {
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
		// TODO Auto-generated method stub
		String value = request.getParameter("valueForm");
		String reason = request.getParameter("reasonForm");
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		Connection connection;
		ReimbursementDao reimbursementDao = new ReimbursementDao();
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee;
		
		System.out.println("value is: " + value + " reason is: " + reason);
		
		if (value.equals("") || value == null || reason.equals("") || reason == null) {
			response.sendRedirect("SubmitFailed.html");
		}  else {
			try {
				employee = employeeDao.getEmployeeByName(ConnectionUtil.getConnection(), username);
				reimbursementDao.createReimbursement(ConnectionUtil.getConnection(), employee.getEmployeeId(), Double.parseDouble(value), employee.getReportsTo(), reason, 0);
				response.sendRedirect("SubmitReimbursement.html");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
