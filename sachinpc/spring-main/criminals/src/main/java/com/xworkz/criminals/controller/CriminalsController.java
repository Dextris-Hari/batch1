package com.xworkz.criminals.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.criminals.dto.CriminalsDTO;
import com.xworkz.criminals.service.CriminalsService;

@Controller
@RequestMapping("criminals")
public class CriminalsController {
	@Autowired
	private CriminalsService service;

	public CriminalsController() {
		System.out.println(" nanu git test madthidini ");
		// TODO Auto-generated constructor stub
		System.out.println(" nanu criminalcontroller" + this.getClass().getSimpleName());
	}

	@RequestMapping
	String onSave(CriminalsDTO dto) {

		System.out.println(" nanu onsave method");
		System.out.println(" ninu edune save madthirodu bekidre nodko" + dto);
		service.validateAndSave(dto);
		return "Display";
	}

	@GetMapping
	public String readAll(Model model) {
		System.out.println(" nanu read all method");
		List<CriminalsDTO> dtos = service.validateAndReadAll();
		if (dtos != null && !dtos.isEmpty()) {
			System.out.println("dtos are found.." + dtos.size());
			model.addAttribute("criminalsdetails", dtos);
			model.addAttribute("size", "total criminals found :" + dtos.size());
			model.addAttribute("msg", "this is the data");
		} else {
			System.out.println("dtos is not found");
			model.addAttribute("msg", "data is empty");
		}

		return "CriminalsDetails";
	}

	@GetMapping("/man")
	public String findByName(HttpServletRequest request, Model model) {
		String parameter = request.getParameter("name");
		List<CriminalsDTO> list = service.findByName(parameter);

		if (list != null && !list.isEmpty()) {
			System.out.println("dtos are found.." + list.size());
			model.addAttribute("criminalsdetails", list);
			model.addAttribute("size", "total criminals found :" + list.size());
		}

		return "CriminalsDetails";
	}

}
