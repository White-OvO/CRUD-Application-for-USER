package com.example.users.dto;

import java.util.List;

public record SecurityUserDTO(       // this this passing through the methods
		Long id,
		String name,
		String password,
		boolean active,
		List <String> role,
		List <String> email
		) {

}