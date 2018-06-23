package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import com.revature.pojos.Account;
import com.revature.pojos.User;
import com.revature.utils.HibernateUtil;

public class AccountDaoImpl implements AccountDao{

	public List<Account> getAccounts() {
		Session s = HibernateUtil.getSession();
		List<Account> accounts = s.createQuery("from Account").list();
		s.close();
		
		return accounts;
	}

	public List<Account> getAccountsByUser(int userId) {
		Session s = HibernateUtil.getSession();
		User user = (User) s.get(User.class, userId);
		List<Account> accounts = new ArrayList<Account>();
		if(user != null) {
			for(Account account : user.getLinkedAccounts()) {
				accounts.add((Account) s.get(Account.class, account.getAccountNumber()));
			}
		}
		s.close();
		
		return accounts;
	}

	public Account getAccountByNumber(long accountNumber) {
		Session s = HibernateUtil.getSession();
		Account account = (Account) s.get(Account.class, accountNumber);
		s.close();
		
		return account;
	}

	public int createAccount(Account account, int userId) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		List<User> uList = new ArrayList<User>();
		uList.add((User) s.get(User.class, userId));
		account.setUsers(uList);
		int pk = Integer.parseInt(s.save(account).toString());
		tx.commit();
		s.close();
		
		return pk;
	}

	public int updateAccount(Account accont) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(accont);
		tx.commit();
		s.close();
		
		return 1;
	}

	public int deleteAccount(int acccountNumber) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Account account = (Account) s.get(Account.class, acccountNumber);
		if(account != null) {
			s.delete(account);
		}
		tx.commit();
		s.close();
		
		return 1;
	}

}
