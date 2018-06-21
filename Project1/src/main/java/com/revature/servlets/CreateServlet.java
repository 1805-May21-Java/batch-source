package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


public class CreateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public CreateServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("Views/UserCreated.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		
		if(firstName == "" || lastName == "" || email == "" || username == "" || pw == "" || phone == "" || address == "" || state == "" || zipcode == "")
		{
			request.getRequestDispatcher("Views/InvalidInput.html").forward(request, response);
		}
		else
		{
			int zipnum = Integer.parseInt(zipcode);
			UserInfo ui = new UserInfo(username, pw, firstName, lastName, email, phone, address, state, zipnum);
			
			request.getRequestDispatcher("Views/UserCreated.html").forward(request, response);
			uidi.createUser(ui);
		}

	}

}
