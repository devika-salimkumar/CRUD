package com.codechallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codechallenge.entity.User;
import com.codechallenge.repository.UserRepository;

@SpringBootTest
class CodechallengeApplicationTests {
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	public void testCreate() {
		
		User u = new User();
		u.setId(5);
		u.setFirstName("jestin");
		u.setLastName("jiji");
		u.setDob("1999-10-22");
		u.setEmailId("jestin@hotmail.com");
		u.setPaswrd("abc123sdhd");
		userRepo.save(u);
		
		assertNotNull(userRepo.findById(5L).get());
	}
	
	@Test
	public void testReadAll() {
		List<User> user = (List<User>) userRepo.findAll();
		assertNotNull(user.size());
		//asserThat(user.size().isGreaterThan(0));
		
	}
	
	@Test
	public void testSingleUser() {
		User singleUser = userRepo.findById(4L).get();
		assertEquals("keziajohn@gmail.com",singleUser.getEmailId());
		
	}
	
	@Test
	public void testUpdate() {
		
		User u = userRepo.findById(1L).get();
		u.setLastName("dominic");
		userRepo.save(u);
		assertNotEquals("dominic",userRepo.findById(1L).get().getLastName());
	}

	@Test
	public void testDelete() {
		userRepo.deleteById(6L);
		assertNull(userRepo.findById(6L));
	
	}
	
	
	
	
}
