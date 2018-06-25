package com.revature.banking.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.banking.pojos.Account;
import com.revature.banking.util.HibernateUtil;

public class AccessImpl implements AccessDao{
	
	protected Connection connect;
	
	
	
	public com.revature.banking.pojos.Account signUp(String user, String pass) {
		Account newAccount=null;
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Query query = s.createQuery("from Account where user_name=:user");
		query.setString("user", user);
		
		List<Account> accounts=query.list();
		
		if(accounts.isEmpty()) {
			newAccount=new Account(user, pass);
			s.save(newAccount);
			tx.commit();
			
			query=s.createQuery("from Account where user_name=:user");
			query.setString("user", user);
			
			accounts=query.list();
			if(!accounts.isEmpty()) {
				newAccount=accounts.get(0);
			}
		}
		
		return newAccount;
	}
	
	public Account logIn(String user, String pass) {
		Account account=null;
		Session s = HibernateUtil.getSession();
		
		Query query =s.createQuery("from Account where user_name=:name and pass=:password");
		query.setString("name", user);
		query.setString("password", pass);
		
		List<Account> accounts=query.list();
		
		if(!accounts.isEmpty()) {
			account=accounts.get(0);
			account.setBankAccounts(account.accessBankAccounts(account.getUser_id()));
		}
		else {
			account=null;
		}
		
		return account;
	}
	
	
	
}
