package com.example.demo.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	//public Book addBook(@RequestBody Book book) 
	public Book addBook(@RequestBody Book book , Model model)
	
	{
	
		  book.setCraetedAt(new Date());
		  book.setUpdatedAt(new Date());
		  this.bookService.addBook(book);
		
	return book;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{
		
		  Book book=bookService.getBookById(id);
		  if(book==null)
		  
		  			{
			  			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			  
		  			}
		  book.setCraetedAt(new Date()); book.setUpdatedAt(new Date()); 
		return ResponseEntity.of(Optional.of(book));
		
	}
		
	}
	

