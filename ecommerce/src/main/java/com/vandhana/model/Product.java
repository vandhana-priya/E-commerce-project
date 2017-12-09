package com.vandhana.model;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	int productId;
	@NotEmpty(message="product name should not be empty")
	private String productName;
	@NotEmpty(message="give some product description")
	private String productDesc;
	
	private int stock;
	
	private int price;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
