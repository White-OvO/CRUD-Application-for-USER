package com.example.users.controller;

import java.util.List;

//import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.RoleDTO;
//import com.example.users.model.Role;
import com.example.users.model.Role;
//import com.example.users.service.EmailService;
import com.example.users.service.RoleService;






@RestController 
//request mapping will create something
//get mapping will pull information


//wrong will throw error 1948
//@RequestMapping("/users/user")

@RequestMapping("/users/role")

public class RoleController {

	private RoleService roleService;
	
	@Autowired
	private RoleController(RoleService  roleService) { 
		super();
		this.roleService = roleService;
		
}
	
	@PostMapping()
	public ResponseEntity<Role> saveRole(        //returns a user
			@RequestBody RoleDTO roleDto) { 		// while request body is DTO
			return new ResponseEntity<Role>(
				roleService.saveRole(roleDto),HttpStatus.CREATED);
	

	}
	@GetMapping
	public ResponseEntity<List<RoleDTO>> getAllRole() {
		return new ResponseEntity<List<RoleDTO>>(
				roleService.getAllRoles(),HttpStatus.OK);
	
	
	}
}
          