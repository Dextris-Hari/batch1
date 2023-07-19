package com.xworkz.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.user.dao.ProductDAO;
import com.xworkz.user.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;

	public ProductServiceImpl() {
		super();
		System.out.println(" created ProductService");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean ValidateAndSaveProduct(ProductDTO dto) {
		return dao.saveProduct(dto);
	}

	@Override
	public List<ProductDTO> validateAndReadAllProduct() {
		// TODO Auto-generated method stub
		return dao.readAllProduct();
	}

	@Override
	public List<ProductDTO> validateAndReadProductByName(String name) {
		// TODO Auto-generated method stub
		return dao.readProductByName(name);
	}

//	@Override
//	public Boolean validateAndUpdateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStock(String productName,
//			String category, Double price, String image, String updatedBy, String mail) {
//		// TODO Auto-generated method stub
//		return dao.updateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStock(productName, category, price,
//				image, updatedBy, mail);
//
//	}
	@Override
	public List<ProductDTO> validateReadProductByCategory(String name) {
		// TODO Auto-generated method stub
		return dao.readProductByCategory(name);
	}

}
