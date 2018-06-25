package com.revature.htulipan.project0hibernate.util;

import java.util.ArrayList;

import org.hibernate.Session;

import com.revature.htulipan.project0hibernate.daos.AccountDaoImpl;
import com.revature.htulipan.project0hibernate.daos.UserDaoImpl;
import com.revature.htulipan.project0hibernate.models.BankAccount;
import com.revature.htulipan.project0hibernate.models.BankUser;

public class TestDriver {
	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		s.close();
//		System.out.println("done");
		
		testTheDaos();
	}
	
	private static void testTheDaos() {
		//UserDaoImpl udi = new UserDaoImpl();
		
		
		//System.out.println(udi.getUser("testuser2"));
//		BankUser test = new BankUser();
//		test.setUsername("testuser4");
//		test.setPassword("testpassword");
//		System.out.println(udi.insertUser(test));
//		System.out.println(udi.userExists("testuser3"));
		
		/*
		 * 	public int createAccount(String user, String accountName);
			public int updateAccount(BankAccount updatedAccount);
			public boolean accountExists(String username, String accountname);
			public ArrayList<BankAccount> getUserAccounts(String username);
		 */
		
//		AccountDaoImpl adi = new AccountDaoImpl();
//		
//		//System.out.println(adi.createAccount("testuser2", "testcreateaccount"));
//		System.out.println(adi.accountExists("testuser2", "testcreateaccount"));
//		ArrayList<BankAccount> accounts = adi.getUserAccounts("testuser2");
//		System.out.println(accounts);
//		BankAccount test = accounts.get(0);
//		System.out.println(test);
//		test.setBalance(1235.06f);
//		System.out.println(adi.updateAccount(test));
//		System.out.println(adi.getUserAccounts("testuser2").get(0));
		
		
		
		
	}
}
