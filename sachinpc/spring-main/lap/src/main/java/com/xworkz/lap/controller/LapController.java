package com.xworkz.lap.controller;

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

import com.xworkz.lap.dao.LapDAO;
import com.xworkz.lap.entity.LapEntity;

@Controller
@RequestMapping("/manoj")
public class LapController {
	@Autowired
	private LapDAO dao;

	@PostMapping
	String onSave(LapEntity entity, @RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(" enter to onsave method");
		byte[] bytes = file.getBytes();
		String fileName = System.currentTimeMillis() +" "+ file.getOriginalFilename();
		Path path = Paths.get("C://Users//Dell//Desktop//practice/" + fileName);
		Files.write(path, bytes);
		entity.setFileName(fileName);
		Boolean save = dao.save(entity);
		System.out.println(save);

		return "Success";
	}

}
