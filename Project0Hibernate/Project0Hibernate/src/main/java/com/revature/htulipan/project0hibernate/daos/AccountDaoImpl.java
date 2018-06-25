package com.revature.htulipan.project0hibernate.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.htulipan.project0hibernate.models.BankAccount;
import com.revature.htulipan.project0hibernate.models.BankUser;
import com.revature.htulipan.project0hibernate.util.HibernateUtil;

public class AccountDaoImpl implements BankAccountDao {

	public int createAccount(String user, String accountName) {
		UserDaoImpl udi = new UserDaoImpl();
		BankUser bankuser = udi.getUser(user);
		BankAccount newAccount = new BankAccount();
		
		newAccount.setAccountName(accountName);
		newAccount.setOwner(bankuser);
		newAccount.setBalance(0.0f);
		
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = s.beginTransaction();
			s.save(newAccount);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			s.close();
		}
		return 1;
	}

	public int updateAccount(BankAccount updatedAccount) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = s.beginTransaction();
			s.update(updatedAccount);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			s.close();
		}
		
		return 1;
	}

	public boolean accountExists(String username, String accountname) {
		Session s = HibernateUtil.getSession();
		
		String hql = "from BankAccount where owner = :ownerVar and accountName = :nameVar";
		Query q = s.createQuery(hql);
		q.setString("ownerVar", username);
		q.setString("nameVar", accountname);
		
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		try {
			accounts = q.list();
			if (accounts.size() == 1) return true;
			if (accounts.size() == 0) return false;
			else throw new Exception("There should only be one or zero.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			s.close();
		}
		return false;
	}

	public ArrayList<BankAccount> getUserAccounts(String username) {
		Session s = HibernateUtil.getSession();
		
		String hql = "from BankAccount where owner = :ownerVar";
		Query q = s.createQuery(hql);
		q.setString("ownerVar", username);
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		try {
			for (Object a : q.list()) {
				accounts.add((BankAccount) a);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			s.close();
		}
		
		return accounts;
	}

}
