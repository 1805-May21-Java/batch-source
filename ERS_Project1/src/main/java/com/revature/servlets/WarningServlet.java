package com.revature.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.actors.GateKeeper;

/**
 * Servlet implementation class WarningServlet
 */
public class WarningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarningServlet() {
        super();
    }
    
   
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json");
		if (GateKeeper.getWarning() != "") {
			pw.write("{\"warning\":\"" + GateKeeper.getWarning()+"\"}");
		} else {
			pw.write("{\"warning\": null}");
		}
		pw.close();
		// Clear warning so that it doesn't show up in the next screen
		GateKeeper.setWarning("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
