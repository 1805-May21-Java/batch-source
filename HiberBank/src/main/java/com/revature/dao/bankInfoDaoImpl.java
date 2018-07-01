package com.revature.dao;


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
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class bankInfoDaoImpl implements bankInfoDAO
{

	public bankInfoDaoImpl() {};

	public List<User> getUsers()
	{
		
//		List<User> users = new ArrayList<User>();
//		try
//		{
			Session sess = HibernateUtil.getSession();
			List<User> users = sess.createQuery("from USER").list();
			sess.close();
//			Statement s = sess.;
//			ResultSet rs = s.executeQuery(sql);
//			
//			while(rs.next())
//			{
//				String userId = rs.getString("USER_ID");
//				String userName = rs.getString("USER_NAME");
//				String userPassword = rs.getString("USER_PASSWORD");
//				Double userBalance = rs.getDouble("BALANCE");
//				users.add(new User(userId, userName, userPassword, userBalance));
//			}
//			con.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return users;

	}

	public User getUserById(int id)
	{
		Session s = HibernateUtil.getSession();
		User person = (User) s.get(User.class, id);
		s.close();
		return person;
//		User user = null;
		
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, id);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				String userId = rs.getString("USER_ID");
//				String userName = rs.getString("USER_NAME");
//				String userPassword = rs.getString("USER_PASSWORD");
//				Double userBalance = rs.getDouble("BALANCE");
//				
//				user = new User(userId, userName, userPassword, userBalance);
//			}
//			
//			con.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}


	public void createUser(User newUser)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(newUser);
		tx.commit();
		s.close();
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "INSERT INTO USERS (USER_ID, USER_NAME, USER_PASSWORD, BALANCE) VALUES (?,?,?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, newUser.getUserId());
//			ps.setString(2, newUser.getUserName());
//			ps.setString(3, newUser.getPassword());
//			ps.setDouble(4, newUser.getBalance());
//			ps.executeUpdate();
//			
//			con.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public void updateUser(User newUser)
	{
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(newUser);
		tx.commit();
		s.close();
//		String sql = "UPDATE USERS "+ "SET USER_ID = ?, "+ "USER_NAME = ?, "+ "USER_PASSWORD = ?, "+ "BALANCE = ? "+ "WHERE USER_ID = ?";
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			con.setAutoCommit(false);
//			PreparedStatement pstatement = con.prepareStatement(sql);
//			pstatement.setString(1, newUser.getUserId());
//			pstatement.setString(2, newUser.getUserName());
//			pstatement.setString(3, newUser.getPassword());
//			pstatement.setDouble(4, newUser.getBalance());
//			pstatement.setString(5, newUser.getUserId());
//			pstatement.executeUpdate();
//			con.commit();
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

	public User getUserByName(String name) {
		Session s = HibernateUtil.getSession();
		String hql = "from User where USER_NAME = :nameVar";
		Query q = s.createQuery(hql);
		q.setString("nameVar", name);
		List<User> u = q.list();
		User us = null;
		if(!u.isEmpty()) {
			us = u.get(0);
		}
		return us;
	}
//		User user = null;
//		
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, name);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				String userId = rs.getString("USER_ID");
//				String userName = rs.getString("USER_NAME");
//				String userPassword = rs.getString("USER_PASSWORD");
//				Double userBalance = rs.getDouble("BALANCE");
//				
//				user = new User(userId, userName, userPassword, userBalance);
//			}
//			
//			con.close();
//
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		return user;
//	}

	public Boolean doesExist(String newName) {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("FROM User WHERE userName = :nameVar");
		q.setString("nameVar", newName);
		List<User> users = q.list();
		if(users.size()!=0) {
			s.close();
			return true;
		}else {
			s.close();
			return false;
		}
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, newName);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				return true;
//			}else
//			{
//				return false;
//			}
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return false;
	}

	public Boolean doAuthenticate(String newName, String newPassword) {
		
		Session s = HibernateUtil.getSession();
		String hql = "SELECT * FROM USER WHERE USER_NAME = :nameVar AND USER_PASS = :passVar";
		Query q = s.createQuery(hql);
		q.setString(0, "nameVar");
		q.setString(1, "passVar");
		List<User> users = q.list();
		if(users.size()!=0) {
			return true;
		}else {
			return false;
		}
//		try {
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT * FROM USERS WHERE USER_NAME = ? AND USER_PASSWORD = ? ";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, newName);
//			ps.setString(2, newPassword);
//			ResultSet rs = ps.executeQuery();
//		
//			if(rs.next()) {
//				return true;
//			}else
//			{
//				return false;
//			}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return false;
	}

	public int size() {
		
		int count=0;
		Session s = HibernateUtil.getSession();
		String hql = "SELECT max(USER_ID)_FROM USER";
		Query q = s.createQuery(hql);
		List<User> user = q.list();
		while(count<user.size()) {
			count++;
		}
		return count;
	}
}
//		try
//		{
//			Connection con = ConnectionUtil.getConnection();
//			String sql = "SELECT max(USER_ID) FROM USERS";
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
//			
//			while(rs.next())
//			{
//				count = rs.getInt(1);
//			}
//			con.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return count;

	//See if I can run without this method???
//	public int callable() {
//		int size = 0;
//		Session s = HibernateUtil.getSession();
//		String hql = "{call ROW_SIZE(?)}";
//		CallableStatement cs = s.
//	}
//	{
//		int size = 0;
//		Session s = HibernateUtil.getSession();
//		String hql = ""
//		try {
//		int size=0;
//		Connection con = ConnectionUtil.getConnection();
//		String sql = "{call ROW_SIZE(?)}";
//		CallableStatement cs = con.prepareCall(sql);
//		cs.setInt(1, size);
//	
//		cs.execute();
//		con.close();
//		return size;
//	} catch (IOException e) {
//		e.printStackTrace();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return 0;