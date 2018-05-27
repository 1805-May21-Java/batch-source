package com.Revature.pkg;

import java.io.Serializable;

//Make client serializable for persistence
public class Client implements Serializable {

	//serial if as default
	private static final long serialVersionUID = 1L;

	//Define a username and password as well as amount of money
	private String username;
	private String password;
	private float money;
	
	//Could have included account number

	//Generic  constructor
	public Client() {
		super();
		//Initialize members to null
		username = password = null;
		money = 0f;
	}

	//Fields constructor
	public Client(String username, String password, float money) {
		super();
		this.username = username;
		this.password = password;
		this.money = money;
	}

	//Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//POJO methods
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(money);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password == null ) ? 0 : password.hashCode());
		return result;
	}
	
	//Username would be sufficient for .equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (Float.floatToIntBits(money) != Float.floatToIntBits(other.money))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	//Don't output a clients password in toString for security
	@Override
	public String toString() {
		return "Client [username=" + username + ", money=" + money + "]";
	}

}
