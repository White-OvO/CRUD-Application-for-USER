package com.example.users.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.users.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

@Entity 
// makes the CREATE TABLE possible


// Users need to be changed through project

public class User  {
//	columns Private KEY = @Id
//	Strategy type strategy = GeneratiobType.AUTO 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long userId;
	
	private String userName;	
	private String password;

	private boolean enabled;
	
	
//   Hibernating this code will auto run to MYSQL with the type of tables that you have created.
//  gives rows on MYSQL
 	@ManyToMany
// 	@JoinTable  	we give it a name "user_id"
	@JoinTable(name = "user_role",
	joinColumns = { 
// 	"user_id on the other hand will do the opposite and name a user_id; note it is a private method
			@JoinColumn(name = "user_id")},
	inverseJoinColumns = { 
// role_id is a prvivate for "role_id"		
			@JoinColumn(name = "role_id")
			})
@JsonIgnore
private Set <Role> role = new HashSet<>();

@OneToMany(mappedBy = "user")
@JsonIgnore
private Set<Email> email = new HashSet<>();



}


