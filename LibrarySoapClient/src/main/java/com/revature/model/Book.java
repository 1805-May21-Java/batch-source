package com.revature.model;

public class Book {
	
	String name;
	String author;
	int year;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String author, int year) {
		super();
		this.name = name;
		this.author = author;
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", year=" + year + "]";
	}
	
	

}
