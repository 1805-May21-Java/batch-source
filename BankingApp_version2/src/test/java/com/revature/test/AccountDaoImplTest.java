package com.revature.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Test;

import com.revature.dao.AccountDaoImpl;
import com.revature.pojos.Account;
import com.revature.util.ConnectionUtil;

import junit.framework.Assert;

public class AccountDaoImplTest {

	//Connection con = ConnectionUtil.getConnection();
	@Test
	public void testGetAccounts() throws IOException, SQLException {
		Connection con = ConnectionUtil.getConnection();
		//fail("Not yet implemented");
		HashMap<String, Account> accounts = null;
		AccountDaoImpl ad1 = new AccountDaoImpl();
		accounts = ad1.getAccounts();
		con.close();
		//Assert.assertNotNull(accounts);
		//Assert.assertEquals(true, false);
		//Assert.assertEquals(40, 24, 0);
	}

}
