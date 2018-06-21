package com.revature.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERSDaoImpl;
import com.revature.pojos.ReimbursementInfo;

/**
 * Servlet implementation class SubmitServlet
 */
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.getRequestDispatcher("EmployeeSubmitRequest.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//get the input from the reimbursement submission, will fail if not every1 is inputed
		double total = Double.parseDouble(request.getParameter("cost"));
		String reason = request.getParameter("reason");
		String bill = request.getParameter("date");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//transfer the input date as string to util date then to sql date
		java.util.Date billday1 = null;
		Date billday2 = null;
		try {
			billday1 = simpleDateFormat.parse(bill);
			billday2 = new Date(billday1.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = (String) session.getAttribute("name");
		int id = (int) session.getAttribute("userid");
		ERSDaoImpl edi = new ERSDaoImpl();
		ReimbursementInfo ri = new ReimbursementInfo(1, name, reason, total, id, billday2, "NULL");
		edi.submit(ri);
		
		doGet(request, response);
	}

}
