package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Reimbursement;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ManagerServlet  extends HttpServlet{
	private static final long serialVersionUID = -7596093202814240488L;
	ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type == null) {
			type = "pending";
		}
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		ArrayList<Employee> employees = new ArrayList<>();

		if(type.equals("all")) {
			employees = edi.getEmployees();
			ObjectMapper om = new ObjectMapper();
			String employeesString = om.writeValueAsString(employees);
			employeesString = "{\"employees\":" + employeesString+"}";
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.write(employeesString);		
		} else {
			if(type.equals("pending"))	
				reimbursements = rdi.getAllPendingReimbursements();
			
			if(type.equals("resolved"))
				reimbursements = rdi.getAllResolvedReimbursements();
			
			ObjectMapper om = new ObjectMapper();
			String reimbursementsString = om.writeValueAsString(reimbursements);
			reimbursementsString = "{\"reimbursements\":" + reimbursementsString+"}";
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.write(reimbursementsString);	
		}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("here");
		String email = (String)session.getAttribute("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.updateEmplyee(email, firstName, lastName, phone, streetAddress, city, state, zipCode);
		response.sendRedirect("employee.html");
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		if(action.equals("approve"))
			rdi.approveReimbursement(id, (String)session.getAttribute("email"));
		if(action.equals("deny"))
			rdi.denyReimbursement(id, (String)session.getAttribute("email"));
		
		Reimbursement reimbursement = rdi.getReimbursementById(id);
		final String FROM = "nick.costigan@gmail.com";
	    final String FROMNAME = "Nick Costigan";
	    final String SMTP_USERNAME = "AKIAI6V2LLNZN5GMODDA";
	    final String SMTP_PASSWORD = "AgBVAOWekNmQp5oWXCfg+IQHWL98cMMHtECPomeFF6du";
	    final String HOST = "email-smtp.us-east-1.amazonaws.com";
	    final int PORT = 587;
	    final String outcome = action.equals("approve") ? "approved" : "denied";
	    final String SUBJECT ="Your reimbursement request was " + outcome;
	    final String BODY = String.join(
	    	    System.getProperty("line.separator"),
	    	    "<h3>Your reimbursement request with the following information has been " + outcome + ".</h3>",
	    	    "<p>Amount: " + reimbursement.getAmount() + "</p>", 
	    	    "<p>Reason: " + reimbursement.getReason() + "</p>",
	    	    "<p>Resolved by: " + (String)session.getAttribute("email") + "</p>"
	    	);
	    
	    Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");
    	Session session2 = Session.getDefaultInstance(props);
    	
    	MimeMessage msg = new MimeMessage(session2);
    	System.out.println(reimbursement.getRequestedBy().split("\\.")[0]);
        try
        {
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(reimbursement.getRequestedBy(), reimbursement.getRequestedBy().split("\\.")[0]));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");
    	
        Transport transport = session2.getTransport();
        System.out.println("Sending..."); 
        transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        transport.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
    	
		doGet(request, response);
	}
}
