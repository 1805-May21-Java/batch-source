package com.adora.access;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adora.object.Account;
import com.adora.object.Customer;
import com.adora.util.ConnectionUtil;
import com.adora.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public int addNewAccount(Customer customer, Account account) {
		int accountCreated = 0;
	
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{call add_new_account(?,?,?)}";
			CallableStatement cs = conn.prepareCall(sql); 
			// register IN parameters
			cs.setInt(1, customer.getCustomerId());
			cs.setString(2, account.getAccountType());
			cs.setDouble(3, account.getAccountBalance());
			
			accountCreated = cs.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return accountCreated;
	}

	@Override
	public List<Account> getUserAccounts(Customer customer) {
		List<Account> accountList = new ArrayList<Account>();
		Session session = HibernateUtil.getSession();
		accountList = session.createQuery("from Account").list();
		
		return accountList;
	}

	@Override
	public int updateAccount(Account account) {
		int accountUpdated = 1;
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(account);
		tx.commit();
		session.close();

		return accountUpdated;
	}

}
