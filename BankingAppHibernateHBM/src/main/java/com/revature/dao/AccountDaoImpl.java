package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.util.HibernateUtil;

import org.hibernate.*;

//Add in your new DAO implementation
public class AccountDaoImpl implements AccountDao{

	public HashMap<String, Account> getAccounts() {
		Session s = HibernateUtil.getSession();
		HashMap<String, Account> accountList = new HashMap<String, Account>();
		List<Account> accounts = s.createQuery("from Account").list();
		for(Account current : accounts) {
			String username = current.getUsername();
			accountList.put(username, current);
		}
		s.close();
		return accountList;
	}

	public Account getAccountById(int id) {
		Session s = HibernateUtil.getSession();
		Account current = (Account) s.get(Account.class, id);
		s.close();
		return current;
	}

	public int createAccount(Account newAccount) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int insert = Integer.parseInt(s.save(newAccount).toString());
		tx.commit();
		s.close();
		return insert;
	}

	public int updateAccount(Account newAccount) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(newAccount);
		tx.commit();
		s.close();
		return 1;
	}

	public int deleteAccountById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Account current = (Account) s.get(Account.class, id);
		if(current != null) {
			s.delete(current);
		}
		tx.commit();
		s.close();
		return 1;
	}
	/*
	public void depositFunds(int id, String accountType, double amount) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Account current = (Account) s.get(Account.class, id);
		if(current != null) {
			current.depositFunds(amount, accountType);
			updateAccount(current);
		}
		tx.commit();
		s.close();
	}

	public void withDrawFunds(int id, String accountType, double amount) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Account current = (Account) s.get(Account.class, id);
		if(current != null) {
			current.withDrawFunds(amount, accountType);
		}
		tx.commit();
		s.close();
	}
	*/

}
