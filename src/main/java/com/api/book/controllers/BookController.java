package com.api.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
//	@RequestMapping(value="/books" , method=RequestMethod.GET)
	
	
	@GetMapping("/books")
	public List<Book> getBooks() {
//		Book book = new Book();
//		book.setId(12);
//		book.setTitle("Java Complete Reference");
//		book.setAuthor("xyz");
		
//		Book book = bookService.getBookById(1);
		return this.bookService.getAllBooks();
	}
	
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	
	
	

}
