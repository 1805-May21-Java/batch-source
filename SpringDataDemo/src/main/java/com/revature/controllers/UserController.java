package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController {

	//autowire in our UserService
	@Autowired
	UserService userService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public User findUserById(@PathVariable("id") Long id) {
		return userService.findUserById(id);
	}
	
	@PatchMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public User updateUser(@Valid @RequestBody User u) {
		return userService.updateUser(u);
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public User createUser(@Valid @RequestBody User u) {
		return userService.addUser(u);
	}
	
//	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public User loginUser(@RequestBody User u) {
//		return userService.loginUser(u);
//	}
	
	@DeleteMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public User deleteUser(@RequestBody User u) {
		return userService.deleteUser(u);
	}
	
	
	
}
