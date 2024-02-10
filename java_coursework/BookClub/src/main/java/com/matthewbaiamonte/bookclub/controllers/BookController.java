package com.matthewbaiamonte.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthewbaiamonte.bookclub.models.Book;
import com.matthewbaiamonte.bookclub.services.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
//add New Book routes
	@GetMapping("/add/new")
	public String ShowNewBookForm(@ModelAttribute("book")Book newBook,Model model,HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";
		}else {
			model.addAttribute("userId",session.getAttribute("userId"));
			System.out.println(session.getAttribute("userId"));
			return "NewBookForm.jsp";
		}
	}
	
	@PostMapping("/save/new")
	public String SaveNewBook(@Valid @ModelAttribute("book")Book newBook,BindingResult result,Model model,HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("userId",session.getAttribute("userId"));
			return "NewBookForm.jsp";
		}
		else {
			this.bookService.createNewBook(newBook);
			return "redirect:/user/dashboard";
		}
	}
//Show Book routes
	@GetMapping("/show/{bookId}")
	public String ShowOneBook(@PathVariable("bookId")Long id,
			Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";
		}
		else {
			model.addAttribute("userId", session.getAttribute("userId"));
			model.addAttribute("book", bookService.getOneBook(id));
			return "ShowOneBook.jsp";
		}
	}
// Delete routes
	@GetMapping("/delete/{bookId}")
	public String DeleteBook(@PathVariable("bookId")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";
		}else {
			this.bookService.deleteBook(id);
			return "redirect:/user/dashboard";
		}
	}
	
//Update routes
	@GetMapping("/show/update/{bookId}")
	public String ShowUpdateForm(@PathVariable("bookId")long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/user";
		}else {
			model.addAttribute("book", this.bookService.getOneBook(id));
			return "UpdateBookForm.jsp";
		}
	}
	
	@PutMapping("/update/{id}")
	public String UpdateBook(@Valid @ModelAttribute("book")Book updatedBook, 
			BindingResult result, 
			Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("userId", session.getAttribute("userId"));
			model.addAttribute("book", updatedBook);
			System.out.println(session.getAttribute("userId"));
			return  "UpdateBookForm.jsp";
		}
		else {
			this.bookService.updateBook(updatedBook);
			return "redirect:/book/show/{id}";
		}
	}
}//End Controller
