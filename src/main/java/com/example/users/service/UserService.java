package com.example.users.service;
import java.util.List;

import com.example.users.dto.SecurityUserDTO;
import com.example.users.dto.UserDTO;
import com.example.users.model.User;


public interface UserService {
public User saveUser(SecurityUserDTO userDto, Long roleId);
	
	public List <UserDTO> getAllUsers();
	
	public List <UserDTO> getUserById(Long userId);
	
	public User updateUser(SecurityUserDTO userDto, Long userId, Long roleId);
	
	public void deleteUser(Long id);
	
	public List<UserDTO> getUsersOrderByName(int page, int rows);
	
}

