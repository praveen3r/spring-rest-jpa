package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		List<User> userList = null;
		try {
			userList = userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return userList;
	}
	
	
}
