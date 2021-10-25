package com.codechallenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.entity.User;
import com.codechallenge.service.UserServicee;

@RestController
public class UserController {
	
	
	@Autowired
	private UserServicee userServicee;
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{	
		
		return userServicee.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable Long id)
	{
		Optional<User>
		theUser = userServicee.getUser(id);
		
		if(theUser == null) {
			
			throw new UserNotFoundException("User id not found");
		}
		
		return theUser;	
		
	}
	
	@PostMapping("/users")
	public void addUser( @RequestBody User user) 
	{
		userServicee.addUser(user);

	}
	
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody User user) 
	{
		userServicee.updateUser(id, user);
	}
	
	
	@DeleteMapping("/users/{id}")
	public void DeleteUser(@PathVariable Long id)
	{
		userServicee.deleteUser(id);
	}

}
