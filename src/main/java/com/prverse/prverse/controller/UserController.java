package com.prverse.prverse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.prverse.prverse.Service.UserService;
import com.prverse.prverse.entity.User;
import com.prverse.prverse.enums.PackageStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable Long id){
		return userService.getUserByID(id);
	}
//	
//	@GetMapping("/{id}/{status}")
//	public Optional<User> getUserById(@PathVariable long id, @PathVariable PackageStatus status){
//		return userService.getUser
//	}
	
	@DeleteMapping("{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserByID(id);
	}
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		 userService.createNewUser(user);
	}
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable long id, @RequestBody User user) {
		
		 userService.updateUser(id, user);
	}
	
	
	
}
