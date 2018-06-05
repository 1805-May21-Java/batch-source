package com.revature.revaturebankingapp;

public interface UserDAO {

	public int createUser(User user);
	public int updateUser(User user);
	public int deleteUser(int id);
	public String logInCheck(String email, String password);
	public User getUserByEmail(String email);
}
