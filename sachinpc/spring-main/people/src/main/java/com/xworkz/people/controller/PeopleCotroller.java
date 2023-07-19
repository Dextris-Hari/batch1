package com.xworkz.people.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.people.dao.PeopleDAO;
import com.xworkz.people.dto.PeopleDTO;

@Controller
@RequestMapping("/man")
public class PeopleCotroller {
	@Autowired
	PeopleDAO dao;
	public PeopleCotroller() {
		System.out.println("created "+this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
	@PostMapping
	String onsave(PeopleDTO dto, @RequestParam("manoj") MultipartFile file) throws IOException{
		dao.save(dto);
		byte[] bytes = file.getBytes();
		 String saveFile=System.currentTimeMillis()+"_"+file.getOriginalFilename();
			Path path = Paths.get("C://Users//Dell//Desktop//MANOJ/"+saveFile);
			System.out.println(path);

		Files.write(path, bytes);
		System.out.println(dto);
		dto.setFileName(saveFile);
		
		
		
		return "Display";
	}
	

}
