package com.Revature.util;

import org.hibernate.Session;

import com.Revature.Dao.BankAccountDao;
import com.Revature.Dao.BankAccountHibernate;
import com.Revature.Dao.UserProfileDao;
import com.Revature.Dao.UserProfileHibernate;
import com.Revature.pojos.BankAccount;
import com.Revature.pojos.UserProfile;

public class Driver {

	public static void main(String[] args) throws Exception {

		UserProfileDao userDao = new UserProfileHibernate();
//		System.out.println(userDao.checkUsername("THOMAS"));
//		System.out.println(userDao.createUserProfile(new UserProfile("THOMAS","PWD")));
		System.out.println(userDao.getUserProfile("THOMAS", "PWD"));
	}

}
