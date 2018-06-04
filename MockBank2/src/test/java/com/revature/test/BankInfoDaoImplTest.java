package com.revature.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.revature.pojos.OBankInfo;
import com.revature.dao.*;

public class BankInfoDaoImplTest {

	//The test works, but every time a test is being conducted, the numbers need to change so the test will always work
	@Test 
	public void testGetBankInfo() { //check id the bankinfo here equals to the bankinfo found by the function
		BankInfoDaoImpl bidi = new BankInfoDaoImpl();
		OBankInfo o = bidi.getOBankInfoByUserPass("jingda", "1234");
		OBankInfo a = o;
		assertEquals(a,o);
	}
	
	@Test
	//check to see if a new account created is 1
	public void createAccountTest() {
		BankInfoDaoImpl bidi = new BankInfoDaoImpl();
		int a = bidi.createBankAccount(new OBankInfo ("star", "aaaa","starG@gmail.com",0,0));
		assertEquals(1,a);
	}
	
	@Test
	//check to see if a account has been deleted
	public void deleteAccountTest() {
		BankInfoDaoImpl bidi = new BankInfoDaoImpl();
		int a = bidi.deleteBankAccount("star", "aaaa");
		assertEquals(1,a);
	}
	
	@Test
	//check to see if the value got is equal to the expected value
	public void testIncCheck() {
		BankInfoDaoImpl bidi = new BankInfoDaoImpl();
		bidi.increaseChecking(1, 10000);
		OBankInfo o = bidi.getOBankInfoByUserPass("jingda", "1234");
		int a = (int) o.getCheckingAmount();
		assertEquals(a, 45000);
	}
	
	@Test
	public void testDecCheck() {
		BankInfoDaoImpl bidi = new BankInfoDaoImpl();
		bidi.decreaseChecking(1, 10000);
		OBankInfo o = bidi.getOBankInfoByUserPass("jingda", "1234");
		int a = (int) o.getCheckingAmount();
		assertEquals(a, 35000);
	}
}
