package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.Employee;
import data.EmployeeDao;
import data.Reimbursement;
import data.ReimbursementDao;
import data.UpdateReimbursementResponse;
import util.ConnectionUtil;

/**
 * Servlet implementation class UpdateRequestServlet
 */
public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("enter updateRequest GET");
		request.getRequestDispatcher("PermissionDenied.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("enter updateRequest Post");
		HttpSession session = request.getSession();
		response.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper objectMapper = new ObjectMapper();
		UpdateReimbursementResponse updateResponse = objectMapper.readValue(request.getReader().readLine(), UpdateReimbursementResponse.class);
		ReimbursementDao reimbursementDao = new ReimbursementDao();
		EmployeeDao employeeDao = new EmployeeDao();
		Reimbursement reimbursement;
		Employee submittingEmployee;
		ArrayList<Employee> managerList = new ArrayList();
		
		try {
			managerList.add(employeeDao.getEmployeeById(ConnectionUtil.getConnection(), 0));
			managerList.addAll(employeeDao.getAllSubordinates(ConnectionUtil.getConnection())) ;
			reimbursement = reimbursementDao.getReimbursementById(ConnectionUtil.getConnection(), updateResponse.getReimbursementId());
			submittingEmployee = employeeDao.getEmployeeById(ConnectionUtil.getConnection(), reimbursement.getEmployeeId());
			System.out.println("Reimbursement managerId = " + reimbursement.getManagerId() + " managerId is: " + updateResponse.getManagerId());
			reimbursementDao.modifyReimbursement(ConnectionUtil.getConnection(), updateResponse.getReimbursementId(), updateResponse.getManagerId(), updateResponse.getStatus());
//			if(reimbursement.getManagerId() != updateResponse.getManagerId()) {
//				System.out.println("enter if statement");
//				response.sendRedirect("PermissionDenied.html");
//
//			} 
//			else if()
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
