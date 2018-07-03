package com.revature.model;

public class Snapple {
	private int id;
	private String fact;
	public Snapple() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Snapple(int id, String fact) {
		super();
		this.id = id;
		this.fact = fact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFact() {
		return fact;
	}
	public void setFact(String fact) {
		this.fact = fact;
	}
	@Override
	public String toString() {
		return "Snapple [id=" + id + ", fact=" + fact + "]";
	}
}
