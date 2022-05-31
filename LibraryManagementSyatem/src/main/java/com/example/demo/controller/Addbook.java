package com.example.demo.controller;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Book;
import com.example.demo.service.BookService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class Addbook {

	
	@Autowired
	
	BookService bookservice;
	private static final Logger LOGGER=LogManager.getLogger();

	  @GetMapping("/Addbooks")
	  public String register()
	  {
	  
	  return "Addbooks"; 
	  }
	  
	  @PostMapping("/Addbooks") 
	  public String register(@ModelAttribute("book") Book book) 
	  
	  { 
		 
		  book.setCraetedAt(new Date());
		  book.setUpdatedAt(new Date());
		  this.bookservice.addBook(book);
		  LOGGER.info("book added");
		  return "Addbooks";
		  
	}
}
