package com.xworkz.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.util.concurrent.Service;
import com.xworkz.user.dto.UserDTO;
import com.xworkz.user.service.UserService;

@Controller
@RequestMapping("/edit")
public class UserEditController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService service;

	public UserEditController() {
		super();
		System.out.println(" edit controller is created ");
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	String editProfile(Model model, UserDTO dto) {
		System.out.println("kgscjvasjcvasjascashm");
		System.out.println(dto);
		System.out.println(dto.getMailId() + "      jbkdgkaGKGVEUG");
		Optional<List<UserDTO>> findByMail = service.findByMail(dto.getMailId());
		System.out.println(" banthu");
		List<UserDTO> list = findByMail.get();
		System.out.println(" banthu 22222");
		UserDTO userDTO = list.get(0);

		model.addAttribute("msg", userDTO);

		return "Edit";
	}

}
