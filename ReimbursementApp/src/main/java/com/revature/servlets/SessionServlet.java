package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		if(session != null) {
			pw.write("{\"username\":\""+session.getAttribute("username")+"\"}");
			pw.write("{\"isManager\":\""+session.getAttribute("isManager")+"\"}");
			pw.write("{\"user\":\""+session.getAttribute("user")+"\"}");
			//pw.write("{\"username\":\""+session.getAttribute("username")+"\"}");
			//pw.write("{\"password\":\""+ session.getAttribute("password")+"\"}");
			//pw.write("{\"isManager\":\""+session.getAttribute("isManger")+"\"}");
			//pw.write("{\"employeeId\":\""+ session.getAttribute("employeeId")+"\"}");
			//pw.write("{\"name\":\""+ session.getAttribute("name")+"\"}");
			//pw.write("{\"address\":\""+ session.getAttribute("address")+"\"}");
			//pw.write("{\"phone\":\""+ session.getAttribute("phone")+"\"}");
			//pw.write("{\"email\":\""+ session.getAttribute("email")+"\"}");
		}else {
			pw.write("{\"username\": null}");
			pw.write("{\"isManager\": null}");
			pw.write("{\"user\": null}");
			//pw.write("{\"employeeId\": null}");
			//pw.write("{\"name\": null}");
			//pw.write("{\"address\": null}");
			//pw.write("{\"phone\": null}");
			//pw.write("{\"email\": null}");
		}
		pw.close();
	}

	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/

}
