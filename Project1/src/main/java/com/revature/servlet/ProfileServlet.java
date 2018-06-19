package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ERSDaoImpl;
import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;
import com.revature.servlet.SessionServlet.Info;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = -7797812828514308149L;
	ERSDaoImpl dao = new ERSDaoImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("id") != null)
			req.getRequestDispatcher("profile.html").forward(req, res);
		else
			res.sendRedirect("login");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SessionServlet.clearMessagesAndErrors();
		
		if(req.getParameter("amount") != null) {
			try{
				double amount = Double.parseDouble(req.getParameter("amount"));
				String description = req.getParameter("description");
				String picURL = req.getParameter("picURL");
				
				Random r = new Random();
				int reimb_id = r.nextInt(90000000) + 10000000;
				while(dao.getReimbursementByID(reimb_id) != null)
					reimb_id = r.nextInt(90000000) + 10000000;
				int request_id = SessionServlet.empl.getID();
				Date requestDate = Date.valueOf(LocalDate.now());
				String status = "Pending";
				
				dao.createReimbursement(new Reimbursement(reimb_id, request_id,
						picURL, amount, description, requestDate, status, 0, null));
			} catch(NumberFormatException e) {
				e.printStackTrace();
				SessionServlet.errors.add(new Info("Invalid amount provided", true));
			}
			res.sendRedirect("profile");
		}
		else if(req.getParameter("emplBday") != null) {
			String first = req.getParameter("emplFirst");
			String email = req.getParameter("emplEmail");
			String last = req.getParameter("emplLast");
			Date bday = null;
			
			if(!req.getParameter("emplBday").equals(""))
				bday = Date.valueOf(req.getParameter("emplBday"));
			else
				bday = SessionServlet.empl.getBday();
			
			if(!first.equals("") || !last.equals("") || !email.equals("") || !bday.equals(SessionServlet.empl.getBday()))
				SessionServlet.messages.add(new Info("Personal info updated", true));
			
			if(first.equals(""))
				first = SessionServlet.empl.getFirst();
			if(last.equals(""))
				last = SessionServlet.empl.getLast();
			if(email.equals(""))
				email = SessionServlet.empl.getEmail();
			
			SessionServlet.empl.setFirst(first);
			SessionServlet.empl.setLast(last);
			SessionServlet.empl.setEmail(email);
			SessionServlet.empl.setBday(bday);
			dao.updateEmployee(SessionServlet.empl);
			
			res.sendRedirect("profile");
		}
		else if(req.getParameter("removeReimb") != null) {
			dao.deleteReimbByID(Integer.parseInt(req.getParameter("removeReimb")));
			
			SessionServlet.messages.add(new Info("Reimbursement request removed", true));
			
			res.sendRedirect("profile");
		}
		else if(req.getParameter("reimbAction") != null) {
			Reimbursement reimb = dao.getReimbursementByID(Integer.parseInt(req.getParameter("reimbValue")));
			if(req.getParameter("reimbAction").equals("approve"))
				reimb.setStatus("Approved");
			else if(req.getParameter("reimbAction").equals("deny"))
				reimb.setStatus("Denied");
			reimb.setApproveID(SessionServlet.empl.getID());
			reimb.setDateOfApprove(Date.valueOf(LocalDate.now()));
			
			SessionServlet.messages.add(new Info("Reimbursement request: " + reimb.getStatus(), true));
			
			dao.updateReimbursement(reimb);
			res.sendRedirect("profile");
		}
		else if(req.getParameter("newEmail") != null) {
			String email = req.getParameter("newEmail");
			String first = req.getParameter("newFirst");
			String last = req.getParameter("newLast");
			String title = req.getParameter("newTitle");
			
			if(dao.getEmployeeByEmail(email) != null) {
				SessionServlet.errors.add(new Info("Email already exists in the database", true));
			}
			else {
				Random r = new Random();
				int ID = r.nextInt(90000000) + 10000000;
				while(dao.getEmployeeByID(ID) != null)
					ID = r.nextInt(90000000) + 10000000;
				Employee empl = new Employee(ID, email, "pass", first, last, null,
						title, SessionServlet.empl.getID(), false, new ArrayList<Employee>());
				dao.createEmployee(empl);
				SessionServlet.messages.add(new Info("Added new Employee!", true));
			}
			
			res.sendRedirect("profile");
		}
		else if(req.getParameter("existingID") != null) {
			int ID = Integer.parseInt(req.getParameter("existingID"));
			
			if(dao.getEmployeeByID(ID) == null) {
				SessionServlet.errors.add(new Info("No such employee exists", true));
			}
			else {
				Employee empl = dao.getEmployeeByID(ID);
				empl.setManagerID(SessionServlet.empl.getID());
				dao.updateEmployee(empl);
				SessionServlet.messages.add(new Info("Successfully added Employee!", true));
			}
			
			res.sendRedirect("profile");
		}
		else if(req.getParameter("logout") != null) {
			SessionServlet.empl = new Employee();
			req.getSession(false).removeAttribute("id");
			res.sendRedirect("login");
		}
//			BufferedReader br = req.getReader();
//			String post = br.readLine();
//			if(post.matches("^RemoveReimb [0-9]{8}$")) {
//				int reimb_id = Integer.parseInt(post.substring(12));
//				dao.deleteReimbByID(reimb_id);
//				res.sendRedirect("profile");
//			}
//			else if(post.equals("Logout")) {
//				SessionServlet.empl = new Employee();
//				req.getSession(false).removeAttribute("id");
//				res.sendRedirect("login");
//			}
			// more possible custom post requests
	}
}