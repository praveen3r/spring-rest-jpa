package com.demo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/demo-api/")
public class UserController {

	@Autowired
	UserService userService;
	
	//http://localhost:8080/demo-api/users
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	//http://localhost:8080/demo-api/users
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") final BigInteger id){
		return userService.getUser(id);
	}
	
	@RequestMapping(value = "user", method = {RequestMethod.POST})
	public ResultEntity<Boolean> addUser(@RequestBody final User user) throws Exception{
		return userService.addUser(user);
	}
	
}
