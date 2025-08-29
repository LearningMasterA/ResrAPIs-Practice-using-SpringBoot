package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;

@Component
public class BookService {
	private static List<Book> list=new ArrayList<>();
	static {
		list.add(new Book(1,"Python Programming","ABC"));
		list.add(new Book(2,"Java Programming","DEF"));
		list.add(new Book(3,"Spring Boot Programming","GHI"));
	}
	
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookById(int id) {
		Book book = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
		
	}
	
	
	public void deleteBook() {
		list.clear();
		
	}
	
	
	public void deleteById(int id) {
		list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		
	}

	public void updateBook(Book book, int id) {
		// TODO Auto-generated method stub
		list=list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
