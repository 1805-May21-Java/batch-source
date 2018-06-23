package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.OBankInfo;
import util.HibernateUtil;

public class BankInfoDaoImpl implements BankInfoDao {

	public List<OBankInfo> bankInfo() {
		Session s = HibernateUtil.getSession();
		List<OBankInfo> obank = s.createQuery("from OBankInfo").list();
		s.close();
		return obank;
	}

	public OBankInfo getOBankInfoByUserPass(int id) {
		Session s = HibernateUtil.getSession();
		OBankInfo obi = (OBankInfo) s.get(OBankInfo.class, id);
		s.close();
		return obi;
	}

	public int createBankAccount(OBankInfo bankInfo) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = Integer.parseInt(s.save(bankInfo).toString());
		tx.commit();
		s.close();
		return pk;
	}

	public int updateBankAccount(OBankInfo bankInfo) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(bankInfo);
		tx.commit();
		s.close();
		return 1;
	}

	public int deleteBankAccount(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		OBankInfo obi = (OBankInfo) s.get(OBankInfo.class, id);
		if(obi != null) {
			s.delete(obi);
		}
		tx.commit();
		s.close();
		return 1;
	}

	public void increaseChecking(int uid, double value) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		OBankInfo obi = (OBankInfo) s.get(OBankInfo.class, uid);
		obi.setCheckingAmount(obi.getCheckingAmount() + value);
		updateBankAccount(obi);
		tx.commit();
		s.close();
	}

	public void decreaseChecking(int uid, double value) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		OBankInfo obi = (OBankInfo) s.get(OBankInfo.class, uid);
		obi.setCheckingAmount(obi.getCheckingAmount() - value);
		updateBankAccount(obi);
		tx.commit();
		s.close();
	}

	public void increaseSaving(int uid, double value) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		OBankInfo obi = (OBankInfo) s.get(OBankInfo.class, uid);
		obi.setSavingAmount(obi.getSavingAmount() + value);
		updateBankAccount(obi);
		tx.commit();
		s.close();
	}

	public void decreaseSaving(int uid, double value) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		OBankInfo obi = (OBankInfo) s.get(OBankInfo.class, uid);
		obi.setSavingAmount(obi.getSavingAmount() - value);
		updateBankAccount(obi);
		tx.commit();
		s.close();
	}

	public boolean checkEqualUser(String user) {
		Session s = HibernateUtil.getSession();
		List<OBankInfo> obilist = bankInfo();
		for(OBankInfo obi : obilist) {
			if(obi.getUsername().equals(user)) {
				s.close();
				return true;
			}
		}
		s.close();
		return false;
	}

	public boolean checkEqualEmail(String email) {
		Session s = HibernateUtil.getSession();
		List<OBankInfo> obilist = bankInfo();
		for(OBankInfo obi : obilist) {
			if(obi.getEmail().equals(email)) {
				s.close();
				return true;
			}
		}
		s.close();
		return false;
	}

}
