package com.xworkz.bar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.bar.dto.BarDTO;
import com.xworkz.bar.service.BarService;

@Controller
@RequestMapping("/bar")
public class BarController {
	@Autowired
	private BarService service;

	public BarController() {
		// TODO Auto-generated constructor stub

		System.out.println(" nanu barcontroller " + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onCollect(BarDTO dto) {

		System.out.println(" nanu onCollect method ");
		System.out.println(" maga ninu edune save madthirodu" + dto);
		service.validateAndSave(dto);

		return "Display";

	}

	@GetMapping
	String ReadAll(Model model) {

		List<BarDTO> all = service.validateAndReadAll();
		model.addAttribute("manoj", all.size());
		model.addAttribute("man", all);

		return "All";
	}
	@GetMapping("/man")
	String readByName(Model model, HttpServletRequest request) {
		String parameter = request.getParameter("name");
		List<BarDTO> list = service.validateReadAll("parameter");
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		model.addAttribute("manoj", list.size());
		model.addAttribute("man", list);
		
		
		return "All";
	}
	

}
