package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.LocationDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Location;

/**
 * Servlet implementation class LocationServlet
 */
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr != null) {
			int id = Integer.valueOf(idStr);

			//System.out.println("we got a param");
			//System.out.println(id);
			
			LocationDaoImpl ldi = new LocationDaoImpl();
			Location l = ldi.getLocationById(id);
			ObjectMapper om = new ObjectMapper();
			String loc = om.writeValueAsString(l);
			PrintWriter pw = response.getWriter();
			//pw.print(employeeString);
			
		} else {
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			List<Employee> allEmployees = edi.getEmployees();
			
			for(Employee e: allEmployees) {
				System.out.println(e.toString());
			}
			
			ObjectMapper om = new ObjectMapper();
			String employeeString = om.writeValueAsString(allEmployees);
			employeeString = "{\"employees\":" + employeeString + "}";
			PrintWriter pw = response.getWriter();
			pw.print(employeeString);
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
