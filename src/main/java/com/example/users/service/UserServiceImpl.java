package com.example.users.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.users.dto.SecurityUserDTO;
import com.example.users.dto.UserDTO;
import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.Email;
import com.example.users.model.Role;
import com.example.users.model.User;
import com.example.users.repository.EmailRepository;
import com.example.users.repository.RoleRepository;
import com.example.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private EmailRepository emailRepository;  //dependency injection
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository
			, RoleRepository roleRepository, EmailRepository emailRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.emailRepository = emailRepository;
	}
	//saving it will need security
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User saveUser(SecurityUserDTO userDto, Long roleId) {
		User newUser = new User();
		Role existingRole = roleRepository.findById(roleId).orElseThrow(() ->
		new ResourceNotFoundException("Role", "Id", roleId));
		
		existingRole.setRoleId(roleId);
		// calling on a new user
		newUser.setPassword(userDto.password());
		String password = getPasswordEncoder().encode(newUser.getPassword()).toString();
		newUser.setPassword(password);
		
		newUser.setUserName(userDto.name());
		newUser.setEnabled(userDto.active());
		
		Set <Role> setExistingRole = new HashSet<>();
		setExistingRole.add(existingRole);
		
		newUser.setRole(setExistingRole);
		
		return userRepository.save(newUser);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(user -> new UserDTO(
						user.getUserId(),
						user.getUserName(),
						user.getRole()
							.stream()
							.map(Role::getRoleName)
							.collect(Collectors.toList()),
						user.getEmail()
							.stream()
							.map(Email::getEmailAddress)
							.collect(Collectors.toList())
						))
						.collect(Collectors.toList());
	}

	@Override
	public List<UserDTO> getUserById(Long id) {
		User existingUser = userRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User", "Id", id));
		
		return userRepository.findById(id)
				.stream()
				.map(user -> new UserDTO(
						user.getUserId(),
						user.getUserName(),
						user.getRole()
							.stream()
							.map(Role::getRoleName)
							.collect(Collectors.toList()),
						user.getEmail()
							.stream()
							.map(Email::getEmailAddress)
							.collect(Collectors.toList())
						))
						.collect(Collectors.toList());	
	}

	@Override
	public User updateUser(SecurityUserDTO userDto, Long userId, Long roleId) {
		User existingUser = userRepository.findById(userId).orElseThrow(() ->
		new ResourceNotFoundException("User", "Id", userId));
		
		Role existingRole = roleRepository.findById(roleId).orElseThrow(() ->
		new ResourceNotFoundException("Role", "Id", roleId));
		
		existingUser.setPassword(userDto.password());
		String password = getPasswordEncoder().encode(existingUser.getPassword()).toString();
		existingUser.setPassword(password);
		
		existingUser.setUserName(userDto.name());
		existingUser.setEnabled(userDto.active());
		
		existingRole.setRoleId(roleId);
		existingRole.getRoleName();
		
		Set <Role> setExistingRole = new HashSet<>();
		setExistingRole.add(existingRole);
		
		existingUser.setRole(setExistingRole);
		
		userRepository.save(existingUser);
		
		return existingUser;
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = userRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User", "Id", id));
		
		Email existingEmail = emailRepository.findByUser(existingUser);
		
		if (emailRepository.findByUser(existingUser) != null) {
			emailRepository.delete(existingEmail);
		}
		
		userRepository.deleteById(id);
	}

	@Override
	public List<UserDTO> getUsersOrderByName(int page, int rows) {
		Pageable list = PageRequest.of(page, rows);
		
		return userRepository.findByOrderByUserName(list)
				.stream()
				.map(user -> new UserDTO(
						user.getUserId(),
						user.getUserName(),
						user.getRole()
							.stream()
							.map(Role::getRoleName)
							.collect(Collectors.toList()),
						user.getEmail()
							.stream()
							.map(Email::getEmailAddress)
							.collect(Collectors.toList())
						))
						.collect(Collectors.toList());
	}
	
	

}