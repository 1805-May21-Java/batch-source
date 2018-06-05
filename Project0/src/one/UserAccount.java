package one;

public class UserAccount {

	private String username;
	private String password;
	private double balance;
	
	public double deposit (double balance, double depositAmount) {
		
		balance += depositAmount;
		
		return balance;
		
	}
	
	public double withdraw (double balance, double withdrawAmount) {
		
		balance = balance - withdrawAmount;
		
		return balance;
	}

	public double myBalance (String username) {
		
		return balance;
	}
	
	public UserAccount(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "UserAccount [username=" + username + ", password=" + password + ", balance=" + balance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		UserAccount other = (UserAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
