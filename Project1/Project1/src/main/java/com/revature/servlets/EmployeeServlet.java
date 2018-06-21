package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;
import com.revature.util.BCrypt;


public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 7686085791266631033L;
	ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
	EmployeeDaoImpl edi = new EmployeeDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String employeeEmail; 
		employeeEmail = request.getParameter("employeeEmail");

		if(employeeEmail == null)
			employeeEmail = (String) session.getAttribute("email");
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		String type = request.getParameter("type");

		if(type == null) {
			reimbursements = rdi.getAllReimbursementsForUser(employeeEmail);
		} else {
			if(type.equals("pending"))	
				reimbursements = rdi.getPendingReimbursementsForUser(employeeEmail);
			
			if(type.equals("resolved"))
				reimbursements = rdi.getResolvedReimbursementsForUser(employeeEmail);
			
		}

		ObjectMapper om = new ObjectMapper();
		String reimbursementsString = om.writeValueAsString(reimbursements);
		reimbursementsString = "{\"reimbursements\":" + reimbursementsString+"}";
		response.setContentType("application/json");
		System.out.println(reimbursementsString);
		PrintWriter pw = response.getWriter();
		pw.write(reimbursementsString);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String hashedPassword = BCrypt.hashpw(password, "$2a$10$UoN1BeeYXiuBPKtefJ8Qx.");
		edi.createEmployee(email, hashedPassword);
		final String FROM = "nick.costigan@gmail.com";
	    final String FROMNAME = "Nick Costigan";
	    final String SMTP_USERNAME = "AKIAI6V2LLNZN5GMODDA";
	    final String SMTP_PASSWORD = "AgBVAOWekNmQp5oWXCfg+IQHWL98cMMHtECPomeFF6du";
	    final String HOST = "email-smtp.us-east-1.amazonaws.com";
	    final int PORT = 587;
	    final String SUBJECT ="An account has been created for you";
	    final String BODY = String.join(
	    	    System.getProperty("line.separator"),
	    	    "<h3>An account has been created for you on the Employee Reimbursement System.</h3>",
	    	    "<p>The following is your login information.</p>", 
	    	    "<p>Email: " + email+ "</p>",
	    	    "<p>Temporary password: " + password + "</p>"
	    	);
	    
	    Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");
    	Session session2 = Session.getDefaultInstance(props);
    	
    	MimeMessage msg = new MimeMessage(session2);
        try
        {
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email, "Missy"));
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
		response.sendRedirect("manager.html");
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getReader().readLine();
		if(password != null) {
			HttpSession session = request.getSession(false);
			password = BCrypt.hashpw(password, "$2a$10$UoN1BeeYXiuBPKtefJ8Qx.");
			edi.updatePassword((String) session.getAttribute("email"), password);	
		}
	}
}
