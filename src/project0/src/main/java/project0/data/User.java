package project0.data;

public class User {
	private String username;
	private String password;
	private long userId;
	private long accountId;
	
	public User (String username, String password, long userId, long accountId){
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.accountId = accountId;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
}
