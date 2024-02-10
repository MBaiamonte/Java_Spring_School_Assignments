package com.matthewbaiamonte.bookstore.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthewbaiamonte.bookstore.models.Book;
import com.matthewbaiamonte.bookstore.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService; //could also just do @Autowired BookService bookService so you dont need to whole constructior
	
	 public BooksController(BookService bookService){
	     this.bookService = bookService;
	}//end constructor for dependency injection
	 
	@RequestMapping ("show/book/{id}")
	public String ShowBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		System.out.println(book);
		model.addAttribute("book",book);
		return "ShowBooks.jsp";
	}
	@GetMapping("/show/book/all")
	public String allBooks(Model model) {
		List<Book> allBooks= bookService.allBooks();
		model.addAttribute("allBooks",allBooks);
		return "ShowAllBooks.jsp";
	}
	
}//end controller
