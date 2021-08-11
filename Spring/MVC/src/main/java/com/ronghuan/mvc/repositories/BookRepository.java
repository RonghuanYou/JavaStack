package com.ronghuan.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronghuan.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// CREATE CUSTOM QUERIES
	// RETRIEVE ALL BOOKS FROM DB
	List<Book> findAll();
	
	// FIND BOOKS WITH DESCRIPTION CONTAINING THE SEARCH STRING
	List<Book> findByDescriptionContaining(String search);
	
	

}
