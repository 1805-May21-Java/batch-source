package com.revature.pojo;

import java.sql.Date;

public class Employee {

	private int ID;
	private String email;
	private String pass;
	private String first;
	private String last;
	private Date bday;
	private String title;
	private int managerID;
	
	public Employee() {
		super();
	}

	public Employee(int ID, String email, String pass, String first, String last) {
		super();
		this.ID = ID;
		this.email = email;
		this.pass = pass;
		this.first = first;
		this.last = last;
		this.managerID = 0;
	}
	
	public Employee(int ID, String email, String pass, String first,
			String last, Date bday, String title, int managerID) {
		super();
		this.ID = ID;
		this.email = email;
		this.pass = pass;
		this.first = first;
		this.last = last;
		this.bday = bday;
		this.title = title;
		this.managerID = managerID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	public static boolean validatePassword(String s) {
		if(s.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,63}$")) {
			return true;
		}
		return false;
	}
}
