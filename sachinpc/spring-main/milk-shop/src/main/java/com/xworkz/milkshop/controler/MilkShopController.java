package com.xworkz.milkshop.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.milkshop.dto.MilkShopDTO;
import com.xworkz.milkshop.service.MilkShopService;

@Controller
@RequestMapping("/milk")
public class MilkShopController {

	@Autowired
	private MilkShopService milkShopService;

	public MilkShopController() {
		System.out.println("Milkshopcontroller is created" + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onSave(MilkShopDTO dto) {
		System.out.println("onSave method is running");
		System.out.println("milkshopdto" + dto);
		milkShopService.validateAndSave(dto);
		return "DisplaySuccess";
	}

	@GetMapping
	String ReadAll(Model model) {
		List<MilkShopDTO> list = milkShopService.readAll();
		model.addAttribute("man", list.size());
		model.addAttribute("manoj", list);

		return "Details";
	}

	@GetMapping("/man")
	String ReadAll(Model model, HttpServletRequest request) {
		String parameter = request.getParameter("name");

		List<MilkShopDTO> list = milkShopService.readByName(parameter);
		model.addAttribute("man", list.size());
		model.addAttribute("manoj", list);

		return "Details";
	}

}
