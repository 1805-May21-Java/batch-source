package com.revature.dao;

import java.util.List;

import org.hibernate.*;

import com.revature.pojos.Account;
import com.revature.pojos.User;
import com.revature.utils.HibernateUtil;

public class JointAccountDaoImpl implements JointAccountDao{

	public int joinAccountToNewUser(long accountNumber, int newUser) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Account account = (Account) s.get(Account.class, accountNumber);
		List<User> users = account.getUsers();
		User user = (User) s.get(User.class, newUser);
		if(user != null) {
			users.add(user);
		}
		account.setUsers(users);
		s.update(account);
		tx.commit();
		s.close();
		
		return 1;
	}

}
