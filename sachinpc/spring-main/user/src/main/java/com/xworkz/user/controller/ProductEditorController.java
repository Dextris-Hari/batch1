package com.xworkz.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.user.dto.ProductDTO;
import com.xworkz.user.service.ProductService;

@Controller
@RequestMapping("/editproduct")
public class ProductEditorController {
	@Autowired
	private ProductService productService;

	public ProductEditorController() {
		super();
		System.out.println(" created editor of productor");
		// TODO Auto-generated constructor stub
	}

//	@PostMapping
//	String editorProduct(Model model, HttpServletRequest request, ProductDTO dto) {
//		String parameter = request.getParameter("userMailId");
//
//		Boolean stock = productService.validateAndUpdateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStock(
//				dto.getProductName(), dto.getCategory(), dto.getPrice(), dto.getImage(), dto.getUpdatedBy(), parameter);
//
//		if (stock) {
//
//			model.addAttribute("msg", "updated");
//
//		} else {
//
//			model.addAttribute("msg", " not updated");
//
//		}
//
//		return "EditProductDetailsByMail";
//
//	}

}
