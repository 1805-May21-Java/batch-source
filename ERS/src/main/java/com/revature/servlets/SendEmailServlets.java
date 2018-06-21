package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*; 
import javax.activation.*;
 
public class SendEmailServlets extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   //make sure if the tempemail session that has been set is able to gotten out
    		  HttpSession session = request.getSession(false);
	   if ( session!=null && session.getAttribute("tempemail") != null) {
      // Recipient's email ID needs to be mentioned.
      String to = (String) session.getAttribute("tempemail");
      String user = (String) session.getAttribute("tempuser");
      String pass = (String) session.getAttribute("temppass");
      // Sender's email ID needs to be mentioned
      //set from to my email so it will always send from me
      String from = "xiejingda2009@gmail.com";
      String host = "localhost";
      
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      //write out the send email page for people to see
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
	                  "<p> <a href=\"Signup.html\">Go Back</a> </p>" +
	               "</body>" +
	            "</html>"
	         );
	         //run the send mail class send method
         SendMail sm = new SendMail(from, "eastern123", to, "Temp User for ERS", "user: " +user+" pass: " +pass);
         try {
			sm.send();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   } else {
			response.sendRedirect("signup");
		}
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doGet(request, response);
   }
} 