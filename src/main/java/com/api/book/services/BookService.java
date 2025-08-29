package com.api.book.services;

import java.util.ArrayList;
import java.util.List;

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

}
