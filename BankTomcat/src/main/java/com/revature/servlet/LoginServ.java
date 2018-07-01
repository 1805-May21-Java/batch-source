package com.revature.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankpojos.User;
import com.revature.dao.*;
import com.revature.util.ConnectionUtil;

public class LoginServ extends HttpServlet implements bankInfoDAO{

	private static final long serialVersionUID = 1L;
    public LoginServ() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		List<User> person = getUsers();
		
		if(user.equals(person)&& pass.equals(person)) {
//			System.out.println("login was successful - correct credentials");
			session.setAttribute("username", "admin");
			response.sendRedirect("profile");
		}else {
//			System.out.println("WRONG");
			response.sendRedirect("login");
		}
	}
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try
		{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USERS";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				String userPassword = rs.getString("USER_PASSWORD");
				Double userBalance = rs.getDouble("BALANCE");
				users.add(new User(userId, userName, userPassword, userBalance));
			}
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public Boolean doesExist(String newName) {
		// TODO Auto-generated method stub
		return null;
	}
	public Boolean doAuthenticate(String newName, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
