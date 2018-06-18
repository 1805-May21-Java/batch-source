package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserInfoDaoImpl;
import com.revature.pojos.UserInfo;


public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private Map<String,UserInfo> userInfoMap = new HashMap<String,UserInfo>();
	private UserInfoDaoImpl uidi = new UserInfoDaoImpl();
	private UserInfo ui = new UserInfo();
       

    public LoginServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		request.getRequestDispatcher("LoginPage.html").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		ObjectMapper om = new ObjectMapper();
		String userString = "";
		userInfoMap = uidi.getUserInfo();

		
		if(userInfoMap.containsKey(user))
		{
			HttpSession session = request.getSession();
			ui = userInfoMap.get(user);	
			if(pass.equals(ui.getPw()))
			{
				userString = om.writeValueAsString(ui);
				session.setAttribute("user", userString);
				response.sendRedirect("home");
			}
			
		}
		else
		{
			response.sendRedirect("login");
		}

	}

}
