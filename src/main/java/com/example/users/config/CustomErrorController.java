package com.example.users.config;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class CustomErrorController implements ErrorController {

	
	@RequestMapping("/error")
	@ResponseBody
	String errror(HttpStatus status) { 
		return ("error" + status);
		
		
	}
	
	
	public String  getErrorPath() { 
		return "/error" ;
		
	}
}
