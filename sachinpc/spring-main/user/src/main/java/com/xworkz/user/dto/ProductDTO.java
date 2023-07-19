package com.xworkz.user.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
@NamedQueries({ @NamedQuery(name = "readAllProduct", query = "select info from ProductDTO info"),
		@NamedQuery(name = "readProductByName", query = "select info from ProductDTO info where info.productName=:name"),
	/*	@NamedQuery(name = "updateProductNameAndCategoryAndPriceAndImageAndUpdatedByAndNoOfStockUserMailId", query = "update ProductDTO info set info.productName=:name,info.category=:category,"
				+ "info.price=:price,info.image=:image,info.updatedBy=:updatedBy,info.noOfStock=:stock where info.userMailId=:mail")*/
				@NamedQuery(name = "readProductByCategory",query = "select info from ProductDTO info where info.category=:name")})
public class ProductDTO {
	@Id
	@GenericGenerator(name = "m", strategy = "increment")
	@GeneratedValue(generator = "m")
	private Integer id;
	private String productName;
	private String userMailId;
	private String category;
	private Double price;
	private String image;
	private String updatedBy;
	private Integer noOfStock;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Integer id, String productName, String userMailId, String category, Double price, String image,
			String updatedBy, Integer noOfStock) {
		super();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		this.id = id;
		this.productName = productName;
		this.userMailId = userMailId;
		this.category = category;
		this.price = price;
		this.image = image;
		this.updatedBy = updatedBy;
		this.noOfStock = noOfStock;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productName=" + productName + ", userMailId=" + userMailId + ", category="
				+ category + ", price=" + price + ", image=" + image + ", updatedBy=" + updatedBy + ", noOfStock="
				+ noOfStock + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getNoOfStock() {
		return noOfStock;
	}

	public void setNoOfStock(Integer noOfStock) {
		this.noOfStock = noOfStock;
	}

}