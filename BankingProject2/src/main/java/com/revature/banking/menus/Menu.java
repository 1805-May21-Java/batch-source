package com.revature.banking.menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.banking.pojos.Access;
import com.revature.banking.pojos.Account;

public abstract class Menu {
	ArrayList<String> options;
	String message;
	Scanner scanner = new Scanner(System.in);
	
	public static Access access=new Access();
	public static Account account;

	public Menu() {
		super();
	}

	public Menu(ArrayList<String> options, String message) {
		super();
		this.options = options;
		this.message = message;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public abstract void switcher();
	
	public int select() {
		
		String which="";
		int num=0;
		while(num==0) {
			System.out.println(message);
			System.out.println();
			
			for(String option:options) {
				System.out.println(option);
			}
			which=scanner.nextLine();
			
			try {
				num=Integer.parseInt(which);
			}catch(Exception e) {
				invalid();
				continue;
			}
			
			if(num>options.size() || num<1) {
				invalid();
			}
		}
		
		return num;
	}
	
	protected String exitOut(String exit) {
		String which="";
		while(which.equals("1")==false && which.equals("2")==false) {
			System.out.println("Would you like to exit out to "+exit+"?");
			System.out.println();
			System.out.println("1. Yes");
			System.out.println("2. No");
			
			which=scanner.nextLine();
			
			if(which.equals("1")==false && which.equals("2")==false) {
				invalid();
			}
		}
		return which;
	}
	
	protected void invalid() {
		clear();
		System.out.println("Invalid Entry");
		System.out.println();
	}
	
	protected void clear() {
		try {
			int clear = new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
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
		Menu other = (Menu) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [options=" + options + ", message=" + message + "]";
	}
	
	

}
