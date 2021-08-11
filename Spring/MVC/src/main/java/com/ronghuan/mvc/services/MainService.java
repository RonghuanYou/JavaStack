package com.ronghuan.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronghuan.mvc.models.Book;
import com.ronghuan.mvc.repositories.BookRepository;

@Service
public class MainService {
	// SET UP SERVICE(ATTRIBUTES)
	private final BookRepository bookRepository;
	
	
	// CONSTRUCTOR
	public MainService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	// METHODS:
	// RETURN ALL BOOKS
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	// CREATE A BOOK
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	// RETRIEVES SINGLE BOOK
	public Book findBook(Long id) {
//		Optional<Book> optionalBook = bookRepository.findById(id);
//		// search specific book from db, if it exists in db, return it, or else, return null
//		if (optionalBook.isPresent()) {
//			return optionalBook.get();
//		} else {
//			return null;
//		}
		return bookRepository.findById(id).orElse(null);
	}
	
	
	// UPDATE SINGLE BOOK
	public Book updateBook(Long id, String title, String description, String language, int numOfpages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		// search specific book from db, if it exists in db, update it
		if (optionalBook.isPresent()) {
			Book singleBook = optionalBook.get();
			singleBook.setTitle(title);
			singleBook.setDescription(description);
			singleBook.setLanguage(language);
			singleBook.setNumberOfPages(numOfpages);

			return bookRepository.save(singleBook);
		} else {
			return null;
		}
	}
	
	
	// DELETE A BOOK
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	

}
