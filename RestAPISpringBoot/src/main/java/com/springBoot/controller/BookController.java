package com.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entities.Book;
import com.springBoot.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;
	
	
	
	@GetMapping("/books")
	public List<Book> getListOfBooks() {
		System.out.println("This is book Controller");	
		return service.getAllBooks();
	}
	

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id")int id) {
		System.out.println("This is book by ID Controller");	
		return service.getBookById(id);
	}
	
	
	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book b) {
		Book b1=service.AddBook(b);
		return b1;
			
	}
	
	
}
