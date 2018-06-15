package com.revature.beans;

import java.util.*;

import com.revature.daos.*;
import com.revature.pojos.*;

public class TestDriver
{

	public static void main(String[] args)
	{
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		ReimbursementRequestDaoImpl rdi = new ReimbursementRequestDaoImpl();
				
		//rdi.approveRiR(1, 1);
		
		System.out.println(rdi.getRiRbyID(1));
	}

}
