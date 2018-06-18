package com.revature.servlets;
//url is: /searchEmployee
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class SearchEmployeeServlet
 */
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		request.getRequestDispatcher("SearchEmployee.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
		ReimbursementDaoImpl rd1 = new ReimbursementDaoImpl();
		ObjectMapper om = new ObjectMapper();
		List<Reimbursement> employeeRequests = rd1.getReimbursementByEmployeeId(employeeId);
		String searchedData = om.writeValueAsString(employeeRequests);
		session.setAttribute("searchedEmployee", searchedData);
		response.sendRedirect("searchEmployee");
	}

}
