package com.example.users.service;

import com.example.users.model.user;

@Service
public class UserServicempl implements UserService {
	
	private UserRepository userRepository;
	
	
	
	
//	Constructor	
	@AutoWired
	public UserRepository (UserRepository userRepository) {
		this.userRepository = userRepository;
		
		}
	
//	repository looks for data
	
	@Override
public User saveUser(USer user) { 
	return userRepository.save(user); 
	
// 
}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	public List<User> (Long id) { 
		return userRepository.findBy(Id).orElseThrow(() -> 
		new ResourceNotFoundException("User", "Id", id));
		
		
		existingUser.serUserName(user.getUserName());
		
		
		userRepository.save(existingUser);
		
	
	return existingUser;
	
	}
	
	
	@Override
	public List<User> deleteuser(Long id) { 
		User existingUser = userRepository.findById(id).orElseThrow()) -> 
		
		///
		///
	}
	
}