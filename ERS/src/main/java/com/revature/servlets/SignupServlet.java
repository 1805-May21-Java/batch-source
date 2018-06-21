package com.revature.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.EmployeeInfo;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.getRequestDispatcher("Signup.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set all the strings to empty, and get parameter for all of them from the input user had
		//if the input is empty, then it will just leave it empty, but if the required fields are empty, then
		//it will refresh the page without doing anything
		String user = "", pass = "", fname = "", lname = "", email, phone, street, city, state, birth, post;
		int zipcode;
		response.setContentType("application/json");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date birthday1 = null;
		Date birthday2 = null;
		if(request.getParameter("username") != "") {
			user = request.getParameter("username");
		}
		if(request.getParameter("password") != "") {
			pass = request.getParameter("password");
		} 
		if(request.getParameter("firstname") != "") {
			fname = request.getParameter("firstname");
		} 
		if(request.getParameter("lastname") != "") {
			lname = request.getParameter("lastname");
		} 
		if(request.getParameter("birthday") != "") {
			birth = request.getParameter("birthday");
			try {
				birthday1 = simpleDateFormat.parse(birth);
				birthday2 = new Date(birthday1.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		if (request.getParameter("email") != "") {
			email = request.getParameter("email");
		} else {
			email = "none";
		}
		if (request.getParameter("phone") != "") {
			phone = request.getParameter("phone");
		} else {
			phone = "none";
		}
		if (request.getParameter("street") != "") {
			street = request.getParameter("street");
		} else {
			street = "none";
		}
		if (request.getParameter("city") != "") {
			city = request.getParameter("city");
		} else {
			city = "none";
		}
		if (request.getParameter("state") != "") {
			state = request.getParameter("state");
		} else {
			state = "none";
		}
		if (request.getParameter("postcode") != "") {
			post = request.getParameter("postcode");
			zipcode = Integer.parseInt(post);
		} else {
			zipcode = 0;
		}
		HttpSession session = request.getSession();
		//here are the required fields, if its empty then it will just refresh, else, it will redirect it to sendemail
		if(user != "" && pass != "" && fname != "" && lname != "") {
			session.setAttribute("tempuser", user);
			session.setAttribute("temppass", pass);
			session.setAttribute("tempemail", email);
			EmployeeInfo ei = new EmployeeInfo(user, pass, fname+" "+lname, email, phone, birthday2, street, city, state, zipcode);
			ERSDaoImpl edi = new ERSDaoImpl();
			edi.createEmployee(ei);
		}
		response.sendRedirect("sendemail");
	}

}
