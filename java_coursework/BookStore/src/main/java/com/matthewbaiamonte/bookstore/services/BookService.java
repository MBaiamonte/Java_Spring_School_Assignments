//
package com.matthewbaiamonte.bookstore.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.matthewbaiamonte.bookstore.models.Book;
import com.matthewbaiamonte.bookstore.repositories.BookRepository;

@Service
public class BookService{
	private final BookRepository bookRepository;//this line connects our service to our repository (adds it as a dependency for dependency injection)
// now make service methods to access the repository
	
// Dependency injection and a constructor method
	public BookService(BookRepository bookRepository) { 
		this.bookRepository=bookRepository;
	}//end constructor
	
//return all books method
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}//end get all method
	
//create book method
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}//end create method
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook=bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}//end find by id
	
//update book 
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}// same as create but needs to be named differently 
	
	
	
	
	
	
}//end bookService class
