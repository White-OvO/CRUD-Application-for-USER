package com.example.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dto.EmailDTO;
import com.example.users.model.Email;
import com.example.users.service.EmailService;




@RestController 
//request mapping will create something
//get mapping will pull information



//wrong
//@RequestMapping("/users/user")

@RequestMapping("/users/email")


public class EmailController {
	private EmailService emailService;
	@Autowired
	private EmailController(EmailService  emailService) { 
		super();
		this.emailService = emailService;
		
}
	
	@PostMapping()
	public ResponseEntity<Email> saveEmail(        //returns a user
			@RequestBody EmailDTO emailDto,		// while request body is DTO
			@RequestParam Long userId) {
		return new ResponseEntity<Email> (
				emailService.saveEmail(emailDto, userId),HttpStatus.CREATED);
	

	}
	@GetMapping
	public ResponseEntity<List<EmailDTO>> getAllEmail() {
		return new ResponseEntity<List<EmailDTO>>(
				emailService.getAllEmails(),HttpStatus.OK);
	
	
	}
}
