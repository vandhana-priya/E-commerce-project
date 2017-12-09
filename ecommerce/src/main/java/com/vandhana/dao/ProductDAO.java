package com.vandhana.dao;
import java.util.List;
import com.vandhana.model.Product;

public interface ProductDAO {
	public Product addProduct(Product product);
    public void Products(Product product);
    public Product getProductById(int id); 
    public List<Product> getAllProduct();
    public void delete(int id);
}
