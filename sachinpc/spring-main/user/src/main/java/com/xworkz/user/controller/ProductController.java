package com.xworkz.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.user.dto.ProductDTO;
import com.xworkz.user.service.ProductService;

@Controller
@RequestMapping("/add")
public class ProductController {
	@Autowired
	 private ProductService service;

	public ProductController() {
		super();
		System.out.println("ProductController" );
		// TODO Auto-generated constructor stub
	}
	@PostMapping
	String onAdd(ProductDTO dto/*,@RequestParam("image") MultipartFile file*/,Model model) throws IOException {
		
//		try {
//			byte[] bytes = file.getBytes();
//			String saveFile = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//			System.out.println(file.getOriginalFilename() + "yes");
//			System.out.println(saveFile);
//			Path path = Paths.get("C://Users//Dell//Desktop//user/" + saveFile);
//			System.out.println(path);
//
//			Files.write(path, bytes);
			dto.setImage("manoj");
			service.ValidateAndSaveProduct(dto);
			model.addAttribute("msg","product add successfully");
			return "Sell";
//		} catch (IOException e) {
//			System.out.println(" nanu barala hen madthiya egaa ");
//			e.printStackTrace();
//		}
	}
	
	@GetMapping
	String onReadAll(Model model) {
		List<ProductDTO> all = service.validateAndReadAllProduct();
		System.out.println("readalllllllllllll");
		if (all != null && !all.isEmpty()) {
			System.out.println(" size" + all.size());
			model.addAttribute("size", "details of pg" + all.size());
			// model.addAttribute("size","total criminals found :"+all.size());
			model.addAttribute("details", all);
  System.out.println("mauydrtfyguiuougf");
			return "AllProduct";

		}
		return "AllProduct";
	}
	@GetMapping("/add")
	String onReadByName(Model model, HttpServletRequest request) {
		System.out.println("read by nameeeeeeeeeeeeeeeeeeeee");
		String parameter = request.getParameter("productName");
		System.out.println("🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔🤔"+parameter);
		
		List<ProductDTO> all = service.validateAndReadProductByName(parameter);
		if (all != null && !all.isEmpty()) {
			System.out.println(" size" + all.size());
			model.addAttribute("size", "details of pg" + all.size());
			// model.addAttribute("size","total criminals found :"+all.size());
			model.addAttribute("details", all);
			

			return "AllProduct";//http://localhost:8080/pg/man

		}
		else {
			model.addAttribute("size", "details of product " + all.size());
			model.addAttribute("msg", "there is no product on this name we will add soon ");
			
		return "AllProduct";
		}
	}
	
	@GetMapping("/manoj")
	String onReadByCategory(Model model, HttpServletRequest request) {
		String parameter = request.getParameter("category");
		List<ProductDTO> all = service.validateReadProductByCategory(parameter);
		model.addAttribute("size", "details of pg" + all.size());
		model.addAttribute("details","manojis  "+ all);
		return "AllProduct";
	}


}
