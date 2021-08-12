package com.ronghuan.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronghuan.mvc.models.Book;
import com.ronghuan.mvc.services.MainService;

@Controller
public class BookController {

	private final MainService mainServ;
	
	public BookController(MainService mainServ) {
		this.mainServ = mainServ;
	}
	
	
	// CREATE A BOOK
	
	
	
	// DISPLAY ALL BOOKS IN DB
	@GetMapping("/")
	public String displayAllBooks(Model model) {
		// USE SERVICE TO FETCH ALL BOOKS
		List<Book> allBooks = mainServ.allBooks();
		
		// USE MODEL TO PASS BOOK LIST
		model.addAttribute("books", allBooks);
		return "all_books.jsp";
	}
	
	// DISPLAY SINGLE BOOK INFO
	@GetMapping("/books/{id}")
	public String displayBook(Model model, @PathVariable("id") Long id) {
		Book book = mainServ.findBook(id);
		if (book == null) { return "redirect:/";}
		model.addAttribute("book", book);
		return "book.jsp";
	}
	
	// DISPLAY UPDATE FORM
	@GetMapping("/books/edit/{id}")
	public String edit_book(Model model, @PathVariable("id") Long id) {
		Book book = mainServ.findBook(id);
		model.addAttribute("book", book);
		return "edit_book.jsp";
	}
	
	// PERFORM THE ACTION OF UPDATING BOOK INFO
	@RequestMapping(value="/books/update/{id}", method=RequestMethod.POST)
	public String update_book(
		Model model, 
		@PathVariable("id") Long id,
		@RequestParam(value="title") String title,
		@RequestParam(value="description") String description,
		@RequestParam(value="language") String language,
		@RequestParam(value="pages") Integer numOfPages) {
		
		Book book = mainServ.updateBook(id, title, description, language, numOfPages);
		model.addAttribute("book", book);
		return "redirect:/";	
	}
	
	// DELETE A BOOK
	@RequestMapping(value="/books/delete/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		mainServ.deleteBook(id);
		return "redirect:/";
	}
	
}
