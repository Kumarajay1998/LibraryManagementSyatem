package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;

@Service
public interface UserService  {
	
	public User saveUser(User user);
	
	public User userLogin(User user);
	
	public boolean userExists(String email);
	
	

}
