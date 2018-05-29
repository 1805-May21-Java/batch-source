package com.Revature.pkg;

import java.io.Serializable;
import java.util.LinkedList;

//Serialize for persistence
public class Bank implements Serializable {

	// Default
	private static final long serialVersionUID = 1L;

	// Bank keeps a current list of all accounts/clients
	private LinkedList<Client> clientList;

	public Bank() {
		super();
		// Initialize clientList
		clientList = new LinkedList<Client>();
	}

	public Bank(LinkedList<Client> clientList) {
		super();
		this.clientList = clientList;
	}

	// On login, either a clients account or null is returned
	public Client login(String username, String password) {
		for (Client c : clientList) {
			if (username.equals(c.getUsername()) && password.equals(c.getPassword())) { // Validate credentials
				return c;
			}
		}
		return null;
	}

	// Creating a user is similar to login, either a new Client is returned or null
	public Client createUser(String username, String password) { // Used to create user
		for (Client c : clientList) {
			if (c.getUsername().equals(username)) { // If username is taken
				return null;
			}
		}
		Client c = new Client(username, password, 0f);
		clientList.add(c);
		return c;
	}

	public boolean deposit(Client c, float money) { // Attempt to deposit funds into an account
		if (c == null) { // Checks login
			return false;
		}

		if (money < 0) { // Cannot deposit negative funds
			return false;
		}

		c.setMoney(c.getMoney() + money); // Adds money to accounts
		return true;
	}

	// Similar to deposit
	public boolean withdraw(Client c, float money) {
		if (c == null) {
			return false;
		}

		if (money < 0) {
			return false;
		}

		// This bank does not do overdrafts
		if (c.getMoney() < money) { // Verify client has funds to withdraw
			return false;
		}

		c.setMoney(c.getMoney() - money);
		return true;
	}

	public boolean deleteAccount(Client client) { // Removes a client from list
		return clientList.remove(client); // Returns true false for list containing client
	}
	
	// These methods are removed
	// No one should have access to list of clients besides the bank
	// Without these methods, clients are forced to use the bank as an interface
	// in between them and their account

	/*
	 * public LinkedList<Client> getClientList() { return clientList; }
	 * 
	 * public void setClientList(LinkedList<Client> clientList) { this.clientList =
	 * clientList; }
	 */

	// POJO stuff
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientList == null) ? 0 : clientList.hashCode());
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
		Bank other = (Bank) obj;
		if (clientList == null) {
			if (other.clientList != null)
				return false;
		} else if (!clientList.equals(other.clientList))
			return false;
		return true;
	}

	// Bank can be printed
	// Output specific string instead of
	// default which returns member list
	@Override
	public String toString() {
		return "Bank of Thomas Jansen " + clientList.size() + " users world wide";
	}

}
