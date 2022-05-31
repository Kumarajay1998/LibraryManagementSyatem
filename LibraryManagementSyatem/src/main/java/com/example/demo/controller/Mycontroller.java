package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class Mycontroller {

	/*
	 * @RequestMapping(value="/") public String about()
	 * 
	 * { //System.out.println("hhhhh"); return "about"; //
	 * userService.saveUser(user);
	 * 
	 * }
	 */
	/*
	 * @RequestMapping(value="/Addbooks") public String Search()
	 * 
	 * {
	 * 
	 * return "Addbooks";
	 * 
	 * }
	 */
	@RequestMapping(value="/login")
	public String login() 
	
	{		
	
		return "login";	
		
	}
	@RequestMapping(value="/Home")
	public String home() 
	
	{		
	
		return "Home";	
		
	}
	/*
	 * @RequestMapping(value="/Search") public String Searc()
	 * 
	 * {
	 * 
	 * return "Searchbook";
	 * 
	 * }
	 */
	
}


