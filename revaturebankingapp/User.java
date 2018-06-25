package com.revature.revaturebankingapp;

import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="RBA_USER")
public class User {

	//Variables
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(allocationSize=46, name="userSequence", sequenceName="SQ_USER_PK")
	@Column(name="USERID")
	int accountid;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="PASSWORD")
	String password;
	
	@Column(name="FIRSTNAME")
	String firstname;
	
	@Column(name="LASTNAME")
	String lastname;
	
	@Transient
	Scanner sc = new Scanner(System.in);
	
	//Method to create new user in User table returns that user
	public User newUser() {
		System.out.println("Please enter your email to serve as your username:");
		email = sc.nextLine();
		
		System.out.println("Please enter the password for your account:");
		password = sc.nextLine();
		
		System.out.println("Please enter your first name:");
		String firstname = sc.nextLine();
		
		System.out.println("Please enter your last name:");
		String lastname = sc.nextLine();
		
		UserDAOImpl user = new UserDAOImpl();
		//Placeholder value of 10 for UserID since there is a trigger setup for new users in Oracle SQl Developer
		User u = new User(10, email, password, firstname, lastname);
		user.createUser(u);
		System.out.println("Thank you for banking with Revature, " + u.getFirstname() + " " + u.getLastname() + "! Your account is set up and ready to use.");
		return user.getUserByEmail(email);
	}
	
	//Method to login an existing user, returns that user
	public User login() {
		boolean loggedin = false;
		UserDAOImpl user = new UserDAOImpl();
		while (loggedin == false) {
			
			System.out.println("Please enter your email to serve as your username:");
			email = sc.nextLine();
			System.out.println("Please enter the password for your account:");
			password = sc.nextLine();
			
			if (user.logInCheck(email, password).equals(password)) {
				loggedin = true;
				System.out.println("Login successful!");
			} else {System.out.println("Invalid credentials. Please try again.");
			System.out.println();}
		}
		System.out.println();
		System.out.println("Welcome back!");
		return user.getUserByEmail(email);
	}
	
	//No args constructor
	public User() {
		super();
	}
	
	//Constructor with fields
	public User(int accountid, String email, String password, String firstname, String lastname) {
		super();
		this.accountid = accountid;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public User(String email, String password, String firstname, String lastname) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	//Gettters and Setters
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	//Overriden toString() method
	@Override
	public String toString() {
		return "User [accountid=" + accountid + ", email=" + email + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + "]";
	}
	//Overidden hashCode() method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountid;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	//Overriden equals() method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accountid != other.accountid)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
}
