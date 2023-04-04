package com.example.users.model;

import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
@Id
@GeneratedValue(straegy = GenerationType.AUTO)
	private Long roleId;

	private String roleName;
	
// many to many mapping
	
	@ManyToMany(mappedBy = "role")
	@JsonIgnore
	private Set <user> user = HashSet<>();
	


} 

