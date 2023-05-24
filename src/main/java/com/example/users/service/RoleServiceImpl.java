package com.example.users.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.users.dto.RoleDTO;
import com.example.users.model.Role;
import com.example.users.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService {
	private RoleRepository roleRepository;
	
	
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) { 
		this.roleRepository = roleRepository;
		
	}
	@Override
	public Role saveRole(RoleDTO roleDto) {
		Role newRole = new Role();
		newRole.setRoleName(roleDto.role());
		return roleRepository.save(newRole);
		
	}

	@Override                                             // services for this project
	
	public List<RoleDTO> getAllRoles() {
		return roleRepository.findAll()
					.stream() 
					.map(role -> new RoleDTO(
									role.getRoleId(),
									role.getRoleName()
							
							))
					.collect(Collectors.toList());
		
		
		
							
	}

}
