package com.example.users.respository;


// mock data is also included here


//extend respository stores data or calling data base for specific information		
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<List<User>> findByOrderByUserName(Pageable list);

	/////////////////////////////////////////////////
	//custom methods here
}
