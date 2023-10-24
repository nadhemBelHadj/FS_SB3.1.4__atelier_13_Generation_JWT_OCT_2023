package com.nadhem.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.users.entities.User;
import com.nadhem.users.repository.UserRepository;

@RestController
public class UsersController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/allUsers")
    public List <User> allUsers(   ) {
        
        return userRepository.findAll();
    }


}
