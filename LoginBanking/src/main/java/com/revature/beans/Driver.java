package com.revature.beans;

import com.revature.dao.*;

public class Driver
{

	public static void main(String[] args)
	{
		UserDaoImpl udi = new UserDaoImpl();
		
		System.out.println(udi.logIn("Jentoft", "sj") != null);
	}

}
