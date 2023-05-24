package com.example.users.service;
import java.util.List;

import com.example.users.dto.EmailDTO;
import com.example.users.model.Email;




public interface EmailService {
	public Email saveEmail(EmailDTO emailDto, Long userId);
public List<EmailDTO> getAllEmails();
}