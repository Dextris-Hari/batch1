package com.xworkz.KarthikController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.karthikdao.KarthikDAO;
import com.xworkz.karthikentity.KarthikEntity;

@Controller
@RequestMapping("/karthik")
public class KarthikController {
	@Autowired
	private KarthikDAO dao;

	public KarthikController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	String onSave(KarthikEntity dto, @RequestParam("image") MultipartFile request) throws IOException {
		byte[] bytes = request.getBytes();
		String saveFile = System.currentTimeMillis() + " " + request.getOriginalFilename();
		System.out.println(request.getOriginalFilename());
		System.out.println(saveFile);
		System.out.println("===========================================");
		Path path = Paths.get("C://Users//Dell//Desktop//Karthik/" + saveFile);//C:\Users\Dell\Desktop\Karthik
//		Files.write(path, bytes);
//		//entity.setFile("manoj");
		// @PostMapping
//	String Save(KarthikEntity dto, Model model, @RequestParam("image") MultipartFile request) throws IOException {
		// byte[] bytes2 = request.getBytes();
		// String saveFile = System.currentTimeMillis() + "_" +
		// request.getOriginalFilename();
		// System.out.println(request.getOriginalFilename() + "yes");
		System.out.println(saveFile);
		// Path path = Paths.get("C://Users//Dell//Desktop//user/" + saveFile);
		System.out.println(path);

		Files.write(path, bytes);

		Boolean save = dao.save(dto);
		System.out.println(save);

		return "Success";
	}

}
