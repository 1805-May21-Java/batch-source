package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.UserInfo;

public class SendReimbursement extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public SendReimbursement() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		String temp = request.getReader().readLine();
		String[] requestBody = temp.split(",");
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		Reimbursement re = new Reimbursement();
		re.setId(Integer.parseInt(requestBody[1]));
		re.setUserId(Integer.parseInt(requestBody[0]));
		
		rdi.updateReimbursement(re);
		
//		ObjectMapper om = new ObjectMapper();
//		String str =session.getAttribute("user").toString();
//		str = str.substring(0,str.indexOf("}")+1);
//		str = str.replace("[", "");
//		UserInfo ui = om.readValue(str, UserInfo.class);
	}

}
