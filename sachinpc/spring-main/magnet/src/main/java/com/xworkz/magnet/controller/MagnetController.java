package com.xworkz.magnet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.magnet.dao.MagnetDAO;
import com.xworkz.magnetdto.MagnetDTO;

@Controller
@RequestMapping("/magnet")
public class MagnetController {
	@Autowired
	private MagnetDAO dao;

	public MagnetController() {
		super();
		// TODO Auto-generated constructor stub
	}
@PostMapping
	String save(MagnetDTO dto) {
	boolean save = dao.save(dto);
	System.out.println(save);

		return "Success";
	}

}
