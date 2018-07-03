package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Book;
import com.revature.service.Library;

public class ClientDriver {

	public static void main(String[] args) {
		
		String serviceUrl = "http://localhost:8082/LibrarySoapService/Library";
		//set up our factory to create our SIB
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceUrl);
		
		//set up some interceptors so we can see our incoming and outgoing SOAP messages
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		Library library = (Library) factory.create();
		List<Book> books = library.getAllBooks();
		for(Book b: books) {
			System.out.println(b);
		}
		
		Book newBook = new Book("The Stone of Tears", "Terry Goodkind", 1995);
		System.out.println(library.addBook(newBook));
		
		Book anotherNewBook = new Book("Twilight","Stephenie Meyer",2008);
		System.out.println(library.addBook(anotherNewBook));
	}

}
