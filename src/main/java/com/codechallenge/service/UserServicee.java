package com.codechallenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallenge.entity.User;
import com.codechallenge.repository.UserRepository;

@Service
public class UserServicee {
	
	@Autowired
	public UserRepository userRepo;

	public List<User> getAllUsers()
	{
		List<User> user = new ArrayList<>();
		userRepo.findAll().forEach(user::add);
		return user;
	}

	public User addUser(User user) {
		User theUser = userRepo.save(user);
		return theUser;
		
	}

	public void updateUser(Long id, User user) {
		userRepo.save(user);
		
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		
	}

	public Optional<User> getUser(Long id) {
		
		Optional<User> theUser = userRepo.findById(id);
		return theUser;
	}
		
	

}
