package com.revature.banking.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.banking.pojos.BankAccount;
import com.revature.banking.util.HibernateUtil;


public class BankAccountImpl implements BankAccountDao{
	
	public boolean withdraw(BankAccount ba, double amount) {
		if(amount>=0 && amount<=ba.getBalance()) {
			Session s = HibernateUtil.getSession();
			Transaction tx = s.beginTransaction();
			s.evict(ba);
			ba.minusBalance(amount);
			s.update(ba);
			tx.commit();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean depsoit(BankAccount ba, double amount) {
		if(amount>=0) {
			Session s = HibernateUtil.getSession();
			Transaction tx = s.beginTransaction();
			s.evict(ba);
			ba.plusBlance(amount);
			s.update(ba);
			tx.commit();
			return true;
		}
		else
			return false;
	
	}
}
