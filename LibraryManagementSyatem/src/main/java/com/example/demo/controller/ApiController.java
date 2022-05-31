package com.example.demo.controller;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api/user")

public class ApiController {
 
	private static final Logger LOGGER=LogManager.getLogger();
	@Autowired
	private UserService userService;
	
	@GetMapping
	public User userLogin(@RequestBody User user ) {
		
		 user.setCreatedAt(new Date());
		  user.setUpdatedAt(new Date());
		LOGGER.info("call here info loger"+user.toString());
		//LOGGER.warn("Set WARNING = ERRORS");
		user=userService.userLogin(user);
		
		 
	     	return user;
		
		
	}
		@PostMapping
		public User saveuser(@RequestBody User user) {
					
			  user.setCreatedAt(new Date());
			  user.setUpdatedAt(new Date());
			  this.userService.saveUser(user);
			
		return user	;
		}
		
//		External API Access
		@GetMapping("/t")
       public String addAPI() {
			
		String url="https://jsonplaceholder.typicode.com/posts" ;
			
		
			RestTemplate resTemplate=new RestTemplate();
			String response=resTemplate.getForObject(url, String.class);
			System.out.println(response);
			return response;
	}
		@PutMapping
		 void addPost () {
			User user=new User();
			String url="http://localhost:8082/api/user";
			user.setEmail("nik@gmail.com");
			user.setPasswords("ravi");
			user.setRole("student");
			user.setTelephone("145636");
			RestTemplate resTemplate=new RestTemplate();
			User response=resTemplate.postForObject(url, user, User.class);
		//System.out.println(response);
			
		}
	
}
