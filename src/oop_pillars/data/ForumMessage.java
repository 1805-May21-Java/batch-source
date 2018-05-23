package oop_pillars.data;

public class ForumMessage extends Message {
	
	private User fromUser;
	private int channelID;

	public ForumMessage(String text, User fromUser, int channelID) {
		super(text);
		this.fromUser = fromUser;
		this.channelID = channelID;
	}
	
	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}
	
	

}
