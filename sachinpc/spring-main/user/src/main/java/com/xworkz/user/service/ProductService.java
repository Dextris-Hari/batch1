package com.xworkz.user.service;

import java.util.List;

import com.xworkz.user.dto.ProductDTO;

public interface ProductService {
	
	Boolean ValidateAndSaveProduct(ProductDTO dto);
	default List<ProductDTO> validateAndReadAllProduct(){
		return null;
		
		
		
	}
	default List<ProductDTO>  validateAndReadProductByName(String name) {
		return null;
		
		
		
		
	}
	default Boolean validateAndUpdateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStock
	(String productName,String category, Double price, String image, String updatedBy, String mail) {
		return null;
		
		
		
		
	}
	default List<ProductDTO>  validateReadProductByCategory(String name) {
		return null;
		
		
		
		
	}

}
