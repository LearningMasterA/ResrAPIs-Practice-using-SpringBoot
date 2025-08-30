package com.api.book.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
//	@RequestMapping(value="/books" , method=RequestMethod.GET)
	
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = this.bookService.getAllBooks();
		if(books.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
//		Book book = new Book();
//		book.setId(12);
//		book.setTitle("Java Complete Reference");
//		book.setAuthor("xyz");
		
//		Book book = bookService.getBookById(1);
		return ResponseEntity.status(HttpStatus.CREATED).body(books);
	}
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book book=bookService.getBookById(id);
		if(book==null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	} 
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book book2=null;
		try {
		book2 = this.bookService.addBook(book);
		return ResponseEntity.of(Optional.of(book2));
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") int id) {
		try {
		this.bookService.deleteById(id);
		return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/books")
	public void deleteBook() {
		this.bookService.deleteBook();
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id) {
		try {
		this.bookService.updateBook(book,id);
		return ResponseEntity.ok().body(book);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
