package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

User findUserByEmailAndPasswords(String email, String passwords);
	
	//User findUserByEmail(String email);
    Optional<User> findUserByEmail(String email);


}
