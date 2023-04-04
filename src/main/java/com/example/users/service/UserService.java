package com.example.users.service;

import java.util.List;

public interface UserService {
// creating a user ; 	
//method saveUser	
public user saveUser(User user);
// the methods are saved here
 

//getting all users
	public List <User> getAllUsers();
	//declaremethods
public User getUserById(Long id);


public User updateUser (User user, Long id) ;

//////////////////////check this page///////////////////////////////////////
public void deleteUser(Long id);

//
//public Optional<List<User>> getUserOrderByName
//Pageable List = PageRequest.of(page, rows);

return userRepository.findByOrderUserName(int page, int rows);

@override
public Optional<List<User>> getUserOrderByName
Pageable List = PageRequest.of(page, rows);


}
