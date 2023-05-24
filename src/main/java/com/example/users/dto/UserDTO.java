package com.example.users.dto;
import java.util.List;
public record UserDTO(
		Long id,
		String name,                      
		List<String> role,
		List <String> email
// import java for List		
		) {

}
