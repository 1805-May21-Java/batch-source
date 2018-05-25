package com.Revature.pkg;

import java.io.Serializable;

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private float money;

	public Client() {
		super();
	}

	public Client(String username, float money) {
		super();
		this.username = username;
		this.money = money;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(money);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "Client [username=" + username + ", money=" + money + "]";
	}

}
