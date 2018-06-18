package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.revature.dao.CheckingDaoImpl;
import com.revature.dao.UserInfoDaoImpl;
import com.revature.pojos.Checking;
import com.revature.pojos.UserInfo;
import com.revature.util.ConnectionUtil;

public class TestClass
{
	/*
	 * This is my testing class, I only tested the methods from my user info implementation because the methods
	 * from my checking and saving ones were almost the same. They have the same functionality, just different
	 * variables and names. I tested each case by it's self and used commands in SQL to insert some rows.
	 */
	//Testing the createUser method
	@Test
	public void createUser()
	{
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		UserInfo uid = new UserInfo(1, "ice101v", "gice101v@gmail.com", "password");
		
		int created = uidi.createUser(uid);
		assertEquals(1, created);
	}
	
	//Testing the procedure I made in SQL
	@Test
	public void procedure()
	{
		try
		{
			Connection con = ConnectionUtil.getConnection();
			CallableStatement cs = con.prepareCall("BEGIN DEPOSIT_CHECKING(?, ?); END;");
			cs.setInt(1, 1);
			cs.setInt(2, 1000);
			
			boolean deposited = cs.execute();
			assertEquals(false,deposited);
		}
		catch (IOException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Testing the getUserMethod
	@Test
	public void getUser()
	{
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		Map<String,UserInfo> hash = new HashMap<String,UserInfo>();
		hash = uidi.getUserInfo();
		assertEquals(uidi.getUserInfo(), hash);

	}
	
	//Testing the getUserbyId method
	@Test
	public void getUserbyId()
	{
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		UserInfo ui = new UserInfo();
		
		ui = uidi.getUserById(1);
		assertEquals(uidi.getUserById(1), ui);
	}
	
	//Testing the updateUser method
	@Test
	public void updateUser()
	{
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		UserInfo ui = new UserInfo(1, "gice", "something", "thing");
		int updated = uidi.updateUser(ui);
		assertEquals(1, updated);
	}
	
	//Testing the deleteUser method
	@Test
	public void deleteUser()
	{
		UserInfoDaoImpl uidi = new UserInfoDaoImpl();
		Map<String, UserInfo> hash = new HashMap<String, UserInfo>();
		hash = uidi.getUserInfo();
		UserInfo ui = new UserInfo("ice", "", "");
		uidi.createUser(ui);
		hash = uidi.getUserInfo();
		ui = hash.get("ice"); 
		uidi.deleteUser(ui);
		System.out.println(ui.getId());
	}
	
}
