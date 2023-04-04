package com.example.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.users.exception.ResourceNotFoundException;
import com.example.users.model.User;
import com.example.users.repository.UserRepository;




@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
//	Constructor	
	@AutoWired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
//	repository looks for data
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	
// 
}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}		
		public User getUserById(Long id) {
			return userRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("User", "Id", id));
		
	}
		@Override
		public User updateUser(User user, Long id) {
			User existingUser = userRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("User", "Id", id));
			
			existingUser.setUserName(user.getUserName());
			
			userRepository.save(existingUser);
			
			return existingUser;
		}
		@Override
		public void deleteUser(Long id) {
			User existingUser = userRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("User", "Id", id));
			
			userRepository.deleteById(existingUser.getUserId());
		}

		@Override
		public Optional<List<User>> getUsersOrderByName(int page, int rows) {
			Pageable list = PageRequest.of(page, rows);
			
			return userRepository.findByOrderByUserName(list);
		}
		
		

	}
