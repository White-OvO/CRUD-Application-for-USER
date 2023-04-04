package com.example.users.service;

import java.util.List;
import java.util.Optional;

import com.example.users.model.User;

public interface UserService {
// creating a user ; 	
//method saveUser	
public User saveUser(User user);
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




public Optional<List<User>> 
getUsersOrderByName(int page, int rows);


}
