package com.example.users.controller;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.RoleDTO;
import com.example.users.dto.SecurityUserDTO;
import com.example.users.dto.UserDTO;
import com.example.users.model.User;
import com.example.users.service.UserService;
@RestController
@RequestMapping("/users/user")
public class UserController {

	private UserService userService;
	
	@Autowired
	private UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping()
	public ResponseEntity<User> saveUser(
			@RequestBody SecurityUserDTO userDto,
			@RequestParam Long roleId) {
		return new ResponseEntity<User>(
				userService.saveUser(userDto, roleId),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUser() {
		return new ResponseEntity<List<UserDTO>>(
				userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("{user_id}")
	public ResponseEntity<List<UserDTO>> getUserById(
			@PathVariable("user_id") Long id) {
		return new ResponseEntity<List<UserDTO>>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PutMapping("{user_id}")
	public ResponseEntity<User> updateUser(
			@PathVariable("user_id") Long userId,
			@RequestParam("role_id") Long roleId,
			@RequestBody SecurityUserDTO userDto) {
		return new ResponseEntity<User>(userService.updateUser(userDto, userId, roleId), HttpStatus.OK);
	}
	
	@DeleteMapping("{user_id}")
	public ResponseEntity<String> deleteUser(
			@PathVariable("user_id") Long id) {
		String getUser = userService.getUserById(id).toString();
		userService.deleteUser(id);
		return new ResponseEntity<String>("User " + getUser + " has been deleted...", HttpStatus.OK);
	}
	
	@GetMapping("/pages")
	public ResponseEntity<List<UserDTO>> getUsersOrderByName(
			int page, int rows) {
		return new ResponseEntity<List<UserDTO>>(userService.getUsersOrderByName(page-1, rows), HttpStatus.OK);
	}
	
}