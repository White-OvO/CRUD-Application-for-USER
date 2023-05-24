package com.example.users.repository;


// mock data is also included here


//extend respository stores data or calling data base for specific information		
import java.util.List;
//import java.util.Optional; --because we took of the optional from the method

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByOrderByUserName(Pageable list);

	User findByUserName(String username);

	/////////////////////////////////////////////////
	//custom methods here
}
