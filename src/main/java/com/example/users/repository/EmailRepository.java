package com.example.users.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.users.model.Email;
import com.example.users.model.User;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
	// method findByUser has one to many realtionship.
	Email findByUser(User user);

}