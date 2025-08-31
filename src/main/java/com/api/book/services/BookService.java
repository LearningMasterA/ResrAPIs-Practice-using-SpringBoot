package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {
//	private static List<Book> list=new ArrayList<>();
//	static {
//		list.add(new Book(1,"Python Programming","ABC"));
//		list.add(new Book(2,"Java Programming","DEF"));
//		list.add(new Book(3,"Spring Boot Programming","GHI"));
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBooks(){
		List<Book> list =(List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	public Book getBookById(int id) {
		Book book=null;
		try {
		book=this.bookRepository.findById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}
	
	
	public Book addBook(Book b) {
		b.setId(0);
		return this.bookRepository.save(b);
		
	}
	
	
	public void deleteBook() {
		this.bookRepository.deleteAll();
		
	}
	
	
	public void deleteById(int id) {
		this.bookRepository.deleteById(id);
		
	}

	public void updateBook(Book book, int id) {
		// TODO Auto-generated method stub
//		list=list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		
		book.setId(id);
		this.bookRepository.save(book);
	}
	
	
	

}
