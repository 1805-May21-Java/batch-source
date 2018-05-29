package com.revature.project0;

import java.util.Comparator;

public class User implements Comparator<User> {
	
	private String email;
	private String password;
	public User() {
		super();
	}
	public User(String e, String password) {
		super();
		this.email = e;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String em) {
		this.email = em;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int compareTo(User Uo) {
	    if(this.email.equals( Uo.getEmail())){
	        return 1;
	    } else {
	        return 0;

	    }
	}
	public int compare(User arg0, User arg1) {
	    if(arg0.getEmail().equals( arg1.getEmail())){
	        return 1;
	    } else {
	        return 0;

	    }
	}

}
