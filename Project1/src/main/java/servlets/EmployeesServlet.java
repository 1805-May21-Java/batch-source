package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.EmployeeDAOImpl;
import dao.RequestDAOImpl;
import model.Employee;
import model.Request;

public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmployeeDAOImpl emp = new EmployeeDAOImpl();
		HttpSession session = request.getSession(false);
		response.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json");
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = emp.getEmployees();
		
		String requestString = om.writeValueAsString(employees);
		//requestString = "{\"requests\":"+requestString+"}";

	
		PrintWriter pw = response.getWriter();
		pw.print(requestString);
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
