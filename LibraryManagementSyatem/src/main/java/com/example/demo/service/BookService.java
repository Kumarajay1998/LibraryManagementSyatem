package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;

@Service
public interface BookService {
	
	
	public Book addBook(Book book);
	
	public  Book getBookById(int id);
	
	 List<Book>getAllBook();
	
}
