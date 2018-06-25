package com.Revature.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Revature.BankExceptions.InsufficientFunds;
import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;
import com.Revature.util.HibernateUtil;

public class BankAccountHibernate implements BankAccountDao {

	@Override
	public int getNextAccountNumber() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createBankAccount(UserProfile user, BankAccount acc) throws Exception {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int accPk = (int) s.save(acc);
		tx.commit();
		s.close();
		return accPk;
	}

	@Override
	public int addProfileToBankAccount(UserProfile user, BankAccount acc) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BankAccount getBankAccount(int id) throws Exception {
		Session s = HibernateUtil.getSession();
		BankAccount acc = (BankAccount) s.get(BankAccount.class, id);
		s.close();
		return acc;
	}

	@Override
	public int updateBankAccount(BankAccount acc) throws Exception {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(acc);
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public int deleteBankAccount(int id) throws Exception {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		BankAccount acc = (BankAccount) s.get(BankAccount.class, id);
		if (acc != null) {
			s.delete(acc); // if we had used load, c wouldn't be null (an exception would have been thrown
							// instead)
		}
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public int withdrawFromBank(BankAccount acc, float val) throws Exception {
		if (acc.getBalance() < val) {
			throw new InsufficientFunds();
		}

		acc.setBalance(acc.getBalance() - val);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(acc);
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public int depositToBank(BankAccount acc, float val) throws Exception {
		acc.setBalance(acc.getBalance() + val);

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(acc);
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public int transferMoneyBetweenAccounts(BankAccount src, BankAccount dest, float val) throws Exception {
		if (src.getBalance() < val) {
			throw new InsufficientFunds();
		}

		src.setBalance(src.getBalance() - val);
		dest.setBalance(dest.getBalance() + val);

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(src);
		s.update(dest);
		tx.commit();
		s.close();
		return 0;
	}

}
