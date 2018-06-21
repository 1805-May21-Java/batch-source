package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.ReimbursementInfo;

/**
 * Servlet implementation class ManagerResolved
 */
public class ManagerResolved extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerResolved() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//similar to employee manager servlet, just print out the information gotten
		HttpSession session = request.getSession();
		ERSDaoImpl edi = new ERSDaoImpl();
		List<ReimbursementInfo> rialist = new ArrayList<ReimbursementInfo>();
		rialist = edi.viewApproved();
		ObjectMapper om = new ObjectMapper();
		String rialistString = om.writeValueAsString(rialist);
		rialistString = "{\"mrialist\":"+rialistString+"}";
		PrintWriter pw = response.getWriter();
		pw.write(rialistString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
