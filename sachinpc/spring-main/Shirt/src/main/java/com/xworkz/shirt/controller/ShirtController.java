package com.xworkz.shirt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.shirt.dto.ShirtDTO;
import com.xworkz.shirt.service.ShirtService;

@Controller
@RequestMapping("/shirt")
public class ShirtController {

	@Autowired
	private ShirtService service;

	public ShirtController() {
		// TODO Auto-generated constructor stub
		System.out.println("nanu Shirtcontroller" + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onsave(ShirtDTO dto) {

		System.out.println("nanu onsave methode");
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
	String omReadAll(Model model) {
		List<ShirtDTO> list = service.validateAndReadAll();
		model.addAttribute("man", list.size());
		model.addAttribute("manoj", list);

		return "Details";
	}

	@GetMapping("/man")
	String omReadByBrand(Model model, HttpServletRequest request) {
		String parameter = request.getParameter("brand");
		
		List<ShirtDTO> list = service.validateAndreadByBrand(parameter);
		//System.out.println(list.isEmpty());
		//sSystem.out.println(list.size());
		//model.addAttribute("man", list.size());
		model.addAttribute("manoj", list);

		return "Details";
	}
}
