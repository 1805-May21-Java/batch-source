package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exceptions.LibraryFullException;
import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library { // this is our Service Implementing Bean (SIB)

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("Moby Dick", "Herman Melville",1848));
		bookList.add(new Book("Count of Monte Cristo","Alexandre Dumas",1884));
		bookList.add(new Book("Great Gatsby","F. Scott Fitzgerald",1925));
		return bookList;
	}

	@Override
	public String addBook(Book book) throws LibraryFullException {
		if(book.getName().equals("Twilight")) {
			throw new LibraryFullException("Library full. Cannot add "+book);
		}
		return "successfully added book by "+book.getAuthor();
	}

}
