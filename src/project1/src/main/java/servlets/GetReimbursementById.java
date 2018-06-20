package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.Employee;
import data.Reimbursement;
import data.ReimbursementDao;
import util.ConnectionUtil;

/**
 * Servlet implementation class GetReimbursementById
 */
public class GetReimbursementById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReimbursementById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		HttpSession session = request.getSession(false);
		String employeeId = session.getAttribute("employeeId").toString();
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		ObjectMapper objectMapper = new ObjectMapper();
		ReimbursementDao reimbursementDao = new ReimbursementDao();
		ArrayList<Reimbursement> reimbursementList = new ArrayList();
		try {
			reimbursementList = reimbursementDao.getReimbursementByEmployeeId(ConnectionUtil.getConnection(), Long.parseLong(employeeId));
			String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reimbursementList);
			pw.write(jsonInString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
