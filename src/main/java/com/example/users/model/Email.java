package com.example.users.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

//other side to the many to one or many to many
@Entity
@Getter
@Setter
public class Email {

	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO) 
	private Long emailId;
	
	private String emailAddress;
	
	@ManyToOne
	@JoinColumn(name = "user_id") ///////
	//////////////// 
}
