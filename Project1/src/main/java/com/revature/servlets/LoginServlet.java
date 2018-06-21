package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserInfoDaoImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.UserInfo;


public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		request.getRequestDispatcher("Views/LoginPage.html").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		ObjectMapper om = new ObjectMapper();
		String userString ="[";
		String temp = "";
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		Reimbursement re = new Reimbursement();
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		UserInfo ui = new UserInfo();
		Map<String,UserInfo> userInfoMap = new HashMap<String,UserInfo>();
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		userInfoMap = uidi.getUserInfo();
		reimbList = rdi.getReimbursementInfo();
		
		
		if(userInfoMap.containsKey(user))
		{
			HttpSession session = request.getSession();
			ui = userInfoMap.get(user);
			
			if(pass.equals(ui.getPw()))
			{
				
				userString += om.writeValueAsString(ui);
				if(reimbList.size() >= 1)
				{
					temp = om.writeValueAsString(reimbList);
					temp = temp.replace("[", ",");
					userString += temp;
				}
				else if (reimbList.size() == 0)
				{
					userString += "]";
				}
				session.setAttribute("user", userString);
				response.sendRedirect("home");
			}
			
		}
		else
		{
			request.getRequestDispatcher("Views/Invalid.html").forward(request, response);
		}

	}

}
