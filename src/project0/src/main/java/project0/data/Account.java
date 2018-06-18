package project0.src.main.java.project0.data;

public class Account {
	private long accountId;
	private long balance;
	
	public Account(long accountId, long balance){
		this.accountId = accountId;
		this.balance = balance;
	}
		
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
}
