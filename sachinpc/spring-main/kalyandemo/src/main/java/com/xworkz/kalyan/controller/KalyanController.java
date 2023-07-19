package com.xworkz.kalyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.kalyandemo.entity.KalyanEntity;
import com.xworkz.kalyandemo.repo.KalyanRepository;

@Controller
@RequestMapping("/manoj")
public class KalyanController {
	@Autowired
	private KalyanRepository repository;

	@PostMapping
	public String save(KalyanEntity entity) {

		System.out.println("save method is running");

		return "Success";
	}

}
