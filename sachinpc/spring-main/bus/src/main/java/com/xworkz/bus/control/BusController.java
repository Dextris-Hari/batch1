package com.xworkz.bus.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.bus.dto.BusDTO;
import com.xworkz.bus.service.BusService;

@Controller
@RequestMapping("/bus")
public class BusController {
	@Autowired
	private BusService service;

	public BusController() {
		System.out.println("buscontroller is created " + this.getClass().getSimpleName());

	}

	@PostMapping
	public String onCollect(BusDTO dto) {
		System.out.println("oncollect method is running" + dto);
		service.validateAndCollect(dto);
		return "Display";
	}

	@GetMapping
	String readAll(Model model) {

		List<BusDTO> list = service.readAll();
		model.addAttribute("man", list.size());
		model.addAttribute("manoj", list);

		return "All";
	}
@GetMapping("/man")
	String ReadAllByName(Model model, HttpServletRequest request) {
		String parameter = request.getParameter("name");
		List<BusDTO> readAll = service.readAll(parameter);
		model.addAttribute("man", readAll.size());
		model.addAttribute("manoj", readAll);
		return "All";
	}

}
