package com.example.users.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.users.model.user;
import com.example.users.service.UserService;






@Restcontroller
															//request mapping will create something
															//get mapping will pull information

@RequestMapping("/users/user")
		
public class UserController {
//calling service
	private UserService userService;
	
	//constructoe
	@Autowired
	private UserController(UserService userService) { 
		super();
		this.userService = userService;
		
	}public ResponseEntity<User> saveUser(
			@RequestBody User user) {
		return new ResponseEntity<User>(
				userService.saveUser(user),HttpStatus.CREATED);
	
	

	}@GetMapping public ResponseEntity<List<User>> getAllUser() {
		return new ResponseEntity<List<User>>(
				userService.getAllUsers(),HttpStatus.OK);
	
	
	}
	//needs a unique path
	@GetMapping("{user_id}")
	public ResponseEntity<User> getUserById(
			@PathVariable("user_id") Long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);} 
			//update to project 
			@PutMapping("{user_id}")
					public ResponseEntity<user> updateUser ( )@PathVariable("user_id")
					Long id,
					@RequestBody User user) 
{
return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
		
}@PutMapping("{user_id}")
public ResponseEntity<User> updateUser(
		@PathVariable("user_id") Long id,
		@RequestBody User user) {
	return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
}


@DeleteMapping("{user_id}")
public ResponseEntity<String> deleteUser(
		@PathVariable("user_id") Long id) {
	userService.deleteUser(id);
	return new ResponseEntity<String>("User " + id + " has been deleted...", HttpStatus.OK);
}
@GetMapping("/pages")
public ResponseEntity<Optional<List<User>>> getUsersOrderByName(
		int page, int rows) {
	return new ResponseEntity<Optional<List<User>>>(userService.getUsersOrderByName(page-1, rows), HttpStatus.OK);
			
			
}
		
}

//THIS MAKES A NEW USER with JPA
