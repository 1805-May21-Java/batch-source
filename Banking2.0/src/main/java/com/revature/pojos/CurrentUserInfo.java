package com.revature.pojos;

public class CurrentUserInfo
{
	private User user;

	public CurrentUserInfo() 
	{
		super();
	}

	public CurrentUserInfo(User user) 
	{
		super();
		this.user = user;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		CurrentUserInfo other = (CurrentUserInfo) obj;
		if (user == null) 
		{
			if (other.user != null)
				return false;
		}
		else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "currentUserInfo [user=" + user + "]";
	}
}
