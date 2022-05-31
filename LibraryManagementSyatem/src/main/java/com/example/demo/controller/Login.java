package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.service.UserService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class Login {
	@Autowired
	UserService userservice;
	private static final Logger LOGGER=LogManager.getLogger();

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}

	@GetMapping("/dologin")
	public String loginuser(@ModelAttribute("user") User user) {

		User response = this.userservice.userLogin(user);

		if (response == null) {
			 LOGGER.warn("sonthing wrong");
			return "register";
			
		}
		
		  else { 
			  if(response.getRole().equals("admin"))
			  { 
				  LOGGER.info("admin");
				  return "Addbooks"; 
				  } 
			  else 
		           if(response.getRole().equals("student"))
		           {
		        	   LOGGER.info("student");
			          return "redirect:/ShowBooks"; 
		           }
		 
		           else {
			             return "login";
		}
	}

	}}

