package com.revature.banking.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.banking.pojos.BankAccount;
import com.revature.banking.util.HibernateUtil;

public class AccountImpl implements AccountDao{
	
	protected int user_id;
	protected String user_name;
	protected String pass;
	protected ArrayList<BankAccount> bankAccounts;
	
	public ArrayList<BankAccount> accessBankAccounts(int user_id) {
		List<BankAccount> bankAccounts=new ArrayList<BankAccount>();
		Session s = HibernateUtil.getSession();
		
		Query query=s.createQuery("from BankAccount where user_id=:user");
		query.setInteger("user", user_id);
		
		bankAccounts=query.list();
		
		return (ArrayList) bankAccounts;
	}
	
	/**
	 * CallableStatement callableStatement = session.connection().prepareCall("call GetMarketDataCDS(?,?)");
		callableStatement.setString(1,"JPM");
	 */
	
	public void newCheckingAccount(int user, double amount) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createSQLQuery("CALL NEW_CHECKING(?,?)");
		query.setInteger(0, user);
		query.setDouble(1, amount);
		int num = query.executeUpdate();
		tx.commit();
		
		query=s.createQuery("from BankAccount where acc_type='CHECKING' and user_id="+user);
		if(query.list().size()==1) {
			System.out.println("Congradulation! Since this is your first checking account with Java Banking Application 2.0,\n"
					+ "you have recieved a gift of $100 dollars into your knew Checking account.");
		}
	}
	
	public void newSavingsAccount(int user, double amount) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createSQLQuery("CALL NEW_SAVINGS(?,?)");
		query.setInteger(0, user);
		query.setDouble(1, amount);
		int num = query.executeUpdate();
		tx.commit();
	}
	
	
//	CallableStatement call = ConnectionUtil.getConnection().prepareCall("call NEW_CHECKING(?,?)");
//	call.setInt(1, account.getUser_id());
//	call.setDouble(2, deposit);
//
//	call.executeQuery();
//	
//	clear();
//	System.out.println("Checking account created successfully");
//	
//	Statement newState=ConnectionUtil.getConnection().createStatement();
//	ResultSet result=newState.executeQuery("SELECT * FROM BANK_ACCOUNTS WHERE ACC_TYPE='CHECKING' AND USER_ID="+
//											account.getUser_id());
//	
//	int count=0;
//	while(result.next()) {
//		count++;
//	}
//	
//	if(count==1) {
//		System.out.println("Congradulation! Since this is your first checking account with Java Banking Application 2.0,\n"
//				+ "you have recieved a gift of $100 dollars into your knew Checking account.");
//	}
//	account=access.logIn(account.getUser_name(), account.getPass());
//	System.out.println();
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountImpl other = (AccountImpl) obj;
		if (bankAccounts == null) {
			if (other.bankAccounts != null)
				return false;
		} else if (!bankAccounts.equals(other.bankAccounts))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
	
	
	
}
