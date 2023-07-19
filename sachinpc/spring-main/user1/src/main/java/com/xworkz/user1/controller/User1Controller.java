package com.xworkz.user1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.user1.entity.User1;
import com.xworkz.user1.service.User1Service;

@Controller
@RequestMapping("/user1")
class User1Controller {
	@Autowired
	private User1Service service;

	public User1Controller() {
		super();
		System.out.println(" created controller");
	}
	 public String save(User1 user1) {
		 
		 Boolean validateAndSave = service.validateAndSave(user1);
		 System.out.println(validateAndSave);
		 
		 
		 return "Success";
	 }

	
}
