package oop_pillars.exceptions;

public class InvalidAdminPermission extends Exception {
	public InvalidAdminPermission() {
		super();
	}
	
	public InvalidAdminPermission(String message) {
		super(message);
	}
}
