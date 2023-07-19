package com.xworkz.train.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.xworkz.train.dto.TrainDTO;
import com.xworkz.train.service.TrainService;

@Controller
@RequestMapping("/train")
public class TrainController {
	@Autowired
	private TrainService service;

	public TrainController() {
		System.out.println("nanu TrainController created ade hen madbeku ega helu");
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	public String onsave(TrainDTO dto, ServletRequestDataBinder binder) throws IOException {
		byte[] bs = dto.getImage().getBytes();
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		Path path = Paths.get("C://Users//Dell//Desktop//MANOJ/" + dto.getImage().getOriginalFilename());
		Files.write(path, bs);
		System.out.println("nanu onsave method");

		System.out.println("nodko edune ninu save madthirodu" + dto);
		boolean b = service.validateAndSave(dto);
		System.out.println("manoj");
		if (b) {
			System.out.println("data is stored");
			return "Display";
		} else {
			System.out.println("agila");
			return "index";
		}

	}

	@GetMapping
	String readAll(Model model) {
		List<TrainDTO> list = service.validateReadAll();
		model.addAttribute("man", list.size());
		model.addAttribute("manoj", list);

		return "DisplayAll";
	}

	@GetMapping("/man")
	String onReadByBrand(Model model, HttpServletRequest request) {
		String string = request.getParameter("trainName");
		List<TrainDTO> list = service.validateReadByName(string);

		model.addAttribute("man", list.size());
		model.addAttribute("manoj", list);

		return "DisplayAll";
	}

}
