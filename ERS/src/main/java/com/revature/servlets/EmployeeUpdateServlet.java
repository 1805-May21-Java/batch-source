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
 * Servlet implementation class EmployeeUpdateServlet
 */
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("EmployeeUpdateInfo.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//set the needed attributes for updating
		String user, fname, lname, email, phone, street, city, state, birth, post;
		int zipcode;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date birthday1 = null;
		Date birthday2 = null;
		//set the if statements, if user entered something for one of the input text columns, use the input, but if it was left empty
		//then use the original information that was stored in session when logging in
		if(request.getParameter("username") != "") {
			user = request.getParameter("username");
		} else {
			user = (String) session.getAttribute("username");
		}
		String name = (String) session.getAttribute("name");
		int a = name.indexOf(" ");
		if(request.getParameter("firstname") != "") {
			fname = request.getParameter("firstname");
		} else {
			fname = name.substring(0,a);
		}
		if(request.getParameter("lastname") != "") {
			lname = request.getParameter("lastname");
		} else {
			lname = name.substring(a+1);
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
		} else {
			birthday2 = (Date) session.getAttribute("birthday");
		}
		if (request.getParameter("email") != "") {
			email = request.getParameter("email");
		} else {
			email = (String) session.getAttribute("email");
		}
		if (request.getParameter("phone") != "") {
			phone = request.getParameter("phone");
		} else {
			phone = (String) session.getAttribute("phone");
		}
		if (request.getParameter("street") != "") {
			street = request.getParameter("street");
		} else {
			street = (String) session.getAttribute("street");
		}
		if (request.getParameter("city") != "") {
			city = request.getParameter("city");
		} else {
			city = (String) session.getAttribute("city");
		}
		if (request.getParameter("state") != "") {
			state = request.getParameter("state");
		} else {
			state = (String) session.getAttribute("state");
		}
		if (request.getParameter("postcode") != "") {
			post = request.getParameter("postcode");
			zipcode = Integer.parseInt(post);
		} else {
			zipcode = (int) session.getAttribute("zipcode");
		}
		Integer userid = (int) session.getAttribute("userid");
		String pass = (String) session.getAttribute("password");
		//get the new information and make a new ei class with it, then run the function to update it to the database
		EmployeeInfo ei = new EmployeeInfo(userid, user, pass, fname+" "+lname, email, phone, birthday2, street, city, state, zipcode);
		ERSDaoImpl edi = new ERSDaoImpl();
		edi.updateEmployee(ei);
		response.sendRedirect("update");
	}

}
