package com.example.users.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import 
@Repository
// mock data is also included here


//extend respository stores data or calling data base for specific information		

public interface UserRespository extends JpaRespository<User,Long>{

	Optional<List<User>> findByOrderByUserName(pageable list);
	/////////////////////////////////////////////////
	//custom methods here
}
