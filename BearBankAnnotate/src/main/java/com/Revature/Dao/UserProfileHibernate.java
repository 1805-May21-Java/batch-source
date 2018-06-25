package com.Revature.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;
import com.Revature.util.HibernateUtil;

public class UserProfileHibernate implements UserProfileDao {

	@Override
	public int createUserProfile(UserProfile up) throws Exception {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(up);
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public boolean checkUsername(String username) throws Exception {
		Session s = HibernateUtil.getSession();
		boolean rval = s.get(UserProfile.class, username) != null;
		s.close();
		return rval;
	}

	@Override
	public UserProfile getUserProfile(String username, String password) throws Exception {
		Session s = HibernateUtil.getSession();
		String hql = "from UserProfile where USERNAME = :nameVar AND PWD= :pwdVar";
		Query q = s.createQuery(hql);
		q.setString("nameVar", username);
		q.setString("pwdVar", password);
		List<UserProfile> users = q.list();
		UserProfile user = null;
		if (!users.isEmpty()) {
			user = users.get(0);
		}
		s.close();
		return user;
	}

	@Override
	public int updateUserProfile(UserProfile up) throws Exception {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(up);
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public int deleteUserProfile(String username) throws Exception {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		UserProfile usr = (UserProfile) s.get(UserProfile.class, username);
		if (usr != null) {
			s.delete(usr); // if we had used load, c wouldn't be null (an exception would have been thrown
							// instead)
		}
		tx.commit();
		s.close();
		return 0;
	}

}
