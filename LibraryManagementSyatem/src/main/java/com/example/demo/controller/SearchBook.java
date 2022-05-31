package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;
import com.example.demo.Repository.BookRepository;
import com.example.demo.service.BookService;
import com.example.demo.serviceImpl.BookServiceImpl;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class SearchBook {

	
	@Autowired
	private BookService bookService;
	private static final Logger LOGGER=LogManager.getLogger();
	
	@GetMapping("/ShowBooks")
	public String getAllBooks(Model model)
	{
		List<Book> book=bookService.getAllBook();
		model.addAttribute("book" ,book);
		LOGGER.info("you can see the books");
		return"ShowBooks";
	}
	
	@GetMapping("/fetch")
	public String findBookById(@Param("id") int id, Model model)
	{
		
		Book book=bookService.getBookById(id);
		model.addAttribute("book", book);
		model.addAttribute("id",id);
		LOGGER.info("you can see the books");
		return"ShowBooks";
	}
	
	}


