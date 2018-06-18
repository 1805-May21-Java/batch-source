package com.revature.pojos;

//a pretty ordinary java object
public class UserInfo
{
	private int id;
	private int isManager;
	private int managerId;
	private String username;
	private String pw;
	private String firsName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String state;
	private int zipCode;
	public UserInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserInfo(int id, int isManager, int managerId, String username, String pw, String firsName,
			String lastName, String email, String phone, String address, String state, int zipCode)
	{
		super();
		this.id = id;
		this.isManager = isManager;
		this.managerId = managerId;
		this.username = username;
		this.pw = pw;
		this.firsName = firsName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.state = state;
		this.zipCode = zipCode;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getIsManager()
	{
		return isManager;
	}

	public void setIsManager(int isManager)
	{
		this.isManager = isManager;
	}

	public int getManagerId()
	{
		return managerId;
	}

	public void setManagerId(int managerId)
	{
		this.managerId = managerId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPw()
	{
		return pw;
	}

	public void setPw(String pw)
	{
		this.pw = pw;
	}

	public String getFirsName()
	{
		return firsName;
	}

	public void setFirsName(String firsName)
	{
		this.firsName = firsName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}

	@Override
	public String toString()
	{
		return "UserInfo [id=" + id + ", isManager=" + isManager + ", managerId=" + managerId + ", username=" + username
				+ ", pw=" + pw + ", firsName=" + firsName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", address=" + address + ", state=" + state + ", zipCode=" + zipCode + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firsName == null) ? 0 : firsName.hashCode());
		result = prime * result + id;
		result = prime * result + isManager;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + managerId;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + zipCode;
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
		if (address == null)
		{
			if (other.address != null)
				return false;
		}
		else if (!address.equals(other.address))
			return false;
		if (email == null)
		{
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (firsName == null)
		{
			if (other.firsName != null)
				return false;
		}
		else if (!firsName.equals(other.firsName))
			return false;
		if (id != other.id)
			return false;
		if (isManager != other.isManager)
			return false;
		if (lastName == null)
		{
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))
			return false;
		if (managerId != other.managerId)
			return false;
		if (phone == null)
		{
			if (other.phone != null)
				return false;
		}
		else if (!phone.equals(other.phone))
			return false;
		if (pw == null)
		{
			if (other.pw != null)
				return false;
		}
		else if (!pw.equals(other.pw))
			return false;
		if (state == null)
		{
			if (other.state != null)
				return false;
		}
		else if (!state.equals(other.state))
			return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	
	
}
