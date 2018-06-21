package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitEmailServlet
 */
public class SubmitEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession(false);
		  if ( session!=null && session.getAttribute("sube") != null) {
	      // Recipient's email ID needs to be mentioned.
	      String to = (String) session.getAttribute("sube");
	      int riid = (int) session.getAttribute("subid");
	      // Sender's email ID needs to be mentioned
	      String from = "xiejingda2009@gmail.com";
	      String host = "localhost";
	      
	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      
		         String title = "Send Email";
		         String res = "Sent message successfully....";
		         String docType =
		            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		         
		         out.println(docType +
		            "<html>\n" +
		               "<head><title>" + title + "</title></head>\n" +
		               "<body bgcolor = \"#f0f0f0\">\n" +
		                  "<h1 align = \"center\">" + title + "</h1>\n" +
		                  "<p align = \"center\">" + res + "</p>\n" +
		                  "<p> <a href=\"ManagerPendingRequest.html\">Go Back</a> </p>" +
		               "</body>" +
		            "</html>"
		         );
	         SendMail sm = new SendMail(from, "eastern123", to, "Reimbursement Accepted", "Your reimbursement request with id: "+
		         riid+" has been accepted.");
	         try {
				sm.send();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   } else {
				response.sendRedirect("mpendingdir");
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
