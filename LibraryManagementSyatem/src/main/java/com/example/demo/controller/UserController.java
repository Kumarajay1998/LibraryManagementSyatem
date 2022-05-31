package com.example.demo.controller;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.service.UserService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class UserController {
	
@Autowired

UserService userservice;
private static final Logger LOGGER=LogManager.getLogger();

  @GetMapping("/register")
  public String register(Model model , User user)
  {
  model.addAttribute("user", new User());
  return "register"; 
  }
  
  @PostMapping("/doregister") 
  public String register(@ModelAttribute("user") User user ,BindingResult bindingResult) 
  
  { 
	
	 
	 //
	  if(userservice.userExists(user.getEmail())) 
	     {
		bindingResult.addError(new FieldError("user", "email", "Email already Exists"));
		 // return "Home";
		LOGGER.warn("Email already Exists");
		}
	  if(bindingResult.hasErrors())	{return "register";}
	  user.setCreatedAt(new Date());
	  user.setUpdatedAt(new Date());
	  this.userservice.saveUser(user);
	  LOGGER.info("registered");
      return"login";}
	/*
	 * if(response==null) { return "Home";} else {
	 *  return"Register"; }
	 */
	  
}
  
  
  