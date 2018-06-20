package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.Employee;
import data.EmployeeDao;
import util.ConnectionUtil;

/**
 * Servlet implementation class GetManagerServlet
 */
public class GetManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		ObjectMapper objectMapper = new ObjectMapper();
		EmployeeDao employeeDao = new EmployeeDao();
		ArrayList<Employee> managerList = new ArrayList();
		try {
			managerList.add(employeeDao.getEmployeeById(ConnectionUtil.getConnection(), 0));
			managerList.addAll(employeeDao.getAllSubordinates(ConnectionUtil.getConnection())) ;
			String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(managerList);
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
