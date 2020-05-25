package com.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.controller.ResultEntity;
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
	
	public User getUser(final BigInteger id){
		User user = null;
		try {
			user = (userRepository.findById(id)).get();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return user;
	}
	
	public ResultEntity<Boolean> addUser(final User user){
		ResultEntity<Boolean> response = new ResultEntity<Boolean>();
		try {
			userRepository.save(user);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setStatusMsg(e.getMessage());
		} 
		return response;
	}
	
	
}
