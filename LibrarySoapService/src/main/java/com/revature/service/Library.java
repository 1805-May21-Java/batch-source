package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.LibraryFullException;
import com.revature.model.Book;

@WebService
public interface Library { // this is our Service Endpoint Interface (SEI)

	public List<Book> getAllBooks();
	public String addBook(Book book) throws LibraryFullException;
	
}
