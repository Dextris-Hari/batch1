package com.xworkz.nandan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.nandan.entity.NandanDTO;
import com.xworkz.nandan.repository.NandanRepo;

@Controller
@RequestMapping("/man")
public class NandanController {
	@Autowired
	private NandanRepo nandanRepo;

	public NandanController() {
		super();
		System.out.println(" created controller");
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	String onSave(NandanDTO dto) {

		nandanRepo.save(dto);

		return "Success";
	}

}
