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

 
public class ReimbursementsApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReimbursementsApiServlet(){
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String managerId=request.getParameter("manager_id");
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String reimbursementString;
		
		if(managerId!=null)
		{
			int managerID = Integer.valueOf(managerId);
			List<Employee> employees = edi.getEmployees();
			List<Integer> empIds = edi.getEmployeesUnderManager(employees, managerID);
			List<Reimbursement> reimbursements = rdi.getReimbursements();		
			List<Reimbursement> reimbursementsByIds = rdi.getReimbursementsByEmpIds(reimbursements, empIds);
			reimbursementString = om.writeValueAsString(reimbursementsByIds);
			reimbursementString = "{\"reimbursements\":"+reimbursementString+"}";
		}
		else if (idStr != null) {
			
			int id = Integer.valueOf(idStr);
			Reimbursement e = rdi.getReimbursementById(id);
			reimbursementString = om.writeValueAsString(e);
			
			
		} else {
			List<Reimbursement> allReimbursemnets = rdi.getReimbursements();
			reimbursementString = om.writeValueAsString(allReimbursemnets);
			reimbursementString = "{\"reimbursements\":"+reimbursementString+"}";
		}
		
		PrintWriter pw = response.getWriter();
		pw.print(reimbursementString);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
