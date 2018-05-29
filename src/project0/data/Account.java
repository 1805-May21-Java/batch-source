package project0.data;

public class Account {
	
	private double savings;
	private String username;
	private int accountID;
	
	public Account (String username) {
		this.username = username;
		savings = 0.;
	}
	
	public double getSavings() {
		return savings;
	}
	public void setSavings(double savings) {
		this.savings = savings;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
