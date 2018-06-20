package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DaoEmployeeImpl;
import com.revature.pojos.Employee;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("employee") == null) {
			//checks if valid session
			request.getRequestDispatcher("Logout").forward(request, response);
		}else {
			//if it is, see if valid or invalid email entered and send to settings menu
			PrintWriter printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			if(session.getAttribute("emailInvalid") != null && (Boolean) session.getAttribute("emailInvalid")){
				//sees if the session has an attribute emailInvalid, and if that attribute is incorrect.  
				//If so, user has tried and failed to login
				jsonObject.put("emailValid", "incorrect");
				printWriter.println(jsonObject);
			}else {
				//User has not logged in at all
				jsonObject.put("emailValid", "emptyOrValid");
				printWriter.println(jsonObject);
			}
			
			request.getRequestDispatcher("settings.html").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reads in updated employee and saves to database
				DaoEmployeeImpl daoEmployeeImpl = new DaoEmployeeImpl();
				HttpSession session = request.getSession();
				
				Employee oldEmployeeFields = (Employee) session.getAttribute("employee");
				ObjectMapper mapper = new ObjectMapper();
				Employee newEmployeeFields = mapper.readValue(request.getReader().readLine(), Employee.class);
				//checks if new email is either unique or equal to the old email
				if(!daoEmployeeImpl.emailExists(newEmployeeFields.getEmail())
						|| oldEmployeeFields.getEmail().equals(newEmployeeFields.getEmail())) {
					//email either unque or the same as the old email
					oldEmployeeFields.setName(newEmployeeFields.getName());
					oldEmployeeFields.setEmail(newEmployeeFields.getEmail());
					oldEmployeeFields.setPassword(newEmployeeFields.getPassword());
					daoEmployeeImpl.updateOldEmployee(oldEmployeeFields);
					//valid changed email
					session.setAttribute("emailInvalid", false);
				}else {
					//email was invalid, send error message
					session.setAttribute("emailInvalid", true);
				}	
				//Forward to another servlet that prints results
				response.sendRedirect("ValidInvalid");
	}
}
