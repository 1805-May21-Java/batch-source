package com.revature.pojos;

public class OBankInfo {
	private int userId;
	private String username;
	private String password;
	private String email;
	private double checkingAmount;
	private double savingAmount;
	
	public OBankInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OBankInfo(int userId, String username, String password, String email, double checkingAmount, double savingAmount) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.checkingAmount = checkingAmount;
		this.savingAmount = savingAmount;
	}

	public OBankInfo(String username, String password, String email, double checkingAmount, double savingAmount) {
		super();
		//this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.checkingAmount = checkingAmount;
		this.savingAmount = savingAmount;
	}

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public double getCheckingAmount() {
		return checkingAmount;
	}

	public void setCheckingAmount(double checkingAmount) {
		this.checkingAmount = checkingAmount;
	}

	public double getSavingAmount() {
		return savingAmount;
	}

	public void setSavingAmount(double savingAmount) {
		this.savingAmount = savingAmount;
	}

	@Override
	public String toString() {
		return "BankInfo [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", checkingAmount=" + checkingAmount + ", savingAmount=" + savingAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(checkingAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		temp = Double.doubleToLongBits(savingAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userId;
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
		OBankInfo other = (OBankInfo) obj;
		if (Double.doubleToLongBits(checkingAmount) != Double.doubleToLongBits(other.checkingAmount))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Double.doubleToLongBits(savingAmount) != Double.doubleToLongBits(other.savingAmount))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	
	
}
