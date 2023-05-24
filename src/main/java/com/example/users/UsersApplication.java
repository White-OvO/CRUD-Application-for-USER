package com.example.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}

//////////// annotations: 
///@controller is used to determine  a controller and treat it diffrent than other class
///@responcebody mapping to json and visversa
 //@SpringBopotConfiguration tells that that class is the configuration class
 //@Enableautoconiguration once the class are set the configuration does it work with an open api and does a call to it
 //@comoponetScan making spring boot load all claases starting with the package it finds where the annotation is located
// keep in mind component scan is is applyed and thats what causes spring boot discover of all of our classes.
