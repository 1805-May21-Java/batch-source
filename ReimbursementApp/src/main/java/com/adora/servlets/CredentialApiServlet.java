package com.adora.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adora.access.CredentialDaoImpl;
import com.adora.managers.SessionManager;
import com.adora.pojos.Credential;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class CredentialApiServlet
 */
public class CredentialApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CredentialApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = SessionManager.getEmployeeId(request);
		
		String credentialStr = "";
		ObjectMapper om = new ObjectMapper();
		CredentialDaoImpl cdi = new CredentialDaoImpl();
		Credential credential = cdi.getCredentials(employeeId);
		
		credentialStr = om.writeValueAsString(credential);
		credentialStr = "{\"credential\": " + credentialStr +"}";
		
		response.getWriter().write(credentialStr);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
