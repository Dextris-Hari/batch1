package com.xworkz.hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.hotel.dto.HotelDTO;
import com.xworkz.hotel.service.HotelService;
import com.xworkz.hotel.service.impl.HotelServiceImpl;

@Controller
@RequestMapping("/man")
public class HotelController {
	@Autowired
	private HotelService service;

	public HotelController() {
		System.out.println(" controller created " + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}
@PostMapping
	String onSave(HotelDTO dto) {
		System.out.println(" methods ");

		service.validateAndSave(dto);

		return "Display";
	}
@GetMapping
String onReadAll(Model model) {
	List<HotelDTO> list = service.validateAndReadAll();
	if(list!=null&&!list.isEmpty()) {
		System.out.println(" no of hotel:"+list.size());
		
		model.addAttribute("size", list.size());
		model.addAttribute("details", list);
		
		
	}
	
	
	
	return "Details";
}
@GetMapping("/man")
String readByName(Model model,HttpServletRequest  request) {
	String parameter = request.getParameter("name");
	List<HotelDTO> list = service.validateAndReadByName(parameter);
	model.addAttribute("size", list.size());
	model.addAttribute("details", list);
	return "Details";
}



}
