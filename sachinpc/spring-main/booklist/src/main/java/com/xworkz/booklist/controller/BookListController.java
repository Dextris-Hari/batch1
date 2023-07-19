package com.xworkz.booklist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.booklist.dto.BookListDTO;
import com.xworkz.booklist.service.BookListService;

@Controller
@RequestMapping("/book")
public class BookListController {
	@Autowired
	private BookListService service;

	public BookListController() {
		System.out.println(" nanu BookListController" + this.getClass().getSimpleName());
		// TODO Auto-generated constructor stub
	}

	@PostMapping
	String onSave(BookListDTO dto) {
		System.out.println(" nanu controller li ero onsave method");
		System.out.println(" ninu edune save madthirodu nodko" + dto);
		service.validateAndave(dto);
		return "Display";
	}

	@GetMapping
	String readAll(Model model) {

		System.out.println(" nanu helavanu thoristhini");
		List<BookListDTO> list = service.readAndValidateALL();
		if (list != null && !list.isEmpty()) {
			System.out.println(" this is the size of book:" + list.size());
			model.addAttribute("details", list);
			model.addAttribute("size", list.size());

		}

		return "SeeAll";
	}
@GetMapping("/man")
	String OnReadByName(Model model, HttpServletRequest request) {
		String attribute = request.getParameter("name");
		List<BookListDTO> list = service.readByName(attribute);
		model.addAttribute("size", list.size());
		model.addAttribute("details", list);

		return "SeeAll";
	}

}
