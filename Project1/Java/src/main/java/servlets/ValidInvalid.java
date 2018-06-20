package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class ValidInvalid
 */
public class ValidInvalid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidInvalid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Sees if valid or invalid email entered and send to settings menu
		PrintWriter printWriter = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		if(session.getAttribute("emailInvalid") != null && (Boolean) session.getAttribute("emailInvalid")){
			//sees if the session has an attribute emailInvalid, and if that attribute is incorrect.  
			jsonObject.put("emailValid", "Invalid");
			printWriter.println(jsonObject);
		}else {
			//User has not logged in at all
			jsonObject.put("emailValid", "Valid");
			printWriter.println(jsonObject);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
