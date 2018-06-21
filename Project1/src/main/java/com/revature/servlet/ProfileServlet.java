package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
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
import com.revature.util.MailUtil;

/*
 * Profile Servlet
 * 
 * Since profile.html and profile.js construct a single page application,
 * this servlet handles many use cases in the doPost service method.
 * 
 * In most cases, the MailUtil class is used to send automated email messages
 * to inform the user of various changes in the system
 * 
 * In the case of lacking an active session, the user is redirected to the login page
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = -7797812828514308149L;
	private static final DecimalFormat df = new DecimalFormat("#0.00");
	ERSDaoImpl dao = new ERSDaoImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		// If there is no active session, redirect to the login page
		if(session != null && session.getAttribute("id") != null)
			req.getRequestDispatcher("profile.html").forward(req, res);
		else
			res.sendRedirect("login");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SessionServlet.clearMessagesAndErrors();
		
		// Handles submission of new reimbursement requests
		if(req.getParameter("amount") != null) {
			try{
				double amount = Double.parseDouble(req.getParameter("amount"));
				if(amount < 0.01) {
					SessionServlet.errors.add(new Info("Invalid request amount", true));
				}
				else {
					String description = req.getParameter("description");
					String picURL = req.getParameter("picURL");
					
					Random r = new Random();
					int reimb_id = r.nextInt(90000000) + 10000000;
					while(dao.getReimbursementByID(reimb_id) != null)
						reimb_id = r.nextInt(90000000) + 10000000;
					int request_id = SessionServlet.empl.getID();
					Date requestDate = Date.valueOf(LocalDate.now());
					String status = "Pending";
					
					if(description.length() > 255) {
						SessionServlet.errors.add(new Info("Description truncated to max length of 255 characters", true));
						description = description.substring(0, 255);
					}
					SessionServlet.messages.add(new Info("Successfully submit reimbursement request", true));
					
					MailUtil.send("p1reimbursements@gmail.com", "Passw0rd---",
							SessionServlet.empl.getEmail(), "Reimbursement Request Received",
							"Hello " + SessionServlet.empl.getFirst() +
							",\n\nYour reimbursement request has been processed!\n\nRequest Details:\nAmount - $" +
							df.format(amount) + "\nDescription - " + description + "\n\nYou can track the activity of " +
							"this request in the \"Your Request\" tab of the ERS Portal." +
							"\n\nBest,\n\nERS Team");
					
					dao.createReimbursement(new Reimbursement(reimb_id, request_id,
							picURL, amount, description, requestDate, status, 0, null));
				}
			} catch(NumberFormatException e) {
				e.printStackTrace();
				SessionServlet.errors.add(new Info("Invalid amount provided", true));
			}
			res.sendRedirect("profile");
		}
		
		// Handles personal info edits and password resets
		else if(req.getParameter("emplBday") != null || req.getParameter("emplPass") != null) {
			if(req.getParameter("emplBday") != null) {
				String first = req.getParameter("emplFirst");
				String email = req.getParameter("emplEmail");
				String last = req.getParameter("emplLast");
				Date bday = null;
				
				if(first == null)
					first = "";
				if(last == null)
					last = "";
				if(email == null)
					email = "";
				
				if(!req.getParameter("emplBday").equals(""))
					bday = Date.valueOf(req.getParameter("emplBday"));
				else
					bday = SessionServlet.empl.getBday();
				
				if(!first.equals("") || !last.equals("") || !email.equals("") || (bday != null && !bday.equals(SessionServlet.empl.getBday())))
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
			}
			if(req.getParameter("emplPass") != null) {
				String pass = req.getParameter("emplPass");
				if(!pass.equals(req.getParameter("emplPass2"))) {
					SessionServlet.errors.add(new Info("New passwords do not match", true));
				}
				else if(!Employee.validatePassword(pass)){
					SessionServlet.errors.add(new Info("Password does not match criteria", true));
				}
				else {
					SessionServlet.empl.setPass(pass);
					dao.updateEmployee(SessionServlet.empl);
					
					MailUtil.send("p1reimbursements@gmail.com", "Passw0rd---",
							SessionServlet.empl.getEmail(), "ERS Account Password Reset",
							"Hello " + SessionServlet.empl.getFirst() +
							",\n\nYour password has been reset!\n\nNew Password - " +
							pass + "\n\nUse this new password next time you wish to log " +
							"in to your ERS Account.\n\nBest,\n\nERS Team");
					
					SessionServlet.messages.add(new Info("Password successfully reset", true));
				}
			}
			res.sendRedirect("profile");
		}
		
		// Handles request removal by the requesting user
		else if(req.getParameter("removeReimb") != null) {
			dao.deleteReimbByID(Integer.parseInt(req.getParameter("removeReimb")));
			
			MailUtil.send("p1reimbursements@gmail.com", "Passw0rd---",
					SessionServlet.empl.getEmail(), "Reimbursement Request #"
					+ req.getParameter("removeReimb") + " Removed",
					"Hello " + SessionServlet.empl.getFirst() +
					",\n\nYour reimbursement request has been removed.\n\nBest,\n\nERS Team");
			
			SessionServlet.messages.add(new Info("Reimbursement request removed", true));
			
			res.sendRedirect("profile");
		}
		
		// Handles approval/denial of requests by the requester's manager
		else if(req.getParameter("reimbAction") != null) {
			Reimbursement reimb = dao.getReimbursementByID(Integer.parseInt(req.getParameter("reimbValue")));
			if(req.getParameter("reimbAction").equals("approve"))
				reimb.setStatus("Approved");
			else if(req.getParameter("reimbAction").equals("deny"))
				reimb.setStatus("Denied");
			reimb.setApproveID(SessionServlet.empl.getID());
			reimb.setDateOfApprove(Date.valueOf(LocalDate.now()));
			
			SessionServlet.messages.add(new Info("Reimbursement request " +
					reimb.getStatus().toLowerCase(), true));
			
			dao.updateReimbursement(reimb);
			
			MailUtil.send("p1reimbursements@gmail.com", "Passw0rd---",
					dao.getEmployeeByID(reimb.getRequestID()).getEmail(), "Reimbursement Request #"
					+ reimb.getID() + " " + reimb.getStatus(),
					"Hello " + dao.getEmployeeByID(reimb.getRequestID()).getFirst() +
					",\n\nYour reimbursement request has been " + reimb.getStatus().toLowerCase()
					+ " by your manager.\n\nBest,\n\nERS Team");
			
			res.sendRedirect("profile");
		}
		
		// Handles creation of a new Employee by their manager
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
				
				MailUtil.send("p1reimbursements@gmail.com", "Passw0rd---",
						email, "Welcome to the ERS",
						"Hello " + first + ",\n\nWelcome to the ERS!\n\nYou have been added to " +
						"the system by your manager, " + SessionServlet.empl.getFirst() +
						".\n\nYour new EMPL ID is: " + ID + "\nYour new password is: pass" +
						"\n\nLog into your ERS account using your email and the provided password." +
						"\n\nIt is highly recommended that you reset your password immediately from " +
						"the \"Profile\" tab of the ERS Portal to follow password security criteria." +
						"\n\nBest,\n\nERS Team");
				
				SessionServlet.messages.add(new Info("Added new Employee!", true));
			}
			
			res.sendRedirect("profile");
		}
		
		// Handles the manager adding/removing an existing Employee to/from their roster
		else if(req.getParameter("existingAction") != null) {
			int ID = Integer.parseInt(req.getParameter("existingID"));
			String action = req.getParameter("existingAction");
			
			if(action.equals("register")) {
				if(dao.getEmployeeByID(ID) == null) {
					SessionServlet.errors.add(new Info("No such employee exists", true));
				}
				else if(dao.getEmployeeByID(ID).getManagerID() != 0) {
					SessionServlet.errors.add(new Info("Employee already reports to a manager", true));
				}
				else {
					Employee empl = dao.getEmployeeByID(ID);
					empl.setManagerID(SessionServlet.empl.getID());
					dao.updateEmployee(empl);
					
					MailUtil.send("p1reimbursements@gmail.com", "Passw0rd---",
							dao.getEmployeeByID(ID).getEmail(), "Added by Manager",
							"Hello " + dao.getEmployeeByID(ID).getFirst() + ",\n\nYou have been added by " +
							"your manager, " + SessionServlet.empl.getFirst() +
							"!\n\nYour reimbursement requests may now be resolved by your manager." +
							"\n\nBest,\n\nERS Team");
					
					SessionServlet.messages.add(new Info("Successfully added Employee!", true));
				}
			}
			
			// Handles t
			else if(action.equals("unregister")) {
				if(dao.getEmployeeByID(ID) == null) {
					SessionServlet.errors.add(new Info("No such employee exists", true));
				}
				else if(dao.getEmployeeByID(ID).getManagerID() != SessionServlet.empl.getID()) {
					SessionServlet.errors.add(new Info("Employee does not directly report to you", true));
				}
				else {
					Employee empl = dao.getEmployeeByID(ID);
					empl.setManagerID(0);
					dao.updateEmployee(empl);
					
					MailUtil.send("p1reimbursements@gmail.com", "Passw0rd---",
							dao.getEmployeeByID(ID).getEmail(), "Removed by Manager",
							"Hello " + dao.getEmployeeByID(ID).getFirst() + ",\n\nYou have been removed from " +
							SessionServlet.empl.getFirst() + "'s roster." +
							"\n\nFor now, your reimbursement requests will not be resolved until you are added to " +
							"a manager's roster in the system." +
							"\n\nBest,\n\nERS Team");
					
					SessionServlet.messages.add(new Info("Successfully removed Employee!", true));
				}
			}
			
			res.sendRedirect("profile");
		}
		
		// Handles the logout button by ending session and clearing the static Employee variable
		else if(req.getParameter("logout") != null) {
			SessionServlet.empl = new Employee();
			req.getSession(false).removeAttribute("id");
			res.sendRedirect("login");
		}
	}
}