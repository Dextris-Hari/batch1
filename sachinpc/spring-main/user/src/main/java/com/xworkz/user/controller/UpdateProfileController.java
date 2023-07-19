package com.xworkz.user.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.user.dao.UserDAO;
import com.xworkz.user.dto.UserDTO;

@Controller
@RequestMapping("/update")
public class UpdateProfileController {
	@Autowired
	private UserDAO dao;

	public UpdateProfileController() {
		super();
		System.out.println(" cretaed UpdateProfileController");
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	String update(UserDTO dto , @RequestParam("image") MultipartFile request) throws IOException {
		byte[] bytes = request.getBytes();
		String saveFile = System.currentTimeMillis() + "_" + request.getOriginalFilename();
		System.out.println(request.getOriginalFilename() + "yes");
		System.out.println(saveFile);
		Path path = Paths.get("C://Users//Dell//Desktop//user/" + saveFile);
		System.out.println(path);

		Files.write(path, bytes);
		dto.setFileName(saveFile);
		System.out.println(dto);
		Boolean bymail = dao.updateNameAndPhoneNumberBymail(dto.getMailId(), dto.getPhoneNumber(), dto.getName(),dto.getFileName());
		System.out.println(" updated 🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌");
		System.out.println(dto.getName() + dto.getMailId() + dto.getPhoneNumber());

		return "SignIn";
	}

}
