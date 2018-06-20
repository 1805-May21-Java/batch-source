package servlets;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.DaoEmployeeImpl;
import com.revature.pojos.Employee;
import com.revature.pojos.Manager;
import com.revature.pojos.Reimbursement;

/**
 * Servlet implementation class NewReimbursement
 */
public class NewReimbursementEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewReimbursementEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

    static final String FROM = "reimbursementhr@gmail.com";
    static final String FROMNAME = "Universal Reimbursal";
    
    static final String SMTP_USERNAME = "AKIAJYJMK3HVJXQO3XTA";
    
    static final String SMTP_PASSWORD = "AhyV+CAd6xueUaQ8IXvsH/l7hqsnMH0vvAtyjtGWY3ku";
    
    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
  //  static final String CONFIGSET = "ConfigSet";
    
    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    // See http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
    // for more information.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    
    // The port you will connect to on the Amazon SES SMTP endpoint. 
    static final int PORT = 587;
    
    static final String SUBJECT = "New Reimbursement Request";
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a Properties object to contain connection configuration information.
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");
    	
    	try {
    		
	    	HttpSession currentSession = request.getSession();
	    	//get manager info for person who submitted reimbursement
	    	Employee employee = (Employee) currentSession.getAttribute("employee");
	    	Reimbursement reimbursement = (Reimbursement) currentSession.getAttribute("newReimbursement");
	    	int managerId = employee.getManagerId();
	    	DaoEmployeeImpl daoEmployeeImpl = new DaoEmployeeImpl();
	    	Employee manager = (Employee) daoEmployeeImpl.getEmployeeById(managerId);
	    	 final String BODY = String.join(
	    	    	    System.getProperty("line.separator"),
	    	    	    "<p>Hello, "+manager.getName()+"!", 
	    	    	    "<br><br>Your employee "+employee.getName(),
	    	    	    " has sumbitted a new reimbursement request.",
	    	    	    "  The details of this reimbursement are below:",
	    	    	    "<br><br>Name: "+reimbursement.getName(),
	    	    	    "<br>Amount: "+reimbursement.getReimbursementAmount(),
	    	    	    "<br>Description: "+reimbursement.getDescription(),
	    	    	    "<br><br>The reimbursement can be approved or denied <a href='http://localhost:8082/Project1/'>here.</a>"
	    	    	);
	    	 final String TO = manager.getEmail();
	
	        // Create a Session object to represent a mail session with the specified properties. 
	    	Session session = Session.getDefaultInstance(props);
	
	        // Create a message with the specified information. 
	        MimeMessage msg = new MimeMessage(session);
        
        	 // Add a configuration set header. Comment or delete the 
            // next line if you are not using a configuration set
			msg.setFrom(new InternetAddress(FROM,FROMNAME));
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
	        msg.setSubject(SUBJECT);
	        msg.setContent(BODY,"text/html");
	    //    msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
	        // Create a transport.
	        Transport transport = session.getTransport();
	        
	     // Send the message.

	        System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        	transport.close();
			
		} catch (Exception e) {
			System.out.println("Email not sent");          
             
		}finally {
			response.sendRedirect("ValidInvalid");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

