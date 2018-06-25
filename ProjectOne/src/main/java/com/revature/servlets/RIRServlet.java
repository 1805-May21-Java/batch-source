package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.*;
import com.revature.pojos.*;

/**
 * Servlet implementation class RIRServlet
 */
public class RIRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RIRServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementRequestDaoImpl rdi = new ReimbursementRequestDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		HttpSession session = request.getSession();
		Employee loggedIn = edi.getEmployeeById((Integer)session.getAttribute("id"));
		List<ReimbursementRequest> requests = null;
		
		//If an id is passed in, return all reqeuests from that employee iff that employee is managed by
		//the employee logged in or is the employee logged in
		if(request.getParameter("id") != null)
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Employee employee = edi.getEmployeeById(id);
			if(employee.getManager() != null)
			{
				if(managedEmployees(loggedIn.getId()).contains(employee) || employee.equals(loggedIn))
				{
					requests = rdi.getRiRsByEmpId(id);
				}
			}
			else if(id == loggedIn.getId()) {
				requests = rdi.getRiRsByEmpId(id);
			}
		}
		//If no id is passed, return all requests made by employees that employee manages
		else
		{
			requests = new ArrayList<ReimbursementRequest>();

			List<Employee> managees = managedEmployees(loggedIn.getId());
			
			for(Employee employee : managees)
			{
				List<ReimbursementRequest> rirs = rdi.getRiRsByEmpId(employee.getId());
				for(ReimbursementRequest rir : rirs)
				{
					requests.add(rir);
				}
			}
		}
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(requests);
		json = "{\"requests\":" + json + "}";

		PrintWriter pw = response.getWriter();
		pw.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected List<Employee> managedEmployees(int id) {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee manager = edi.getEmployeeById(id);
		
		List<Employee> employees = manager.managedEployees();
		List<Employee> managees = new ArrayList<Employee>();
		
		for(Employee employee : employees) {
			managees.add(employee);
			List<Employee> emps = managedEmployees(employee.getId());
			
			for(Employee e : emps) {
				managees.add(e);
			}
		}
		
		return managees;
	}

}
