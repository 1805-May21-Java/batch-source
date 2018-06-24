package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.revature.pojos.BankAccount;
import com.revature.pojos.Client;
import com.revature.pojos.Transaction;
import com.revature.util.HibernateUtil;

public class DaoHibernate implements daoInterface{

	
	@Override
	public void getAccountsFromClient(Client client) {
		Session session = HibernateUtil.getSession();
		String hql = String.format("FROM %s JOIN %s.%s WHERE %s.%s = :clientEmail", 
				BankContract.ANNOTATIONS_BANK_TABLE_NAME, 
				BankContract.ANNOTATIONS_BANK_TABLE_NAME,
				BankContract.ANNOTATIONS_CLIENT_EMAIL,
				BankContract.ANNOTATIONS_BANK_TABLE_NAME,
				BankContract.ANNOTATIONS_CLIENT_EMAIL);
		System.out.println(hql);
		Query query = session.createQuery(hql);
		query.setParameter("clientEmail", client.getEmail());
		List<BankAccount> bankAccounts= query.list();
		for(BankAccount account : bankAccounts) {
			client.addNewAccount(account);
		}
		session.close();
	}

	@Override
	public Client login(String username, String password) {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Client.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		try {
			//if it doesn't through an exception, the client exists and is returned
			return (Client) criteria.list().get(0);
		} catch (IndexOutOfBoundsException e) {
			//If it threw an exception, no client exists that matches the credentials
			return null;
		}finally {
			//either way, close session
			session.close();
		}
	}

	@Override
	public double getBalance(int bankId) {
		Session session = HibernateUtil.getSession();
		BankAccount account = (BankAccount) session.load(BankAccount.class, bankId);
		session.close();
		return account.getBalence();
	}

	@Override
	public boolean saveOldClient(Client client) {
		Session session = HibernateUtil.getSession();
		session.save(client);
		session.close();
		return true;
	}

	@Override
	public boolean saveNewClient(Client client) {
		Session session = HibernateUtil.getSession();
		session.save(client);
		session.close();
		return true;
	}

	@Override
	public boolean saveNewAccount(BankAccount bankAccount, Client client) {
		Session session = HibernateUtil.getSession();
		session.save(client);
		session.save(bankAccount);
		session.close();
		return true;
	}

	@Override
	public boolean saveOldAccount(BankAccount bankAccount, Client client) {
		Session session = HibernateUtil.getSession();
		session.save(bankAccount);
		session.close();
		return true;
	}

	@Override
	public boolean saveAccountClientLink(BankAccount bankAccount, Client client) {
		Session session = HibernateUtil.getSession();
		session.save(client);
		session.save(bankAccount);
		session.close();
		return false;
	}

	@Override
	public boolean userNameExists(String newUserName) {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Client.class);
		criteria.add(Restrictions.eq("username", newUserName));
		if(criteria.list().size() > 0) {
			//username already exists
			session.close();
			return true;
		}else {
			//no username found
			session.close();
			return false;
		}
	}

	@Override
	public boolean recordTransation(Transaction transaction) {
		Session session = HibernateUtil.getSession();
		session.save(transaction);
		session.close();
		return false;
	}

	@Override
	public ArrayList<Transaction> getTransactions(BankAccount bankAccount) {
		Session session = HibernateUtil.getSession();
		String hql = String.format("FROM %s JOIN %s.%s WHERE %s.%s = :bankId", 
				BankContract.ANNOTATIONS_TRANSACTION_TABLE_NAME,
				BankContract.ANNOTATIONS_TRANSACTION_TABLE_NAME,
				BankContract.ANNOTATIONS_BANK_ID,
				BankContract.ANNOTATIONS_TRANSACTION_TABLE_NAME,
				BankContract.ANNOTATIONS_BANK_ID);
		System.out.println(hql);
		Query query = session.createQuery(hql);
		query.setParameter("bankId", bankAccount.getBankId());
		ArrayList<Transaction> transactions= (ArrayList<Transaction>) query.list();
		session.close();
		return transactions;
	}
}
