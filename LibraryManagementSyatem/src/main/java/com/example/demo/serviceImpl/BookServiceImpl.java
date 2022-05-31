package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import com.example.demo.service.BookService;

@Service

public class BookServiceImpl implements BookService {
	@Autowired 
	 private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		book=bookRepository.save(book);
		
		return book;
	}

	
	
	
	public Book getBookById(int id)
	
	{
		Book book=null;
		   	try {
		   	book=	this.bookRepository.findById(id);
		   		
		   	}
		   	catch(Exception e) {
		   		e.printStackTrace();
		   	}
		   	return book;
	}
	
	@Override
	public List<Book>getAllBook()
	{
		List<Book> book=new ArrayList();
		bookRepository.findAll().forEach(book::add);
		return book;
	}
	
}
