package oop_pillars.data;

public class DirectMessage extends Message {
	
	private User fromUser;
	private User toUser;

	public DirectMessage(String text, User fromUser, User toUser) {
		super(text);
		this.fromUser = fromUser;
		this.toUser = toUser;
	}
	
	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

}
