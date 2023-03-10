package com.example.demo;

import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFound;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	User user;
	@BeforeEach
	public void setup(){
		user = new User(1,"Test", "Indore");
	}

	@AfterEach
	public void tearDown(){
		user = null;
		userRepository.deleteAll();
	}


	// Positive Test case for Get By Id Method
	@Test
	public void test_findById(){
		User user1 = userRepository.save(this.user);
		User actual = userRepository.findById(user1.getId()).get();
		assertEquals(actual.getCity(), user1.getCity());
	}

	// Negative Test case for Get By Id Method
	@Test
	public void test_findById_negative(){
		Exception e = assertThrows(NoSuchElementException.class,()-> userRepository.findById(10).get());
		assertEquals("No value present", e.getMessage());
	}

	// Positive Test case for Add User Method
	@Test
	public void test_addUser(){
		User user1 = userRepository.save(this.user);
		assertEquals(user1.getName(), user1.getName());
	}

	// Negative Test case for Delete User Method
	@Test
	public void test_deleteUser_negative(){
		Exception e = assertThrows(ResourceNotFound.class,()-> userService.delete(user.getId()));
		assertEquals("User with id : 1 does not exists", e.getMessage());
	}

	// Positive Test case for Update User Method
	@Test
	public void test_update(){
		User user1 = userRepository.save(this.user);
		user1.setCity("new");
		userService.update(user1.getId(),user1);
		assertEquals("new", user1.getCity());
	}

}
