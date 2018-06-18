package com.revature.pojos;
//It's a pojo
public class UserInfo
{
	private int id;
	private String username;
	private String email;
	private String pw;
	public UserInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(int id, String username, String email, String pw)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.pw = pw;
	}
	
	public UserInfo(String username, String email, String pw)
	{
		super();
		this.username = username;
		this.email = email;
		this.pw = pw;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPw()
	{
		return pw;
	}
	public void setPw(String pw)
	{
		this.pw = pw;
	}
	@Override
	public String toString()
	{
		return "UserInfo [id=" + id + ", username=" + username + ", email=" + email + ", pw=" + pw + "]";
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (email == null)
		{
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (pw == null)
		{
			if (other.pw != null)
				return false;
		}
		else if (!pw.equals(other.pw))
			return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
