package com.springBoot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.entities.Book;

@Service
public class BookService {
	private static List<Book> list= new ArrayList<>(); 
	
	static {
		list.add(new Book(2,"Python Book","4522$","Nikhil"));
		list.add(new Book(3,"Rust Book","4122$","Simran"));
		list.add(new Book(4,"C++ Book","4852$","Aditya"));
		list.add(new Book(5,"C Book","50000$","Shubham"));
		list.add(new Book(6,"Js Book","7895$","Vishal"));
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookById(int id) {
		Book book = null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	
	public Book AddBook(Book b ) {
		list.add(b);
		return b;
	}
}
