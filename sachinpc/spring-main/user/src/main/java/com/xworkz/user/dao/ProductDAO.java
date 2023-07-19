package com.xworkz.user.dao;

import java.util.List;

import com.xworkz.user.dto.ProductDTO;

public interface ProductDAO {
	Boolean saveProduct(ProductDTO dto);
	default List<ProductDTO> readAllProduct(){
		return null;
		
		
		
	}
	default List<ProductDTO>  readProductByName(String name) {
		return null;
		
		
		
		
	}
	default Boolean updateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStock
	(String productName,String category, Double price, String image, String updatedBy, String mail) {
		return null;
		
		
		
		
	}
	default List<ProductDTO>  readProductByCategory(String category) {
		return null;
		
		
		
		
	}

}
