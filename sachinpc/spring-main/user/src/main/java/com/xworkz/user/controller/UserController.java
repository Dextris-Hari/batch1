package com.xworkz.user.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.user.dto.UserDTO;
import com.xworkz.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService service;

	public UserController() {

		System.out.println(" this is controller" + this.getClass().getSimpleName());
	}

	@PostMapping
	String Save(UserDTO dto, Model model, @RequestParam("image") MultipartFile request) throws IOException {
		byte[] bytes = request.getBytes();
		String saveFile = System.currentTimeMillis() + "_" + request.getOriginalFilename();
		System.out.println(request.getOriginalFilename() + "yes");
		System.out.println(saveFile);
		Path path = Paths.get("C://Users//Dell//Desktop//user/" + saveFile);
		System.out.println(path);

		Files.write(path, bytes);
		dto.setFileName(saveFile);
		Optional<List<UserDTO>> byMail = service.findByMail(dto.getMailId());
		System.out.println("================================================");
		System.out.println("ByMail manoj" + " " + byMail);
		System.out.println(byMail.isPresent() + " " + " checking the mail is null or what");
		System.out.println(dto.getMailId());
		System.out.println(byMail);
		System.out.println(byMail.isPresent());
		// dto.setSecurity("123");
		if (byMail.isPresent()) {
			System.out.println(" mail already there data base ali save agthila ");
			model.addAttribute("mesg", "your account is allready there please log in");
			return "SignIn";
		} else {
			System.out.println(dto);
			boolean save = service.validateAndSave(dto);
			if (save) {
				model.addAttribute("dto", dto);
				model.addAttribute("mesg", "registration is successfull");
				return "index";

			} else {

				model.addAttribute("mesg", "registration is unsuccessfull");

				return "SignUp";
			}
		}


	}
}
