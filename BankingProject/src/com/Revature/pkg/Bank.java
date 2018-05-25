package com.Revature.pkg;

import java.io.Serializable;
import java.util.LinkedList;

public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LinkedList<Client> clientList;

	public Bank() {
		super();
		clientList = new LinkedList<Client>();
	}

	public Bank(LinkedList<Client> clientList) {
		super();
		this.clientList = clientList;
	}
	
	public Client login(String str ) {
		for ( Client c : clientList ) {
			if ( str.equals(c.getUsername())) {
				return c;
			}
		}
		return null;
	}
	
	public Client createUser(String username ) {
		if ( login(username ) != null ) {
			return null;
		}
		Client c = new Client(username , 0f);
		clientList.add(c);
		return c;
	}
	
	public boolean deposit(Client c , float money ) {
		if ( c == null ) {
			return false;
		}
		
		if ( money < 0 ) {
			return false;
		}
		
		c.setMoney(c.getMoney()+money);
		return true;
	}
	
	public boolean withdraw(Client c , float money ) {
		if ( c == null ) {
			return false;
		}
		
		if ( money < 0 ) {
			return false;
		}
		
		if ( c.getMoney() < money ) {
			return false;
		}
		
		c.setMoney(c.getMoney() - money);
		return true;
	}

	public LinkedList<Client> getClientList() {
		return clientList;
	}

	public void setClientList(LinkedList<Client> clientList) {
		this.clientList = clientList;
	}

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

	@Override
	public String toString() {
		return "Bank [clientList=" + clientList + "]";
	}

}
