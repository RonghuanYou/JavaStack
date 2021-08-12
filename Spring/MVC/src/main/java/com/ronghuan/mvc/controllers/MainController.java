package com.ronghuan.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ronghuan.mvc.models.Book;
import com.ronghuan.mvc.services.MainService;



@Controller
public class MainController {
	private final MainService mainServ;
	
	public MainController(MainService mainServ) {
		this.mainServ = mainServ;
	}
	
	@GetMapping("/api/books")
	public List<Book> allBooks(){
		return mainServ.allBooks();
	}
	
	// CREATE A BOOK
	@PostMapping("/api/books")
	public Book create(
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") int numOfPages) {
		// THAT'S WHY WE HAVE FULL CONSTRUCTOR IN BOOK MODEL(CREATE BOOK OBJECT)
		Book book = new Book(title, description, language, numOfPages);
		return mainServ.createBook(book);
	}
	
	// DISPLAY SINGLE BOOK
	@RequestMapping("/api/books/{id}")
	public String display(
			Model model,
			@PathVariable("id") Long id) {
		
		Book book = mainServ.findBook(id);
//		if (book == null) {
//			return "redirect:/api/books";
//		}
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	
	// DISPLAY EDIT FORM
	@GetMapping("/api/edit/{id}")
	public String editBook(){
		return "edit_book.jsp";
	}
	


	// UPDAET SINGLE BOOK
	@RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	public Book update(
		@PathVariable("id") Long id,
		@RequestParam(value="title") String title,
		@RequestParam(value="description") String description,
		@RequestParam(value="language") String language,
		@RequestParam(value="pages") Integer numOfPages) {
		
		Book book = mainServ.updateBook(id, title, description, language, numOfPages);
		return book;
	}

//	// DELETE A BOOK
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long id) {
//    	mainServ.deleteBook(id);
//    }
	
}
