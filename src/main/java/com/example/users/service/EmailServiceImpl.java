package com.example.users.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.users.dto.EmailDTO;
import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.Email;
import com.example.users.model.User;
import com.example.users.repository.EmailRepository;
import com.example.users.repository.UserRepository;


@Service
public class EmailServiceImpl implements EmailService {
	private EmailRepository emailRepository;

	private UserRepository userRepository;

	
	
	@Autowired
	public EmailServiceImpl(EmailRepository emailRepository,UserRepository userrepository ) {
		this.emailRepository = emailRepository;
		
		this.userRepository = userRepository;
	}
		
		
	
	
	@Override
	public Email saveEmail(EmailDTO emailDto, Long userId) {
		Email newEmail = new Email();
		
		User existingUser = userRepository.findById(userId).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", userId));
		
		
		
		
		existingUser.setUserId(userId);
		
		newEmail.setEmailAddress(emailDto.address());
		newEmail.setUser(existingUser);
		return emailRepository.save(newEmail);
		
		
		
		 
	}

	@Override
	public List<EmailDTO> getAllEmails() {
	return emailRepository.findAll()
			.stream()
			.map(email -> new EmailDTO(
					email.getEmailId(),
					email.getEmailAddress()
					))
			.collect(Collectors.toList());
			
	}

}
