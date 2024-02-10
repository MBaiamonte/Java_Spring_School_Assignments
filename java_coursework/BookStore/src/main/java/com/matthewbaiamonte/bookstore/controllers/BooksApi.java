package com.matthewbaiamonte.bookstore.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matthewbaiamonte.bookstore.models.Book;
import com.matthewbaiamonte.bookstore.services.BookService;

@RestController
public class BooksApi {
 private final BookService bookService;//creates bookservive as a dendancy injection
 public BooksApi(BookService bookService){
     this.bookService = bookService;
 }
 @RequestMapping("/api/books")
 public List<Book> index() {
     return bookService.allBooks();
 }
 
 @RequestMapping(value="/api/books", method=RequestMethod.POST)
 public Book create(@RequestParam(value="title") String constructorTitle,
		 @RequestParam(value="description") String constructorDescription,
		 @RequestParam(value="language") String constructorLanguage, 
		 @RequestParam(value="numOfPages") Integer constructorNumOfPages) {
     Book book = new Book(constructorTitle, constructorDescription, constructorLanguage, constructorNumOfPages);
     return bookService.createBook(book);
 }
 
 @RequestMapping("/api/books/{id}")
 public Book show(@PathVariable("id") Long id) {
     Book book = bookService.findBook(id);
     return book;
 }

 
 
}
