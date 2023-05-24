package com.example.users.service;

import java.util.List;

import com.example.users.dto.RoleDTO;
import com.example.users.model.Role;
public interface RoleService {


	
	public Role saveRole(RoleDTO roleDto);
	
	public List <RoleDTO> getAllRoles();


}
