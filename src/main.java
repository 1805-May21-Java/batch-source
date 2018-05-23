import java.util.ArrayList;

import oop_pillars.data.Admin;
import oop_pillars.data.DirectMessage;
import oop_pillars.data.ForumMessage;
import oop_pillars.data.Member;
import oop_pillars.data.Moderator;
import oop_pillars.data.User;
import oop_pillars.exceptions.InvalidAdminPermission;

public class main {

	public static void main(String[] args) {
		User admin1 = new Admin("Bob");
		User member1 = new Member("Bill");
		User moderator1 = new Moderator("Jill");
		ArrayList<User> userList = new ArrayList();
		userList.add(admin1);
		userList.add(moderator1);
		userList.add(member1);
		
		//Polymorphic: Can call the same methods on different users regardless of class.
		//Use Inheritance to encapsulate required getters and setters
		//Abstraction through the use of Interfaces
		for(User u:userList) {
			System.out.println("User is: " + u.getClass().getSimpleName());
			System.out.println("User name is: " + u.getName());
			System.out.println("User is Admin: " + u.getAdminPrivileges());
			System.out.println("User is Moderator:" + u.getModPrivileges() + "\n");
		}
		
		DirectMessage directMessage = new DirectMessage("This is a direct message", admin1, moderator1);
		ForumMessage forumMessage = new ForumMessage("This is a forum message", member1, 1);
		
		//Direct and Forum Messages extend Message which allows them to use the getText method while having their own unique member variables
		System.out.println("Direct Message is: " + directMessage.getText() + " from: " + directMessage.getFromUser().getName() + " to: " + directMessage.getToUser().getName());
		System.out.println("Forum Message is: " + forumMessage.getText() + " from: " + forumMessage.getFromUser().getName() + " to Channel ID: " + forumMessage.getChannelID() + "\n");
		
		try {
			if(!member1.getAdminPrivileges()) {
				throw new InvalidAdminPermission("User does not have Admin Privileges");
			}
		} catch (InvalidAdminPermission e) {
			System.out.println(e.getMessage());
		}
	}

}
