package com.revature.main;

import java.io.IOException;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import com.revature.dao.*;
import com.revature.pojos.*;
public class Driver {
	public static void main(String[] args) throws IOException{
		FullDAO service = new FullDAOImpl(); //implement our DAO and interface in this main method
		User john = service.getUserByName("john"); //let's have several different users.
		User jane = service.verify("jane", "pass123"); //from the testing.sql file
		User mark = service.getUserByName("mark");
		System.out.println(service.createUser("hello", "world", "fname", "lname", "email", Role.MANAGER));
		List<Reimbursement> request1 = service.getPendings(jane.getId()); //gets jane's pending requests
		List<Reimbursement> request2 = service.getResolveds(jane.getId()); //gets jane's resolved requests (none right now)
		//System.out.println(service.createRequest("test description", null, jane.getId(), ReimbursementType.VACATION));
		//that was a testing line
		//System.out.println(service.rejectRequest(request1, mark));
		//another supposed testing line that doesn't work
		System.out.println(mark);
		System.out.println(john);
		System.out.println(jane);
		System.out.println(request1);
		System.out.println(request2);
		System.out.println(service.getPendings());
		System.out.println(service.getResolveds());
		//a whole bunch of print lines later
		List<Reimbursement> request3 = service.getPendings(john.getId()); //let's have john get a request sent
		System.out.println(request3);
	}
}
