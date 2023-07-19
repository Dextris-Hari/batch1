package com.xworkz.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.user.dto.UserDTO;
import com.xworkz.user.service.UserService;

@Controller
@RequestMapping("/passward")
public class PasswardController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService service;

	public PasswardController() {
		super();
		System.out.println("created PasswardController");
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	String updatePassward(UserDTO dto) {
		System.out.println(" running in updatePassward ");
		Optional<Boolean> passwardByMail = service.updatePasswardByMail(dto.getSecurity(), dto.getMailId());
		if (passwardByMail.isPresent()) {
			System.out.println(" passward is updated pls login");
			return "SignIn";
		} else {
			System.out.println(" passward is not updated");
		}

		return "UpdatePassward";

	}

}
