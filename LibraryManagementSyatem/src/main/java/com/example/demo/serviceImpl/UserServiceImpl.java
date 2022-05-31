package com.example.demo.serviceImpl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.service.UserService;

import lombok.extern.log4j.Log4j2;



@Log4j2
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER=LogManager.getLogger();
	@Autowired
	private UsersRepository userRepository;
	@Override
	public User saveUser(User user) {
		
		/*
		 * user=userRepository.findUserByEmail(user.getEmail()); // User u=new User();
		 * 
		 * if (user!=null) { userRepository.save(user); return user; }
		 * 
		 * else { //user.setMessage("Email exists "); return null; } // }
		 */		 
 			
		userRepository.save(user);
		return null;
	}

	@Override
	public User userLogin(User user) 
	{


		User u=new User();
	try {	
		user=userRepository.findUserByEmailAndPasswords(user.getEmail(),user.getPasswords());

		//try {
			if (user!=null)
			{
				user.setMessage("login success");
				user.setStatuscode("1");
				u=user;
				LOGGER.info("success login");
				return u;
			}		
			else {

				u.setMessage(" invalid");
				u.setStatuscode("0");
			//	return u;
				LOGGER.info("unsuccessful login");
				return null;
			}}
			
			  catch(Exception er) { user.setStatuscode("lm-0001");
			  LOGGER.info("call here info loger");
			  LOGGER.warn("something wrong");
			 user.setMessage(er.getMessage()); System.out.println(er); }
		return user;
			 
	}
	//	@Override
	//	public User userLogin(User user) {
	// TODO Auto-generated method stub
			//return user;

	//}

	public boolean userExists(String email) {
		return findUserByEmail(email).isPresent();
	}
	@Transactional
	public Optional<User> findUserByEmail(String email){
		return userRepository.findUserByEmail(email);
	}
}
