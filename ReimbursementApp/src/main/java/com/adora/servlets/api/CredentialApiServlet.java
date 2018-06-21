package com.adora.servlets.api;

import java.awt.Desktop.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.access.CredentialDaoImpl;
import com.adora.managers.SessionManager;
import com.adora.pojos.Credential;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CredentialApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = SessionManager.getEmployeeId(request);
		
		//action get
		String credentialStr = "";
		ObjectMapper om = new ObjectMapper();
		CredentialDaoImpl cdi = new CredentialDaoImpl();
		Credential credential = cdi.getCredentials(employeeId);
		
		credentialStr = om.writeValueAsString(credential);
		credentialStr = "{\"credential\": " + credentialStr +"}";
		
		response.getWriter().write(credentialStr);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");	
		String password = request.getParameter("password" );
		String action = request.getParameter("action");
		String newPassword = request.getParameter("new_password");
		String oldPassword = request.getParameter("old_password");
		String confirmNewPassword = request.getParameter("new_password_confirm");
		//action login
		//action update
		//action new
		
		
		System.out.println(username);
		System.out.println(password);
		
		
		if(username!= null && username.split(" ").length != 1) {
			//TODO message
			System.out.println("The username must not contain spaces.");
			return;
		}
		if(username != null && username.compareTo(username.trim()) != 0) {
			//TODO message
			System.out.println("The username must not contain spaces.");
			return;
		}
		
		if(password != null && password.length() < 8) {
			//TODO message
			System.out.println("Password must be at least 8 characters.");
			return;
		}
		if(password != null && password.split(" ").length != 1) {
			//TODO message
			System.out.println("Password cannot contain spaces.");
			return;
		}
		if(password != null && password.compareTo(password.trim()) != 0) {
			//TODO message
			System.out.println("Password cannot contain spaces.");
			return;
		}
		System.out.println(action);
		
		if(action.equals("login")) {
			System.out.println("logging in");
			// check the credentials
			Credential credential = new Credential(username, password);
			CredentialDaoImpl cdi = new CredentialDaoImpl();
			Credential validCredential = cdi.checkCredentials(credential);
	
			
			if(validCredential.getEmployee_id() != 0) {
				System.out.println("I have the employee");
				SessionManager.logIn(request, validCredential);
				response.sendRedirect("../home");
			} 
			else {
				response.sendRedirect("../login");
			}
		} else if(action.equals("update")) {
			
			System.out.println("update credentials");
			// check the credentials
			Credential credential = new Credential(username, oldPassword);
			CredentialDaoImpl cdi = new CredentialDaoImpl();
			Credential validCredential = cdi.checkCredentials(credential);
			
			if(validCredential.getEmployee_id() > 0) {
				if(newPassword.equals(confirmNewPassword)) {
					validCredential.setPassword(newPassword);
					int result = cdi.updateCredentials(validCredential);
					if(result == 1) {
						System.out.println("successful update");
					} else {
						System.out.println("unsuccessful update");
					}
				} else {
					System.out.println("passwords do not match");
				}
				
			}
			
			response.sendRedirect("../profile");
		}
	}
}
