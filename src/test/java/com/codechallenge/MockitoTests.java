package com.codechallenge;


import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.codechallenge.entity.User;
import com.codechallenge.repository.UserRepository;
import com.codechallenge.service.UserServicee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoTests {
	
	
	@Autowired
	private UserServicee service;
	
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getAllUsersTest() {
		
		when(repository.findAll()).thenReturn(Stream.of(new User("Devika","Salimkumar","1997-12-23",
				"devikasalimkumar@gmail.com","qwerty8974")).collect(Collectors.toList()));
		assertEquals(1,service.getAllUsers().size());
		
	}
	
	@Test
	public void addUserTest() {
		User user = new User("Devika","Salimkumar","1997-12-23",
				"devikasalimkumar@gmail.com","qwerty8974");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,service.addUser(user));
	}
	
	@Test
	public void deleteUserTest() {
		User user = new User("jestin","jiji","1999-10-22","jestin@hotmail.com","abc123sdhd");
		service.deleteUser(user.getId());
		verify(repository,times(1)).deleteById(user.getId());
	}
	
	
	
	

}
