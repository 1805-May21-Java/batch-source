package com.revature;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.revature.dao.TransactionDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionDaoTest {
	static TransactionDaoImpl tdi;
	static UserDaoImpl udi;
	static User user;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tdi = new TransactionDaoImpl();
		udi = new UserDaoImpl();
		user = udi.getUser("testUser", "testPassword");
	}

	@Test
	public void aTestCreateTransaction() {
		assertEquals(tdi.createTransaction("withdraw", 25.55, user.getUsername()), 1);
	}
	
	@Test
	public void bTestGetTransactions() {
		assertEquals(tdi.getTransactions(user.getUsername()).size(), 5);
	}

}
