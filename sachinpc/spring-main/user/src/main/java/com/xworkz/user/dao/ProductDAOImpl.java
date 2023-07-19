package com.xworkz.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.user.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private EntityManagerFactory factory;

	public ProductDAOImpl() {
		super();
		System.out.println(" productdao is created ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean saveProduct(ProductDTO dto) {
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ProductDTO> readAllProduct() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createNamedQuery("readAllProduct");
		List resultList = query.getResultList();
		// TODO Auto-generated method stub
		return resultList;
	}

	@Override
	public List<ProductDTO> readProductByName(String name) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createNamedQuery("readProductByName");
		query.setParameter("name", name);
		List resultList = query.getResultList();

		// TODO Auto-generated method stub
		return resultList;
	}

//	   @Override
//	public Boolean updateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStock(String productName,
//			String category, Double price, String image, String updatedBy, String mail) {
//		   
//		   EntityManager manager = factory.createEntityManager();
//		   try {
//			EntityTransaction transaction = manager.getTransaction();
//			   transaction.begin();
//			   Query query = 
//manager.createNamedQuery("updateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStockUserMailId");
//			   query.setParameter("name", productName);
//			   query.setParameter("category", category);
//			   query.setParameter("price", price);
//			   query.setParameter("image", image);
//			   query.setParameter("updatedBy", updatedBy);
//			   query.setParameter("mail", mail);
//			   int executeUpdate = query.executeUpdate();
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//				
//			return false;	
//				
//	}
	@Override
	public List<ProductDTO> readProductByCategory(String category) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createNamedQuery("readProductByName");
		query.setParameter("name", category);
		List resultList = query.getResultList();

		// TODO Auto-generated method stub
		return resultList;
	}

}
