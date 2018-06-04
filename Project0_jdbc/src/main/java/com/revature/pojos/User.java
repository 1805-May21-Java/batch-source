package com.revature.pojos;

public class User
{
	private String userId;
	private String userName;
	private String password;
	
	public User()
	{
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String userName, String password)
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}



}
