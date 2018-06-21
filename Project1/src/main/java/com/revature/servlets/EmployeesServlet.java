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
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;

public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeesServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		List<Employee> e = edi.getEmployees();
		ObjectMapper om = new ObjectMapper();
		String employeesStr = om.writeValueAsString(e);
		employeesStr = "{\"employees\":"+employeesStr+"}";
		PrintWriter pw = response.getWriter();
		pw.write(employeesStr);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
